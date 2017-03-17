package com.jhb.dbmanager;


import android.util.Log;

import org.greenrobot.greendao.database.Database;

public class UpgradeManager {

    //记录各个数据库版本
    public static final int V1 = 1;

    public static void upgrade(Database db, int oldVersion, int newVersion) {
        Log.i("upgrade", oldVersion + " ---> " + newVersion);
        //此处要针对每一个数据版本进行一个处理
//        if (oldVersion == UpgradeManager.V1) {
//            upgrade1To2(db);
//        }
    }

    /**
     * 数据库从版本从1到2
     */

    private static void upgrade1To2(Database db) {
//        db.execSQL("ALTER TABLE INQUIRE_ESSENTIAL_INFO ADD GOODS_STYLE VARCHAR");
    }
}
