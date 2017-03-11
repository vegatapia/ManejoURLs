package mx.udg.valles.veganet.manejourls;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import mx.udg.valles.veganet.adapters.MoviesAdapter;
import mx.udg.valles.veganet.json_utilities.JsonParser;
import mx.udg.valles.veganet.listeners.NetworkConnectionInterface;
import mx.udg.valles.veganet.models.Movie;
import mx.udg.valles.veganet.network.NetworkConnection;

public class MainActivity extends AppCompatActivity implements NetworkConnectionInterface{

    private final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (RecyclerView)findViewById(R.id.listaPeliculas);
        lista.setLayoutManager(new GridLayoutManager(this, 2));
        lista.setHasFixedSize(true);

        NetworkConnection connection = new NetworkConnection(this, this);
        connection.execute();
    }

    @Override
    public void OnSuccesfullyResponse(String response) {

        ArrayList<Movie> peliculas = JsonParser.getMovies(this, response);
        MoviesAdapter adapter = new MoviesAdapter(this, peliculas);
        lista.setAdapter(adapter);

    }

    @Override
    public void OnFailedResponse() {

    }
}
