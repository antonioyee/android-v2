package mx.antonioyee.pueblosmagicos.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.adapters.MagicTownRVAdapter;
import mx.antonioyee.pueblosmagicos.application.AppController;
import mx.antonioyee.pueblosmagicos.models.MagicTown;
import mx.antonioyee.pueblosmagicos.responses.geocoding.GeocodingResponse;
import mx.antonioyee.pueblosmagicos.responses.geocoding.Geometry;
import mx.antonioyee.pueblosmagicos.responses.geocoding.Location;
import mx.antonioyee.pueblosmagicos.responses.geocoding.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMagicTownFragment extends Fragment implements MagicTownRVAdapter.OnItemClickListener {

    public static final String TAG = "ListMagicTownFragment";
    private RecyclerView rvMagicTown;
    private MagicTownRVAdapter adapter;
    private CallBacks callBack;
    private ProgressDialog progressDialog;
    private List<MagicTown> towns;
    private int lastUpdate;

    public ListMagicTownFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        towns = MagicTown.getMagicTowns();
        getLocations();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            this.callBack = (CallBacks) getActivity();
        }catch (Exception e){
            Log.e(TAG, "You have to implented fragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_magic_town, container, false);

        rvMagicTown = (RecyclerView) view.findViewById(R.id.rvMagicTown);
        adapter = new MagicTownRVAdapter(MagicTown.getMagicTowns(), getContext(), this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvMagicTown.setLayoutManager(linearLayoutManager);
        rvMagicTown.setAdapter(adapter);
    }

    @Override
    public void onClick(MagicTown magicTown) {
        callBack.onTownSelected(magicTown);
    }

    public interface CallBacks{
        public void onTownSelected(MagicTown magicTown);
    }

    public void getLocations(){
        for(int i = 0; i < towns.size(); i++ ){
            MagicTown town = towns.get(i);

            if ( town.getLatitude() == null || town.getLongitude() == null ){

                if ( ! progressDialog.isShowing() ){
                    progressDialog.show();
                }

                getLocation(town, i);
                this.lastUpdate = i;
            }
        }
    }

    private void getLocation(final MagicTown town, final int index){
        String townName = town.getName() + " " + town.getState();
        townName = townName.replace("\\s+", "+");

        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + townName;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            Gson gson = new Gson();
                            GeocodingResponse geocodingResponse = gson.fromJson(response, GeocodingResponse.class);

                            List<Result> resultList = geocodingResponse.getResults();
                            Result result = resultList.get(0);
                            Geometry geometry = result.getGeometry();
                            Location location = geometry.getLocation();

                            town.setLatitude(location.getLat());
                            town.setLongitude(location.getLng());

                            MagicTown.updateMagicTown(town);

                            if ( index == lastUpdate ){
                                progressDialog.hide();
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("key", getResources().getString(R.string.google_key));

                return params;
            }
        };

        AppController.getInstance().getRequestQueue().add(stringRequest);
    }

}
