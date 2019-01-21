package io.github.codepadawan93.asedamexamsubjectimplementation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.codepadawan93.asedamexamsubjectimplementation.Model.Article;

public class ArticleActivity extends AppCompatActivity {

    private ArrayList<Article> articles;
    private EditText title;
    private EditText firstPage;
    private EditText lasPage;
    private EditText noAuthors;
    private Button submitBtn;
    private Article addedArticle;
    private boolean isPreexisting;
    private Article currentArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        title = findViewById(R.id.title);
        firstPage = findViewById(R.id.first_page);
        lasPage = findViewById(R.id.last_page);
        noAuthors = findViewById(R.id.no_authors);
        submitBtn = findViewById(R.id.article_submit);

        articles = (ArrayList<Article>) getIntent().getSerializableExtra("articles");
        currentArticle = (Article) getIntent().getSerializableExtra("chosenArticle");

        isPreexisting = currentArticle != null;

        if(isPreexisting){
            populateArticle();
        }

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit(){
        String titleStr = title.getText().toString();
        String firstPageStr = firstPage.getText().toString();
        String lastPageStr = lasPage.getText().toString();
        String noAuthorsStr = noAuthors.getText().toString();
        try{
            int firstPageInt = Integer.parseInt(firstPageStr);
            int lastPageInt = Integer.parseInt(lastPageStr);
            int noAuthorsInt = Integer.parseInt(noAuthorsStr);
            if(firstPageInt <= 0 || lastPageInt <= 0 || noAuthorsInt <= 0){
                throw new Exception("Bad input data");
            } else {
                addedArticle = new Article(0, titleStr, firstPageInt, lastPageInt, noAuthorsInt);
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("isUpdate", true);
                intent.putExtra("addedArticle", addedArticle);
                intent.putExtra("articles", articles);
                startActivity(intent);
            }
        }catch (Exception e ){
            Toast.makeText(this, "Invalid input data, please revise.", Toast.LENGTH_LONG).show();
        }
    }

    private void populateArticle(){
        title.setText(currentArticle.getTitle()+"");
        firstPage.setText(currentArticle.getFirstPage()+"");
        lasPage.setText(currentArticle.getLastPage()+"");
        noAuthors.setText(currentArticle.getNoAuths()+"");
    }
}
