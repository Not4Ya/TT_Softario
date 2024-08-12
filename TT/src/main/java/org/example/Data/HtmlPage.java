package org.example.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HtmlPage {
    private String url;
    private String htmlCode;
    private final ArrayList<Statuses> statuses = new ArrayList<>( );

    public HtmlPage(String url, String htmlCode, Statuses... status) {
        this.url = url;
        this.htmlCode = htmlCode;
        this.statuses.addAll(List.of(status));
    }

    public HtmlPage(String url){
        this.url = url;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HtmlPage htmlPage = (HtmlPage) o;
        return this.getUrl().equals(htmlPage.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }
}
