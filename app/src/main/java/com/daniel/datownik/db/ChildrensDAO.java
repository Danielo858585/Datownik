package com.daniel.datownik.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 25.02.2017.
 */

public class ChildrensDAO {
    private SQLiteDatabase sqLiteDatabase;
    private SqliteDbHelper sqliteDbHelper;
    private String [] allColumns = {sqliteDbHelper.COLUMN_ID, sqliteDbHelper.COLUMN_NAME, sqliteDbHelper.COLUMN_DAY, sqliteDbHelper.COLUMN_MONTH, sqliteDbHelper.COLUMN_YEAR};

    public ChildrensDAO(Context context){
        sqliteDbHelper = new SqliteDbHelper(context);
    }

    public void open() throws SQLException {
        sqLiteDatabase = sqliteDbHelper.getWritableDatabase();
    }

    public void close(){
        sqliteDbHelper.close();
    }

    public void insertChild(String name, String day, String month, String year){
        ContentValues values = new ContentValues();
        values.put(sqliteDbHelper.COLUMN_NAME,name.toString());
        values.put(sqliteDbHelper.COLUMN_DAY,day.toString());
        values.put(sqliteDbHelper.COLUMN_MONTH,month.toString());
        values.put(sqliteDbHelper.COLUMN_YEAR,year.toString());
        sqliteDbHelper.getWritableDatabase().insert(Childrens.TABLE_CHILDRENS, null, values);




//        long insertId = sqLiteDatabase.insert(sqliteDbHelper.TABLE_CHILDRENS,null,values);
//        Cursor cursor = sqLiteDatabase.query(sqliteDbHelper.TABLE_CHILDRENS,allColumns,sqliteDbHelper.COLUMN_ID + " = "
//        + insertId,null,null,null,null);
//        cursor.moveToFirst();
//        Children children = cursonToChild(cursor);
//        cursor.close();
//        return children;
    }

    public List<Children> getAllChildrens(){
        List<Children> childrens = new ArrayList<Children>();
        Cursor cursor = sqLiteDatabase.query(sqliteDbHelper.TABLE_CHILDRENS,allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Children children = cursonToChild(cursor);
            childrens.add(children);
            cursor.moveToNext();
        }
        cursor.close();
        return childrens;
    }

    private Children cursonToChild(Cursor cursor) {
        Children children = new Children();
        children.setId(cursor.getInt(0));
        children.setName(cursor.getString(1));
        children.setDayOfBirth(cursor.getString(2));
        children.setMonthOfBirth(cursor.getString(3));
        children.setYearOfBirth(cursor.getString(4));
        return children;
    }
}
