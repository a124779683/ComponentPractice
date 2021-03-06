package com.jhb.util;

import android.os.Environment;
import android.text.TextUtils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;

/**
 * @author 蒋洪波
 * @version 2.0
 * @file FileHelper.java
 * @brief 文件操作辅助类
 * @date 2017/11/30
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class FileUtil {
    private static String userID = "haha";
    private static String baseFilePath = Environment.getExternalStorageDirectory().toString() + "/filedownloader";
    private static String dowloadFilePath = baseFilePath  + "/FILETEMP";
    /**
     * 下载文件的临时路径
     */
    private static String tempDirPath = baseFilePath + "/TEMPDir";

    private static String[] wrongChars = {
            "/", "\\", "*", "?", "<", ">", "\"", "|"};

    // 创建文件
    public void newFile(File f) {
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建目录
     *
     * @param
     */
    public static void newDirFile(File f) {
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    // 获取一个文件列表的里的总文件大小
    public static double getSize(List<String> willupload) {
        return (double) getSizeUnitByte(willupload) / (1024 * 1024);
    }

    /**
     * 计算文件的大小，单位是字节
     *
     * @param willupload
     * @return
     */
    public static long getSizeUnitByte(List<String> willupload) {
        long allfilesize = 0;
        for (int i = 0; i < willupload.size(); i++) {
            File newfile = new File(willupload.get(i));
            if (newfile.exists() && newfile.isFile()) {
                allfilesize = allfilesize + newfile.length();
            }
        }
        return allfilesize;
    }

    /**
     * 获取默认文件存放路径
     */
    public static String getFileDefaultPath() {
        return dowloadFilePath;
    }

    /**
     * 获取下载文件的临时路径
     */
    public static String getTempDirPath() {
        return tempDirPath;
    }

    /**
     * 复制单个文件
     *
     * @param oldPath String  原文件路径  如：c:/fqf.txt
     * @param newPath String  复制后路径  如：f:/fqf.txt
     * @return boolean
     */
    public static boolean copyFile(String oldPath, String newPath) {
        boolean iscopy = false;
        InputStream inStream = null;
        FileOutputStream fs = null;
        try {
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) {  //文件存在时
                inStream = new FileInputStream(oldPath); //读入原文件
                fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1024];
                while ((byteread = inStream.read(buffer)) != -1) {
                    fs.write(buffer, 0, byteread);
                }
                iscopy = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return iscopy;
    }

    public static void setUserID(String newUserID) {
        userID = newUserID;
        dowloadFilePath = baseFilePath  + "/FILETEMP";
        tempDirPath = baseFilePath + "/TEMPDir";
    }

    public static String getUserID() {
        return userID;
    }

    /**
     * 过滤附件ID中某些不能存在在文件名中的字符
     */
    public static String filterIDChars(String attID) {
        if (attID != null) {
            for (int i = 0; i < wrongChars.length; i++) {
                String c = wrongChars[i];
                if (attID.contains(c)) {
                    attID = attID.replaceAll(c, "");
                }
            }
        }
        return attID;
    }

    /**
     * 安全删除文件.
     * @param file
     * @return
     */
    public static boolean deleteFileSafely(File file) {
        if (file != null) {
            String tmpPath = file.getParent() + File.separator + System.currentTimeMillis();
            File tmp = new File(tmpPath);
            file.renameTo(tmp);
            return tmp.delete();
        }
        return false;
    }

    /**
     * 获取过滤ID后的文件名
     */
    public static String getFilterFileName(String flieName) {
        if (flieName == null || "".equals(flieName)) {
            return flieName;
        }
        boolean isNeedFilter = flieName.startsWith("(");
        int index = flieName.indexOf(")");
        if (isNeedFilter && index != -1) {
            int startIndex = index + 1;
            int endIndex = flieName.length();
            if (startIndex < endIndex) {
                return flieName.substring(startIndex, endIndex);
            }
        }
        return flieName;
    }

    /**
     * get file name from url
     *
     * @param url
     * @return
     */
    public static String getFileNameByUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        int index = url.lastIndexOf('?');
        int index2 = url.lastIndexOf("/");
        if (index > 0 && index2 >= index) {
            return UUID.randomUUID().toString();
        }
        return url.substring(index2 + 1, index < 0 ? url.length() : index);
    }

    /**
     * get file extend name
     *
     * @param fileName
     * @return
     */
    public static String getFileExtendName(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        int index = fileName.lastIndexOf('.');
        if (index < 0) {
            return "unknown";
        } else {
            return fileName.substring(index + 1);
        }
    }

    public static boolean isFileExists(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }

        return new File(filePath).exists();
    }

    public static String convertStreamToString(InputStream input) {
                /*
          * To convert the InputStream to String we use the BufferedReader.readLine()
          * method. We iterate until the BufferedReader return null which means
          * there's no more data to read. Each line will appended to a StringBuilder
          * and returned as String.
          */
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
