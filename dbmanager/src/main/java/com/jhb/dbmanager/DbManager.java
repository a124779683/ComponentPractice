package com.jhb.dbmanager;

import android.content.Context;
import android.database.sqlite.SQLiteException;

import com.jhb.dbmanager.entity.CheckInEntity;
import com.jhb.dbmanager.entity.CrashExceptionEntity;
import com.jhb.dbmanager.entity.SearchRecordEntity;
import com.shopin.android.db.gen.CheckInEntityDao;
import com.shopin.android.db.gen.CrashExceptionEntityDao;
import com.shopin.android.db.gen.DaoMaster;
import com.shopin.android.db.gen.DaoSession;
import com.shopin.android.db.gen.SearchRecordEntityDao;

import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.async.AsyncOperationListener;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DbManager implements IDBManager, AsyncOperationListener {

    /**
     * Class tag. Used for debug.
     */
    private static final String TAG = DbManager.class.getCanonicalName();
    /**
     * Instance of DbManager
     */
    private static DbManager instance;
    /**
     * The Android Activity reference for access to DbManager.
     */
    private Context context;
    private ReleaseOpenHelper mHelper;
    private Database database;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private AsyncSession asyncSession;
    private List<AsyncOperation> completedOperations;

    /**
     * Constructs a new DbManager with the specified arguments.
     * @param context The Android {@link Context}.
     */
    public DbManager(final Context context) {
        this.context = context;
        mHelper = new ReleaseOpenHelper(this.context, "database", null);
        completedOperations = new CopyOnWriteArrayList<>();
    }

    /**
     * @param context The Android {@link Context}.
     * @return this.instance
     */
    public static DbManager getInstance(Context context) {
        if (instance == null) {
            instance = new DbManager(context);
        }

        return instance;
    }

    @Override
    public void onAsyncOperationCompleted(AsyncOperation operation) {
        completedOperations.add(operation);
    }

    private void assertWaitForCompletion1Sec() {
        asyncSession.waitForCompletion(1000);
        asyncSession.isCompleted();
    }

    /**
     * Query for readable DB
     */
    public void openReadableDb() throws SQLiteException {
        database = mHelper.getWritableDb();
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
        asyncSession = daoSession.startAsyncSession();
        asyncSession.setListener(this);
    }

    /**
     * Query for writable DB
     */
    public void openWritableDb() throws SQLiteException {
        database = mHelper.getWritableDb();
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
        asyncSession = daoSession.startAsyncSession();
        asyncSession.setListener(this);
    }

    @Override
    public void closeDbConnections() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
        if (database != null && database.isDbLockedByCurrentThread()) {
            database.close();
        }
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
        if (instance != null) {
            instance = null;
        }
    }

    @Override
    public synchronized void dropDatabase() {
        try {
            openWritableDb();
            DaoMaster.dropAllTables(database, true); // drops all tables
            mHelper.onCreate(database);              // creates the tables
            asyncSession.deleteAll(CrashExceptionEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean deleteExceptionByDigest(String md5digest) {
        try {
            openReadableDb();
            CrashExceptionEntityDao dao = daoSession.getCrashExceptionEntityDao();
            dao.deleteByKey(md5digest);
            daoSession.clear();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public synchronized CrashExceptionEntity insertOrUpdateData(CrashExceptionEntity info) {
        try {
            if (info != null) {
                openWritableDb();
                daoSession.insertOrReplace(info);
                daoSession.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }


    @Override
    public List<CrashExceptionEntity> insertOrUpdateCrashExceptionEntity(List<CrashExceptionEntity> info) {

        try {
            if (info != null) {
                openWritableDb();
                CrashExceptionEntityDao exceptionEntityDao = daoSession.getCrashExceptionEntityDao();
                exceptionEntityDao.insertOrReplaceInTx(info);
                daoSession.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    @Override
    public List<CrashExceptionEntity> getUnuploadCrashExceptionEntity() {
        List<CrashExceptionEntity> info = null;
        try {
            openReadableDb();
            CrashExceptionEntityDao dao = daoSession.getCrashExceptionEntityDao();
            QueryBuilder<CrashExceptionEntity> builder = dao.queryBuilder().where(CrashExceptionEntityDao.Properties.UploadFlag.eq(new Boolean(false)));
            info = builder.list();
            daoSession.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    @Override
    public SearchRecordEntity insertOrUpdateData(SearchRecordEntity info) {
        try {
            if (info != null) {
                openWritableDb();
                daoSession.insertOrReplace(info);
                daoSession.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 只获取最近10条
     * @return
     */
    @Override
    public List<SearchRecordEntity> getSearchRecordEntity() {
        List<SearchRecordEntity> info = null;
        try {
            openReadableDb();
            SearchRecordEntityDao dao = daoSession.getSearchRecordEntityDao();
            QueryBuilder<SearchRecordEntity> builder = dao.queryBuilder().orderDesc(SearchRecordEntityDao.Properties.OccurDate).limit(10);
            info = builder.list();
            daoSession.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 只获取最近10条
     * @return
     */
    @Override
    public List<SearchRecordEntity> getSearchRecordEntity(String keyword) {
        List<SearchRecordEntity> info = null;
        try {
            openReadableDb();
            SearchRecordEntityDao dao = daoSession.getSearchRecordEntityDao();
            QueryBuilder<SearchRecordEntity> builder = dao.queryBuilder()
                    .where(SearchRecordEntityDao.Properties.Keyword.like("%" + keyword + "%"))
                    .orderDesc(SearchRecordEntityDao.Properties.OccurDate).limit(10);
            info = builder.list();
            daoSession.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    @Override
    public void deleteAllRecordEntity() {
        try {
            openReadableDb();
            SearchRecordEntityDao dao = daoSession.getSearchRecordEntityDao();
            dao.deleteAll();
            daoSession.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CheckInEntity insertCheckIn(CheckInEntity entity) {
        try {
            if (entity != null) {
                openWritableDb();
                daoSession.insertOrReplace(entity);
                daoSession.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<CheckInEntity> getCheckInThisMonth(String memberSid, String year, String month) {
        List<CheckInEntity> info = null;
        try {
            openReadableDb();
            CheckInEntityDao dao = daoSession.getCheckInEntityDao();
            QueryBuilder<CheckInEntity> builder = dao.queryBuilder()
                    .where(CheckInEntityDao.Properties.MemberSid.eq(memberSid),
                            CheckInEntityDao.Properties.Year.eq(year),
                            CheckInEntityDao.Properties.Month.eq(month));
            info = builder.list();
            daoSession.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }
}
