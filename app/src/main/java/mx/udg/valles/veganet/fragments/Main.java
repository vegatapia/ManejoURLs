package mx.udg.valles.veganet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.udg.valles.veganet.adapters.MoviesAdapter;
import mx.udg.valles.veganet.json_utilities.JsonParser;
import mx.udg.valles.veganet.listeners.NetworkConnectionInterface;
import mx.udg.valles.veganet.manejourls.R;
import mx.udg.valles.veganet.models.Movie;
import mx.udg.valles.veganet.network.NetworkConnection;

/**
 * Created by veganet on 01/04/2017.
 */

public class Main extends Fragment implements NetworkConnectionInterface{

    private RecyclerView lista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.fragment_main, container, false);

        lista = (RecyclerView)viewFragment.findViewById(R.id.listaPeliculas);
        lista.setLayoutManager(new GridLayoutManager(getContext(), 2));
        lista.setHasFixedSize(true);

        NetworkConnection connection = new NetworkConnection(getContext(), this);
        connection.execute("popular");

        return viewFragment;
    }

    @Override
    public void OnSuccesfullyResponse(String response) {

        ArrayList<Movie> peliculas = JsonParser.getMovies(getContext(), response);
        MoviesAdapter adapter = new MoviesAdapter(getContext(), peliculas);
        lista.setAdapter(adapter);

    }

    @Override
    public void OnFailedResponse() {

    }
}
