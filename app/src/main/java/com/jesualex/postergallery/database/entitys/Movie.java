package com.jesualex.postergallery.database.entitys;

import com.jesualex.postergallery.utils.LongArrayConverter;

import java.util.Date;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by jesualex
 * Date: 05-09-18
 */

@Entity
public class Movie {
    @Id(assignable = true) private long id;
    private long vote_count;

    @Convert(converter = LongArrayConverter.class, dbType = String.class) private long[] genre_ids;

    private boolean video;
    private boolean adult;

    private float vote_average;
    private float popularity;

    private String title;
    private String poster_path;
    private String original_language;
    private String original_title;
    private String backdrop_path;
    private String overview;

    private Date release_date;

    public Movie() { }

    public Movie(long id, long vote_count, long[] genre_ids, boolean video, boolean adult, float vote_average, float popularity, String title, String poster_path, String original_language, String original_title, String backdrop_path, String overview, Date release_date) {
        this.id = id;
        this.vote_count = vote_count;
        this.genre_ids = genre_ids;
        this.video = video;
        this.adult = adult;
        this.vote_average = vote_average;
        this.popularity = popularity;
        this.title = title;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.release_date = release_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public long[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(long[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}
