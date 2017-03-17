package com.jhb.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 蒋洪波
 * @version 版本号
 * @file StringUtils.java
 * @brief 简要说明
 * 详细说明,如果没有请删除
 * @date 2017/10/12
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class StringUtils {

    /**
     * @param url
     * @return
     * @brief 保存URL地址最后的名称
     */
    public static String getUrlLastName(String url) {
        int i = url.lastIndexOf("/");
        String substring = url.substring(i + 1, url.length());
        //判断是否有非法字符
        if (substring.contains("?")) {
            int i1 = substring.indexOf("?");
            substring = substring.substring(0, i1);
        }
        return substring;
    }

    /**
     * @param phone
     * @return
     * @brief 处理座机号  清除“-”
     */
    public static String telephoneClearHorizontalLine(String phone) {
        String str = null;
        if (!TextUtils.isEmpty(phone)) {
            str = phone.replaceAll("-", "");
            str = str.replaceAll(" ", "");
        }
        return str;
    }

    /**
     * @brief String Utils 将String集合中的字符串用,号分隔并去掉空格返回一个字符串
     */
    public static String listSplitByComma(List<String> list) {
        return listSplitByChar(list, ',');
    }

    /**
     * @brief String Utils 将String集合中的字符串用指定的分隔并去掉空格返回一个字符串
     */
    public static String listSplitByChar(List<String> list, @NonNull char splitChar) {
        if (list.size() == 0)
            return null;
        String[] strings = list.toArray(new String[list.size()]);
        return join(strings, splitChar, 0, strings.length);
    }

    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return null;
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1);
        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    /**
     * 通过图片地址解析图片分辨率
     * @param pic
     * @return
     */
    public static float[] parseImgResolution(String pic) {
        try {
            if (!TextUtils.isEmpty(pic)) {
                float[] widthAndHeight = new float[2];
                if (pic.contains("_")) {
                    int begin = pic.lastIndexOf('_') + 1;//_前面+1开始截
                    int end = pic.lastIndexOf('.');
                    if (end > begin) {
                        String substring = pic.substring(begin, end);
                        String[] xes = substring.split("X");
                        if (xes.length == 2) {
                            //说明解析成功了
                            widthAndHeight[0] = Float.parseFloat(xes[0]);
                            widthAndHeight[1] = Float.parseFloat(xes[1]);
                            return widthAndHeight;
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测是否有emoji表情
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) { //如果不能匹配,则该字符是Emoji表情
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是Emoji
     * @param codePoint 比较的单个字符
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) ||
                (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000)
                && (codePoint <= 0x10FFFF));
    }

    /**
     * 检索出一段文字中的手机号
     * @param text
     * @return
     */
    public static String checkNum(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }
        Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[34578]\\d{9})|(?:861[34578]\\d{9}))(?!\\d)");
        Matcher matcher = pattern.matcher(text);
        StringBuffer bf = new StringBuffer(64);
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        return bf.toString();
    }

    /**
     * 拼接字符串操作
     * @param str
     * @return
     */
    public static String concat(Object... str) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            for (Object s : str) {
                sb.append(s.toString());
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * @param mobiles
     * @return
     * @biref 是否是手機號
     */
    public static boolean isMobileNO(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
        String telRegex = "[1][34578]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else
            return mobiles.matches(telRegex);
    }

    /**
     * @param t1
     * @return
     * @brief 验证密码是否符合要求
     */
    public static boolean validatePassword(String t1) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9`~!@#$%^&*()-_+=\",./<>?:'{}]{6,26}$");
        Matcher matcher = pattern.matcher(t1);
        return matcher.matches();
    }

    /**
     * @param t1
     * @return
     * @brief 字符串所占字符数
     */
    public static int charLength(String t1) {
        int len = 0;
        for (int i = 0; i < t1.length(); i++) {
            if (t1.codePointAt(i) > 127 || t1.codePointAt(i) == 94) {
                len += 2;
            } else {
                len++;
            }
        }
        return len;
    }


    /**
     * json 格式化
     * @param bodyString
     * @return
     */
    public static String jsonFormat(String bodyString) {
        String message;
        try {
            if (bodyString.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(bodyString);
                message = jsonObject.toString(4);
            } else if (bodyString.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(bodyString);
                message = jsonArray.toString(4);
            } else {
                message = bodyString;
            }
        } catch (JSONException e) {
            message = bodyString;
        }
        return message;
    }

    public static String[] splitAtSymbol(String name) {
        String[] split = name.split("@@@");
        return split;
    }
}
