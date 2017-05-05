package com.daniel.datownik.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.daniel.datownik.db.Children.Childrens;
import com.daniel.datownik.db.Eat.Eats;

/**
 * Created by Daniel on 23.02.2017.
 */

public class SqliteDbHelper extends SQLiteOpenHelper implements Childrens, Eats {
    public final static String DB_NAME = "parent.db";
    public final static int DB_VERSION = 4;
    private static final String DATABASE_CHILDRENS_CREATE = "create table "
            + Childrens.TABLE_CHILDRENS
            + " ("
            + Childrens.COLUMN_ID_CHILDRENS
            + " integer primary key autoincrement, "
            + Childrens.COLUMN_NAME
            + " text not null, "
            + Childrens.COLUMN_DAY
            + " text not null, "
            + Childrens.COLUMN_MONTH
            + " text not null, "
            + Childrens.COLUMN_YEAR
            + " text not null)";

    private static final String DATABASE_EATS_CREATE = "create table "
            + Eats.TABLE_EATS
            + " ("
            + Eats.COLUMN_ID
            + " integer primary key autoincrement, "
            + Eats.COLUMN_DATETIME
            + " text not null, "
            + Eats.COLUMN_AMOUNT_OF_EATEN
            + " text not null, "
            + Eats.COLUMN_TYPE_FOOD
            + " text not null)";

    public SqliteDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CHILDRENS_CREATE);
        db.execSQL(DATABASE_EATS_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SqliteDbHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Childrens.TABLE_CHILDRENS);
        db.execSQL("DROP TABLE IF EXISTS " + Eats.TABLE_EATS);
        onCreate(db);
    }
}
