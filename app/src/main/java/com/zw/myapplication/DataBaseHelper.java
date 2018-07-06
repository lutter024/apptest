package com.zw.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by zhiwei on 2018/6/28.
 */

public class DataBaseHelper extends SQLiteOpenHelper{
    //数据库名称
    private static final String DATABASE_NAME = "test.db";
    //数据库的版本号
    private static final int DATABASE_VERSION = 1;
    //表名
    private final String TABLE_NAME = "person" ;
    private final String COL_ID = "_id";
    private final String COL_NAME = "name" ;
    private final String COL_AGE = "age" ;
    private final String COL_INFO = "info" ;
    public DataBaseHelper(Context context) {
        //构造函数，直接调用父类的方法，CursorFactory设置为 null，使用默认的 游标工厂
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        // 参数说明
        // context：上下文对象
        // name：数据库名称
        // param：一个可选的游标工厂（通常是 Null）
        // version：当前数据库的版本，值必须是整数并且是递增的状态

        // 必须通过super调用父类的构造函数
        super(context, DATABASE_NAME, factory, 3);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);

    }

    /**
     * 创建数据库
     * @param db
     * 数据库存在 这个只会执行一次
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists ["+TABLE_NAME+"] "+"("+COL_ID+" integer primary key autoincrement, "
                +COL_NAME+" varchar, "
                +COL_AGE+" integer, "
                +COL_INFO+" text)" ;

        Log.i("info","create table = "+sql) ;
        db.execSQL(sql);
    }

//    CREATE TABLE AndroidTeam(
//            id INT PRIMARY KEY     NOT NULL,
//            name           TEXT    NOT NULL,
//            age            INT     NOT NULL,
//            address        CHAR(50),
//    money          REAL    DEFAULT 4500.0
//            );



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldeversion, int newversion) {
        //数据库升级，调用构造函数传入不同的version版本就可以进入数据升级
    }
}
