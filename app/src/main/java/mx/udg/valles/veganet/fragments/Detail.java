package mx.udg.valles.veganet.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mx.udg.valles.veganet.listeners.NetworkConnectionInterface;
import mx.udg.valles.veganet.manejourls.R;
import mx.udg.valles.veganet.models.Movie;
import mx.udg.valles.veganet.network.NetworkConnection;

/**
 * Created by veganet on 01/04/2017.
 */

public class Detail extends Fragment {

    private final String TAG = Detail.class.getSimpleName();
    private Movie pelicula;
    private NetworkConnection connection;
    private boolean isTablet = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isTablet = getActivity().getIntent().getBooleanExtra("tag", false);
        if(!isTablet) {
            pelicula = getActivity().getIntent().getParcelableExtra("PeliculaSeleccionada");
            connection = new NetworkConnection(getContext(), new NetworkConnectionInterface() {
                @Override
                public void OnSuccesfullyResponse(String response) {
                    //TODO: Parsear los datos de esta llamada y mandar a llamar a los reviews
                    connection = new NetworkConnection(getContext(), new NetworkConnectionInterface() {
                        @Override
                        public void OnSuccesfullyResponse(String response) {
                            //TODO: Leer y Parsear datos de la segunda llamada
                            updateUI();
                        }

                        @Override
                        public void OnFailedResponse() {

                        }
                    });

                    connection.execute(getString(R.string.endpoint_reviews, String.valueOf(pelicula.getId())));
                }

                @Override
                public void OnFailedResponse() {

                }
            });
            connection.execute(getString(R.string.endpoint_videos, String.valueOf(pelicula.getId())));
        }
    }

    private void updateUI() {
        //TODO: Actualización de la UI conforme a lo que se lea de las llamadas
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewDetail = inflater.inflate(R.layout.fragment_detail, container, false);
        Log.d(TAG,"Nombre de la Pelicula:" + pelicula.getTitle());

        TextView title = (TextView)viewDetail.findViewById(R.id.titleMovie);
        ImageView image = (ImageView)viewDetail.findViewById(R.id.posterMovie);

        title.setText(pelicula.getTitle());
        Picasso.with(getContext()).load(pelicula.getPoster_path()).into(image);

        return viewDetail;
    }

}
