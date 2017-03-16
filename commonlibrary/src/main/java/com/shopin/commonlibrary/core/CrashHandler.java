package com.shopin.commonlibrary.core;


/**
 * UncaughtExceptionHandler：线程未捕获异常控制器是用来处理未捕获异常的。 如果程序出现了未捕获异常默认情况下则会出现强行关闭对话框
 * 实现该接口并注册为程序中的默认未捕获异常处理 这样当未捕获异常发生时，就可以做些异常处理操作 例如：收集异常信息，发送错误报告 等。
 * <p/>
 * UncaughtException处理类,当程序发生Uncaught异常的时候,由该类来接管程序,并记录发送错误报告.
 */
public class CrashHandler extends AbsCrashHandler {

    public static final String TAG = "CrashHandler";
    private static CrashHandler INSTANCE;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        if (CrashHandler.INSTANCE == null) {
            CrashHandler.INSTANCE = new CrashHandler();
        }
        return CrashHandler.INSTANCE;
    }

    @Override
    public void saveCrash(Throwable throwable) {
//        String date = DateUtils.getTimeWithSec();
//        DbManager instance = DbManager.getInstance(AppLike.getInstance().getApplication());
//        CrashExceptionEntity entity = new CrashExceptionEntity();
//        entity.setIphoneModel(AppUtil.getMaker());
//        entity.setOccurDate(date);
//        entity.setUploadFlag(false);
//        String title = throwable.toString();
//        if (title.length() > 70) {
//            title = title.substring(0, 70);
//        }
//        entity.setModel(title);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            throwable.printStackTrace(new PrintStream(baos));
//            String errorMessage = baos.toString();
//            entity.setMd5Summary(EncryptUtil.MD5Encode(errorMessage, AppConfig.ENCODING));
//            entity.setErrorMsg(errorMessage);
//            instance.insertOrUpdateData(entity);
//            LogUtil.e(TAG, errorMessage);
//            baos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            LogUtil.e(TAG, "insert error ex");
//        } finally {
//            //杀死我们进程
//            AppUtil.shutDownApp();
//        }
    }
}