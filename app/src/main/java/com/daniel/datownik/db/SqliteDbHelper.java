package com.daniel.datownik.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Daniel on 23.02.2017.
 */

public class SqliteDbHelper extends SQLiteOpenHelper {
    public final static String DB_NAME = "parent.db";
    public final static int DB_VERSION = 1;
    public static final String TABLE_CHILDRENS = "childrens";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CHILDRENS
            + "("
            + COLUMN_ID
            + " integer primary key autoincrement, "
            +COLUMN_NAME
            + " text not null);";

    public SqliteDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SqliteDbHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHILDRENS);
        onCreate(db);
    }
}
