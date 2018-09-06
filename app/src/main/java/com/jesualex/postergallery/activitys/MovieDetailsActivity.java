package com.jesualex.postergallery.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.jesualex.postergallery.R;
import com.jesualex.postergallery.database.entitys.Movie;
import com.jesualex.postergallery.database.utils.MovieUtils;
import com.jesualex.postergallery.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends AppCompatActivity {
    private static final String MOVIE_ID_KEY = "movieId";

    @BindView(R.id.posterImage) ImageView posterImage;
    @BindView(R.id.movieDescription) TextView movieDescription;
    @BindView(R.id.movieTitle) TextView movieTitle;
    @BindView(R.id.toolbar) Toolbar toolbar;

    public static Intent getIntent(Activity activity, long movieId){
        Intent intent = new Intent(activity, MovieDetailsActivity.class);
        intent.putExtra(MOVIE_ID_KEY, movieId);
        return intent;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        Movie movie = MovieUtils.get(getIntent().getLongExtra(MOVIE_ID_KEY, 0));

        if(movie == null){
            finish();
            return;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            posterImage.setTransitionName(getString(R.string.posterTransitionName));
        }

        Picasso.get().load(Constants.POSTER_URL + movie.getPoster_path()).into(posterImage);

        movieTitle.setText(movie.getTitle());
        movieDescription.setText(movie.getOverview());
    }

    @Override public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
