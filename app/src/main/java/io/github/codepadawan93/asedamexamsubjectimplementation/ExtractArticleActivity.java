package io.github.codepadawan93.asedamexamsubjectimplementation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import io.github.codepadawan93.asedamexamsubjectimplementation.Model.Article;
import io.github.codepadawan93.asedamexamsubjectimplementation.Network.JsonClient;

public class ExtractArticleActivity extends AppCompatActivity {

    private ArrayList<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract_article);
        articles = new ArrayList<>();

        JsonClientImpl client = new JsonClientImpl();
        client.execute();
    }

    class JsonClientImpl extends JsonClient {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            articles = super.getArticles();
            Intent intent = new Intent(ExtractArticleActivity.this, MainActivity.class);
            intent.putExtra("articles", getIntent().getSerializableExtra("articles"));
            intent.putExtra("articlesFromJson", articles);
            startActivity(intent);
        }
    }
}
