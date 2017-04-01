package mx.udg.valles.veganet.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.udg.valles.veganet.manejourls.R;

/**
 * Created by veganet on 01/04/2017.
 */

public class Detail extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewDetail = inflater.inflate(R.layout.fragment_detail, container, false);
        return viewDetail;
    }
}
