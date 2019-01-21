package io.github.codepadawan93.asedamexamsubjectimplementation.Network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import io.github.codepadawan93.asedamexamsubjectimplementation.Model.Article;

public class JsonClient extends AsyncTask<String, String, String> {
    private static final String URL = "https://api.myjson.com/bins/dpeuk";
    private ArrayList<Article> parsedArticles;
    public JsonClient(){
        super();
        parsedArticles = new ArrayList<>();
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(JsonClient.URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            parsedArticles = parseJson(in);
        }
        catch (Exception e){
            Log.d("JSON_CLIENT", e.getMessage());
        }
        finally {
            if(urlConnection != null)
                urlConnection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    private ArrayList<Article> parseJson(InputStream in) throws IOException, JSONException {
        ArrayList<Article> articles = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()){
            sb.append(scanner.next() + " ");
        }
        JSONObject json = new JSONObject(sb.toString());
        JSONArray jsonArticles = json.getJSONArray("articles");
        for (int i = 0; i < jsonArticles.length(); i++){
            JSONObject jsonArticle = jsonArticles.getJSONObject(i);
            articles.add(
                    new Article(
                            jsonArticle.getInt("id"),
                            jsonArticle.getString("title"),
                            jsonArticle.getInt("firstPage"),
                            jsonArticle.getInt("lastPage"),
                            jsonArticle.getInt("noAuths")
                    )
            );
        }
        return articles;
    }

    public ArrayList<Article> getArticles(){
        return parsedArticles;
    }
}
