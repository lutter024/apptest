package com.zw.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiwei on 2018/6/28.
 */

public class SQLHelp {

    private final String COL_ID = "_id";
    private final String COL_NAME = "name" ;
    private final String COL_AGE = "age" ;
    private final String COL_INFO = "info" ;
    DataBaseHelper dataBaseHelper = null;
    private SQLiteDatabase db ;
    public void oncreate(Context context){
        dataBaseHelper = new DataBaseHelper(context);
        db = dataBaseHelper.getWritableDatabase();
    }

    public void add(Person p) {
        db.beginTransaction();
        try {
            //db.execSQL("INSERT INTO person VALUES(null, ?, ?, ?)", new Object[]{p.name, p.age, p.info});
            //db.execSQL("INSERT INTO person(name, age, info) VALUES('zhiwei',16, 'test')");
            //db.setTransactionSuccessful();  //设置事务成功完成
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("name", "zhenwu");
//            contentValues.put("age", 12);
//            contentValues.put("info", "aaaa");
//            db.insertOrThrow("person", null, contentValues);
//            db.execSQL("INSERT INTO person(name, age, info) VALUES('zw',16, 'test1')");
//            db.execSQL("INSERT INTO person(name, age, info) VALUES('zzzr',11, 'test2')");
            db.execSQL("INSERT OR IGNORE INTO person(name, age, info) VALUES('zw',16, 'test1')");
            //db.execSQL("INSERT INTO personw(name, age, info) VALUES('zzeq',9, 'test4')");
            db.execSQL("INSERT INTO presonw(name, info) VALUES('aaaa111', 'trsss')");
            db.setTransactionSuccessful();
        } finally{
            db.endTransaction();    //结束事务
        }
    }

    public void update(){
        //String data = "update person set name ='danxia',age='11' where _id=1 and info='test'";
        db.beginTransaction();
        //db.execSQL(data);
        ContentValues contentValues = new ContentValues();
        contentValues.put("age", 80);
        db.update("person", contentValues, "_id=? and info=?", new String[]{"2", "aaaa"});
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void look(){
        db.beginTransaction();
        String data = "select * from person where name like ?";
        //String data = "select count(id) from person where name like 'z'";//计算
        //String data = "select name,age from person where name like 'z'";//选择队列
        Cursor c = db.rawQuery(data, new String[]{"zh%"});
        int id = c.getCount();
        List<Person> persons = new ArrayList<Person>();
        if(null != c && c.getCount() > 0){
            while(c.moveToNext()){
                Person person = new Person() ;
                person._id = c.getInt(c.getColumnIndex("_id"));
                person.name = c.getString(c.getColumnIndex("name"));
                person.age = c.getInt(c.getColumnIndex("age"));
                person.info = c.getString(c.getColumnIndex("info"));
                persons.add(person);
            }
        }
        c.close();
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void delete(){
        String data = "delete from person where _id = 7";
        db.delete("person", "_id = ?", new String[]{"2"});
    }

    public void createtable(){
        db.beginTransaction();
        //删除表
//        String sql = "drop table if exists presonw";
//        db.execSQL(sql);
        //创建表格
        String sql2 ="create table if not exists presonw "+"("+COL_ID+" integer primary key autoincrement, "
                +COL_NAME+" varchar not null, "
                +COL_AGE+" integer default 133, "
                +COL_INFO+" text)";
        db.execSQL(sql2);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void addCol(){
        db.beginTransaction();
        //删除表
        //String sql = "ALTER TABLE personw ADD source INTEGER DEFAULT 0, time TEXT, dura TEXT";
        String sql = "ALTER TABLE personw ADD source INTEGER DEFAULT 0";
        db.execSQL(sql);
        //创建表格
        db.setTransactionSuccessful();
        db.endTransaction();
    }


    public class Person {
        public int _id;
        public  String name;
        public int age;
        public  String  info;

        public Person() {
        }

        public Person(String name, int age,String info) {
            this.name = name;
            this.age = age;
            this.info = info;
        }
    }

    public void close(){
        if(db != null){
            db.close();
        }
    }
}
