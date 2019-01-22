package io.github.codepadawan93.asedamexamsubjectimplementation.Database;

import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;

public class ArticleTable {
    public static final String TABLE_NAME = "article";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_FIRST_PAGE = "first_page";
    public static final String COLUMN_LAST_PAGE = "last_page";
    public static final String COLUMN_NO_AUTHS = "no_auths";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_TITLE + " VARCHAR(128), " +
            COLUMN_FIRST_PAGE + " INTEGER, " +
            COLUMN_LAST_PAGE + " INTEGER, " +
            COLUMN_NO_AUTHS + " INTEGER )";

    public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    public static void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase db){
        db.execSQL(SQL_DROP_TABLE);
        db.execSQL(SQL_CREATE_TABLE);
    }
}
