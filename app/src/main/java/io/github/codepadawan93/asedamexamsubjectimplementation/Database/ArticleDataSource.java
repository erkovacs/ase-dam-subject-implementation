package io.github.codepadawan93.asedamexamsubjectimplementation.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import io.github.codepadawan93.asedamexamsubjectimplementation.Model.Article;

public class ArticleDataSource {
    private SQLiteDatabase db;
    private ArticleDB helper;

    public ArticleDataSource(Context context){
        helper = new ArticleDB(context);
    }

    public int addArticle(Article article){
        ContentValues cv = new ContentValues();
        cv.put(ArticleTable.COLUMN_TITLE, article.getTitle());
        cv.put(ArticleTable.COLUMN_FIRST_PAGE, article.getFirstPage());
        cv.put(ArticleTable.COLUMN_LAST_PAGE, article.getLastPage());
        cv.put(ArticleTable.COLUMN_NO_AUTHS, article.getNoAuths());
        long id = db.insert(ArticleTable.TABLE_NAME, null, cv);
        return (int)id;
    }

    public void open(){
        db = helper.getWritableDatabase();
    }

    public void close(){
        helper.close();
    }

    public ArrayList<Article> getAllArticles(){
        ArrayList<Article> articles = new ArrayList<Article>();
        Cursor cursor = db.query(ArticleTable.TABLE_NAME, null, null, null, null, null, null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Article article = new Article(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                articles.add(article);
                cursor.moveToNext();
            }
        }
        return articles;
    }
}
