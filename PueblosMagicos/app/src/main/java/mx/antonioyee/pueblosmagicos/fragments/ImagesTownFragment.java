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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.adapters.ImagesTownRVAdapter;
import mx.antonioyee.pueblosmagicos.models.MagicTown;

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

        for(MagicTown town: MagicTown.getData()){
            paths.add(town.getPathMainPhoto());
        }

        adapter = new ImagesTownRVAdapter(paths, getActivity(), ImagesTownFragment.this);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 3);
        rvImagesTown.setLayoutManager(linearLayoutManager);
        rvImagesTown.setAdapter(adapter);

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
}
