package com.daniel.datownik.db.Eat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.daniel.datownik.db.SqliteDbHelper;

import java.util.ArrayList;
import java.util.List;

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

    public void insertEat (String typeFood, String amountFood, String dateTime){
        ContentValues contentValues = new ContentValues();
        contentValues.put(sqliteDbHelper.COLUMN_AMOUNT_OF_EATEN,amountFood);
        contentValues.put(sqliteDbHelper.COLUMN_TYPE_FOOD,typeFood);
        contentValues.put(sqliteDbHelper.COLUMN_DATETIME,dateTime);
        sqliteDbHelper.getWritableDatabase().insert(Eats.TABLE_EATS,null,contentValues);

    }

    public List<Eat> getAllEats(){
        List<Eat> eats = new ArrayList<Eat>();
        Cursor cursor = sqLiteDatabase.query(sqliteDbHelper.TABLE_EATS,allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Eat eat = cursorToEat(cursor);
            eats.add(eat);
            cursor.moveToNext();
        }
        cursor.close();
        return eats;
    }

    private Eat cursorToEat(Cursor cursor) {
        Eat eat = new Eat();
        eat.setTypeOfFood(cursor.getString(1));
        eat.setAmountOfEaten(cursor.getString(2));
        eat.setDate(cursor.getString(3));
        return eat;
    }


}
