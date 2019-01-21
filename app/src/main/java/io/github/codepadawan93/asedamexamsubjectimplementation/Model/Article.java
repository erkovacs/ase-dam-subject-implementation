package io.github.codepadawan93.asedamexamsubjectimplementation.Model;

import java.io.Serializable;

public class Article implements Serializable {
    private long id;
    private String title;
    private int firstPage;
    private int lastPage;
    private int noAuths;

    public Article(){}

    public Article(long id, String title, int firstPage, int lastPage, int noAuths) {
        this.id = id;
        this.title = title;
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.noAuths = noAuths;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getNoAuths() {
        return noAuths;
    }

    public void setNoAuths(int noAuths) {
        this.noAuths = noAuths;
    }
}
