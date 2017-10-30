package com.example.gaurav.studinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gaurav on 30/10/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "studinfo.db";
    public static final String TABLE_NAME = "admin_details";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "password";
    public static final String COL_5 = "confirm_pwd";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME +"(id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT, email TEXT, password TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
            onCreate(db);
    }
}
