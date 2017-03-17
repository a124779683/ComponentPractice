package com.jhb.dbmanager;


import com.jhb.dbmanager.entity.CheckInEntity;
import com.jhb.dbmanager.entity.CrashExceptionEntity;
import com.jhb.dbmanager.entity.SearchRecordEntity;

import java.util.List;

/**
 * @author 蒋洪波
 * @version 2.0
 * @file IDBManager.java
 * @brief 数据库操作接口
 * @date 2017/3/7
 * Copyright (c) 2017
 * All rights reserved.
 */
public interface IDBManager {


    void closeDbConnections();

    void dropDatabase();

    boolean deleteExceptionByDigest(String md5digest);

    CrashExceptionEntity insertOrUpdateData(CrashExceptionEntity info);

    List<CrashExceptionEntity> insertOrUpdateCrashExceptionEntity(List<CrashExceptionEntity> info);

    List<CrashExceptionEntity> getUnuploadCrashExceptionEntity();

    SearchRecordEntity insertOrUpdateData(SearchRecordEntity info);

    List<SearchRecordEntity> getSearchRecordEntity();

    List<SearchRecordEntity> getSearchRecordEntity(String keyword);

    void deleteAllRecordEntity();

    CheckInEntity insertCheckIn(CheckInEntity entity);

    List<CheckInEntity> getCheckInThisMonth(String memberSid,String year,String month);
}
