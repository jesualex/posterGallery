package com.jesualex.postergallery.database.entitys;

import java.util.List;

/**
 * Created by jesualex
 * Date: 05-09-18
 */

public class Response<T> {
    private long page;
    private long total_results;
    private long total_pages;
    private List<T> results;

    public Response() { }

    public Response(long page, long total_results, long total_pages, List<T> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(long total_results) {
        this.total_results = total_results;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
