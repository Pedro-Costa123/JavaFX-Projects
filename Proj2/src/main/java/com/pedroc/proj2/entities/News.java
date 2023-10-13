package com.pedroc.proj2.entities;

import java.util.Arrays;
import java.util.Objects;

public class News {
    //Gson gave error if they were private
    public String status;
    public int totalResults;
    public Article[] articles;

    public News() {
    }

    public News(String status, int totalResults, Article[] articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return totalResults == news.totalResults && Objects.equals(status, news.status) && Arrays.equals(articles, news.articles);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(status, totalResults);
        result = 31 * result + Arrays.hashCode(articles);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", articles=" + Arrays.toString(articles) +
                '}';
    }
}