package com.pedroc.proj2;

import com.pedroc.proj2.entities.Article;
import com.pedroc.proj2.entities.News;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import javafx.scene.control.ListView;

public class Controller implements Initializable {

    @FXML
    private ListView<String> id_topNews;

    private News topHeadlinesNews;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getNews();
    }

    private void getNews() {

        String url = "https://newsapi.org/v2/top-headlines?country=pt&apiKey=" + Dotenv.load().get("API_KEY");

        try {
            httpRequest(new URL(url));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private void httpRequest(URL url) {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.getResponseMessage();

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            Gson gson = new Gson();

            topHeadlinesNews = gson.fromJson(builder.toString(), News.class);
            for (Article article : topHeadlinesNews.getArticles()) {
                id_topNews.getItems().add(article.niceView());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}