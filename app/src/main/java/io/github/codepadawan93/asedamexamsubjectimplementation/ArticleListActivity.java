package io.github.codepadawan93.asedamexamsubjectimplementation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import io.github.codepadawan93.asedamexamsubjectimplementation.Model.Article;

public class ArticleListActivity extends AppCompatActivity {

    private ListView articleList;
    private ArrayList<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        articleList = findViewById(R.id.article_list);

        Intent intent = getIntent();
        articles = (ArrayList<Article>) intent.getSerializableExtra("articles");
        articleList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleItemClick(position);
            }
        });
        populateArticles(articles);
    }

    private void populateArticles(ArrayList<Article> articles){
        ArrayList<String> stringArticles = new ArrayList<String>();
        for(Article article : articles){
            stringArticles.add(article.getTitle());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, stringArticles);
        articleList.setAdapter(adapter);
    }

    private void handleItemClick(int index){
        Article chosenArticle = articles.get(index);
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra("isPreexisting", true);
        intent.putExtra("chosenArticle", chosenArticle);
        startActivity(intent);
    }
}
