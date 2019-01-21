package io.github.codepadawan93.asedamexamsubjectimplementation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.zip.Inflater;

import io.github.codepadawan93.asedamexamsubjectimplementation.Model.Article;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Article> articles;
    private ArrayList<Article> articlesFromJson;
    private int idUpdated;
    boolean isUpdate;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        Intent intent = null;
        switch (item.getItemId()){
            case R.id.add_article:
                intent = new Intent(this, ArticleActivity.class);
                intent.putExtra("articles", articles);
                break;
            case R.id.list_of_articles:
                intent = new Intent(this, ArticleListActivity.class);
                intent.putExtra("articles", articles);
                break;
            case R.id.extract_articles:
                intent = new Intent(this, ExtractArticleActivity.class);
                intent.putExtra("articles", articles);
                break;
            case R.id.report:
                intent = new Intent(this, ReportActivity.class);
                intent.putExtra("articles", articles);
                break;
            case R.id.about:
                Toast.makeText(this, "Made by Kovacs Erik Robert", Toast.LENGTH_LONG).show();
                break;
        }
        if(intent != null)
            startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idUpdated = getIntent().getIntExtra("idUpdated", -1);
        isUpdate = idUpdated != -1;
        articles = (ArrayList<Article>) getIntent().getSerializableExtra("articles");
        articlesFromJson = (ArrayList<Article>) getIntent().getSerializableExtra("articlesFromJson");

        if(articles == null){
            articles = new ArrayList<Article>();
        }

        if(articlesFromJson != null){
            for(Article article : articlesFromJson){
                articles.add(article);
            }
        }


        Intent intent = getIntent();
        Serializable addedArticle = intent.getSerializableExtra("addedArticle");
        if(addedArticle != null) {
            Article trueAddedArticle = (Article) addedArticle;
            if(isUpdate) {
                int i = 0;
                for(Article article : articles){
                    if(article.getId() == idUpdated){
                        break;
                    }
                    i++;
                }
                articles.remove(i);
                trueAddedArticle.setId(idUpdated);
                articles.add(trueAddedArticle);
            } else {
                trueAddedArticle.setId(articles.size());
                articles.add(trueAddedArticle);
            }
        }
    }
}
