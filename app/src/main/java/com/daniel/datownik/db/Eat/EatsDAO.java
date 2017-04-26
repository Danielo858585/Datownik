package com.daniel.datownik.db.Eat;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.daniel.datownik.db.SqliteDbHelper;

/**
 * Created by Daniel on 05.04.2017.
 */

public class EatsDAO {

    private SQLiteDatabase sqLiteDatabase;
    private SqliteDbHelper sqliteDbHelper;

    private String[] allColumns = {sqliteDbHelper.COLUMN_TYPE_FOOD, sqliteDbHelper.COLUMN_AMOUNT_OF_EATEN, sqliteDbHelper.COLUMN_ID, sqliteDbHelper.COLUMN_DATETIME};

    public EatsDAO(Context context) {
        sqliteDbHelper = new SqliteDbHelper(context);
    }
    public void open() throws SQLException {
        sqLiteDatabase = sqliteDbHelper.getWritableDatabase();
    }

    public void close(){
        sqliteDbHelper.close();
    }




}
