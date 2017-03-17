package com.shopin.commonlibrary.mvp;

import android.app.Activity;
import android.os.Bundle;

import com.shopin.commonlibrary.widget.dialog.TipDialog;

/**
 * @author 蒋洪波
 * @file GlobalDialogActivity.java
 * @brief 导航界面
 * @date 2017-12-10
 * Copyright (c) 2017, 上品折扣[]
 * All rights reserved.
 */
public class GlobalDialogActivity extends Activity {

    public static final int INTENT_UNDEFINED = -1;
    public static final int INVALIDATE_TOKEN = 1;
    public static final int UPGRADE = 2;
    public static final int CUSTOM = 3;
    public static final int FIX_TIME = 4;
    public static final String INTENT = "intent";
    public static final String CONTENT = "content";

    TipDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        // 隐藏状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        setContentView(R.layout.fragment_exit);
//        ActivityUtil.getInstance().addActivity(this);
//        int intExtra = getIntent().getIntExtra(INTENT, INTENT_UNDEFINED);
//        if (intExtra != INTENT_UNDEFINED) {
//
//            dialog = new TipDialog(this);
//
//            if (dialog.isShowing()) {
//                dialog.dismiss();
//                dialog.show();
//            } else {
//                dialog.show();
//            }
//            //一定放后面
//            dialog.setCanceledOnTouchOutside(false);
//            switch (intExtra) {
//                case INVALIDATE_TOKEN://token过期 重新登陆
//
//                    String errorMessage = getIntent().getStringExtra(BaseEntity.ERROR_MESSAGE);
//
//                    dialog.setTitle(getString(R.string.mention));
//                    if (!TextUtils.isEmpty(errorMessage))
//                        dialog.setTip(errorMessage);
//                    else
//                        dialog.setTip(getString(R.string.login_mention));
//
//                    dialog.hideClose();
//                    dialog.setCancelable(false);
//                    dialog.setBtn(getString(R.string.login), new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            dialog.dismiss();
//                            Intent intent = new Intent(AppLike.getContext(), LRDActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(intent);
//                            AccountUtils.clearUserInfo();
//                            ActivityUtil.finishAllActivity();
//                        }
//                    });
//                    break;
//                case UPGRADE:
//                    dialog.setCancelable(false);
//                    EventBus.getDefault().register(this);
//                    break;
//                case CUSTOM:
//                    String title = getIntent().getStringExtra("title");
//                    String content = getIntent().getStringExtra(CONTENT);
//                    if (!TextUtils.isEmpty(content)) {
//                        if (TextUtils.isEmpty(title)) {
//                            title = getString(R.string.mention);
//                        }
//                        dialog.setTitle(title);
//                        dialog.setTip(content);
//                    }
//                    dialog.hideClose();
//                    dialog.setCancelable(false);
//                    dialog.setBtn(getString(R.string.exit), new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            dialog.dismiss();
//                            //暂停所有下载
//                            DownloadProvider provider = DownloadManager.getInstance().getConfig().getProvider(DownloadManager.getInstance());
//                            String selection = DownloadTask.TASK_TYPE + "= ? AND " + DownloadTask.STATUS + " <= ?";
//                            String[] selectionArgs = new String[]{String.valueOf(Constants.TASK_APP), String.valueOf(DownloadTask.STATUS_RUNNING)};
//
//                            List<DownloadTask> allDownloadTask = provider.findAllDownloadTask(null, selection, selectionArgs, null, null, null);
//                            for (DownloadTask task : allDownloadTask) {
//                                DownloadManager.getInstance().pauseDownload(task, null);
//                            }
//                            ActivityUtil.finishAllActivity();
////                            AppUtil.shutDownApp();
//                        }
//                    });
//                    break;
//            }
//        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        UIUtils.closeDialog(dialog);
//        EventBus.getDefault().unregister(this);
//        ActivityUtil.getInstance().finishActivity(this);
//    }

//    @Subscribe(sticky = true)
//    public void onEventMainThread(final UpgradeEvent event) {
//        dialog.setTitle(ResourceUtil.getString(R.string.mention));
//        //这里还要拼接一下字符串
//        dialog.setTip(ResourceUtil.getString(R.string.upgrade_mention, event.getResult().getVersionName()));
//        dialog.hideClose();
//        dialog.setBtn(ResourceUtil.getString(R.string.iknow), new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                String apkPath = event.getApkPath();
//                new ForceUpdateTask(GlobalDialogActivity.this).execute(event.getResult().getUrl(), apkPath);
//            }
//        });
//    }

}
