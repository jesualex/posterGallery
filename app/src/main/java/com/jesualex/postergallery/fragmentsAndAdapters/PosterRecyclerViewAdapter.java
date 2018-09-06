package com.jesualex.postergallery.fragmentsAndAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jesualex.postergallery.R;
import com.jesualex.postergallery.database.entitys.Movie;
import com.jesualex.postergallery.interfaces.PosterCallback;
import com.jesualex.postergallery.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PosterRecyclerViewAdapter extends RecyclerView.Adapter<PosterViewHolder> {
    private PosterCallback callback;

    private List<Movie> movies = new ArrayList<>();

    PosterRecyclerViewAdapter(PosterCallback callback){
        this.callback = callback;
    }

    public void updateItems(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
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
            if (callback != null) {
                callback.OnPosterClick(movie, holder.posterImage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
