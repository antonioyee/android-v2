package mx.antonioyee.pueblosmagicos.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import mx.antonioyee.pueblosmagicos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {

    private GoogleMap gMap;

    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        SupportMapFragment mapLocation = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapLocation);
        gMap = mapLocation.getMap();

        return view;
    }

}
