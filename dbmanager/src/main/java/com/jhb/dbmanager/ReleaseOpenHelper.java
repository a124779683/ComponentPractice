package com.jhb.dbmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.shopin.android.db.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;


public class ReleaseOpenHelper extends DaoMaster.OpenHelper {

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        UpgradeManager.upgrade(db, oldVersion, newVersion);
        DaoMaster.createAllTables(db, true);//不存在建表，针对那些
    }
}