package mx.antonioyee.pueblosmagicos.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.application.AppController;
import mx.antonioyee.pueblosmagicos.responses.geocoding.GeocodingResponse;
import mx.antonioyee.pueblosmagicos.responses.geocoding.Geometry;
import mx.antonioyee.pueblosmagicos.responses.geocoding.Location;
import mx.antonioyee.pueblosmagicos.responses.geocoding.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment implements Response.ErrorListener, Response.Listener<String> {

    private GoogleMap gMap;
    private String townName;

    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.townName = "san cristobal de las casas chiapas chiapas";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        SupportMapFragment mapLocation = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapLocation);
        gMap = mapLocation.getMap();

        String townNameFormat = townName.replaceAll("\\s+", "+");
        getLocation(townNameFormat);

        return view;
    }

    private void getLocation(final String townName){
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + townName;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, this, this){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> params = new HashMap<String, String>();

                params.put("address", townName);
                params.put("key", getResources().getString(R.string.google_key));

                return params;
            }
        };

        AppController.getInstance().getRequestQueue().add(stringRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("ERROR", error.toString());
    }

    @Override
    public void onResponse(String response) {
        try {
            Gson gson = new Gson();
            GeocodingResponse geocodingResponse = gson.fromJson(response, GeocodingResponse.class);

            loadLocation(geocodingResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadLocation(GeocodingResponse geo){
        List<Result> resultList = geo.getResults();

        Result result = resultList.get(0);

        Geometry geometry = result.getGeometry();

        Location location = geometry.getLocation();

        LatLng latLng = new LatLng(location.getLat(), location.getLng());

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 13);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title(result.getFormattedAddress());

        gMap.addMarker(markerOptions);
        gMap.animateCamera(cameraUpdate);
    }

}
