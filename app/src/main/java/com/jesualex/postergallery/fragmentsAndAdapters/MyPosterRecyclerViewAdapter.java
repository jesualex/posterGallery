package com.jesualex.postergallery.fragmentsAndAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jesualex.postergallery.R;
import com.jesualex.postergallery.database.entitys.Movie;
import com.jesualex.postergallery.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyPosterRecyclerViewAdapter extends RecyclerView.Adapter<PosterViewHolder> {

    private final List<Movie> movies;
    //private final OnListFragmentInteractionListener mListener;

    public MyPosterRecyclerViewAdapter(List<Movie> items) {
        movies = items;
        //mListener = listener;
    }

    @Override
    public PosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_poster, parent, false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PosterViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Picasso.get().load(Constants.POSTER_URL + movie.getPoster_path()).into(holder.posterImage);

        holder.view.setOnClickListener( v -> {
/*            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.mItem);
            }*/
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
