package mx.udg.valles.veganet.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.udg.valles.veganet.manejourls.Detail;
import mx.udg.valles.veganet.manejourls.R;
import mx.udg.valles.veganet.models.Movie;

/**
 * Created by veganet on 11/03/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Movie> movies;
    private boolean isTablet = false;

    public MoviesAdapter(Context context, ArrayList<Movie> movies, boolean isTablet){

        this.movies = movies;
        this.context = context;
        this.isTablet = isTablet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Picasso.with(context).load(movies.get(position).getPoster_path())
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isTablet){
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("PeliculaSeleccionada", movies.get(position));
                context.startActivity(intent);
            }else{

                }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        final ImageView image;

        public ViewHolder(View view){
            super(view);
            image = (ImageView)view.findViewById(R.id.imageMoviePoster);
        }
    }
}
