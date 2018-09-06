package com.jesualex.postergallery.fragmentsAndAdapters;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jesualex.postergallery.R;
import com.jesualex.postergallery.activitys.MovieDetailsActivity;
import com.jesualex.postergallery.database.viewModels.MovieViewModel;


public class PosterFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int columnCount = 3;

    public PosterFragment() { }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            columnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poster_list, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        // Set the adapter
        if (view instanceof RecyclerView && activity != null) {
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new GridLayoutManager(activity, columnCount));

            PosterRecyclerViewAdapter posterRecyclerViewAdapter =  new PosterRecyclerViewAdapter((movie, poster) -> {
                Intent intent = MovieDetailsActivity.getIntent(activity, movie.getId());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity, poster, getString(R.string.posterTransitionName));
                    startActivity(intent, options.toBundle());
                }
                else {
                    startActivity(intent);
                }
            });

            recyclerView.setAdapter(posterRecyclerViewAdapter);

            MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

            movieViewModel.getAllMovies().observe(this, posterRecyclerViewAdapter::updateItems);
        }
        return view;
    }
}
