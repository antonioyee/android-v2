package mx.antonioyee.pueblosmagicos.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.adapters.ImagesTownRVAdapter;
import mx.antonioyee.pueblosmagicos.application.AppController;
import mx.antonioyee.pueblosmagicos.models.MagicTown;
import mx.antonioyee.pueblosmagicos.responses.venue.Group;
import mx.antonioyee.pueblosmagicos.responses.venue.Item;
import mx.antonioyee.pueblosmagicos.responses.venue.Venue;
import mx.antonioyee.pueblosmagicos.responses.venues.Venues;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesTownFragment extends Fragment implements ImagesTownRVAdapter.OnItemClickListener {

    private RecyclerView rvImagesTown;
    private ImagesTownRVAdapter adapter;
    private List<String> paths = new ArrayList<>();
    private Boolean show = false;
    private String path;

    public ImagesTownFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if ( savedInstanceState != null ){
            this.show = savedInstanceState.getBoolean("show");
            this.path = savedInstanceState.getString("path");

            if ( path != null){
                loadImage(path);
            }
        }

        View view = inflater.inflate(R.layout.fragment_images_town, container, false);

        rvImagesTown = (RecyclerView) view.findViewById(R.id.rvImagesTown);

        /*for(MagicTown town: MagicTown.getData()){
            paths.add(town.getPathMainPhoto());
        }*/

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 3);

        adapter = new ImagesTownRVAdapter(paths, getActivity(), ImagesTownFragment.this);

        rvImagesTown.setLayoutManager(linearLayoutManager);
        rvImagesTown.setAdapter(adapter);

        getVenues(24.809065, -107.394012);

        return view;
    }

    @Override
    public void onClick(String path) {
        this.path = path;
        this.show = true;
        loadImage(path);
    }

    public void loadImage(String path){
        this.path = path;

        Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);

        dialog.setContentView(R.layout.dialog_image);
        ImageView imageDialog = (ImageView) dialog.findViewById(R.id.imgDialog);
        Picasso.with(getContext()).load(path).into(imageDialog);

        dialog.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("show", show);
        outState.putString("path", path);
    }

    public void getVenues(double lat, double log){
        String url = "https://api.foursquare.com/v2/venues/search?client_id=" + getResources().getString(R.string.foursquare_client_id)
                + "&client_secret=" + getResources().getString(R.string.foursquare_client_secret)
                + "&v=20130815&ll=" + lat + "," + log;

        StringRequest requestVenues = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<Venues>>(){}.getType();
                            jsonObject = jsonObject.getJSONObject("response");
                            List<Venues> venues = (List<Venues>) gson.fromJson(jsonObject.get("venues").toString(),listType);

                            for(Venues venue :venues){
                                getPhotos(venue.getId());
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("DEBUG", error.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                //params.put("address", townName);
                params.put("key", getResources().getString(R.string.google_key));

                return params;
            }
        };

        AppController.getInstance().getRequestQueue().add(requestVenues);
    }

    public void getPhotos(String venue_id){
        String url = "https://api.foursquare.com/v2/venues/"+venue_id+"?client_id="+getResources().getString(R.string.foursquare_client_id)+"&client_secret="+getResources().getString(R.string.foursquare_client_secret)+"&v=20160225";

        StringRequest requestVenues = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Gson gson = new Gson();
                            Venue venue = gson.fromJson(jsonObject.getJSONObject("response").getJSONObject("venue").toString(), Venue.class);

                            if ( venue.getPhotos().getCount() > 0 ){
                                Group group = venue.getPhotos().getGroups().get(0);

                                Item item = group.getItems().get(0);

                                String path = item.getPrefix() + "400x400" +item.getSuffix();

                                paths.add(path);
                                adapter.notifyDataSetChanged();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("DEBUG", error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                //params.put("address", townName);
                params.put("key", getResources().getString(R.string.google_key));

                return params;
            }
        };

        AppController.getInstance().getRequestQueue().add(requestVenues);
    }

}
