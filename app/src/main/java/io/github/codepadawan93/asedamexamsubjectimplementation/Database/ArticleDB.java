package io.github.codepadawan93.asedamexamsubjectimplementation.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ArticleDB extends SQLiteOpenHelper {
    public static final String DATABASE = "AseDamSubjectImplementation.db";
    public static final int VERSION = 1;

    public ArticleDB(Context context){
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ArticleTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        ArticleTable.onUpgrade(db);
    }
}
