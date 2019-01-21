package io.github.codepadawan93.asedamexamsubjectimplementation;

import android.graphics.RectF;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

import io.github.codepadawan93.asedamexamsubjectimplementation.CustomView.LineChart;
import io.github.codepadawan93.asedamexamsubjectimplementation.Model.Article;

public class ReportActivity extends AppCompatActivity {

    private ArrayList<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        articles = (ArrayList<Article>) getIntent().getSerializableExtra("articles");
        if(articles != null){
            ArrayList<Double> xvals = new ArrayList<>();
            ArrayList<Double> yvals = new ArrayList<>();
            for (Article article : articles){
                xvals.add((double)article.getId());
                yvals.add((double)article.getNoAuths());
            }
            ConstraintLayout cl = findViewById(R.id.bar_chart_support);
            LineChart bc = new LineChart(this, cl, xvals, yvals);
            cl.addView(bc);
        }
    }
}
