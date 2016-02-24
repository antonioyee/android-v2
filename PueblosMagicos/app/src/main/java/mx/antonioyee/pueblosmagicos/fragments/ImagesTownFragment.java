package mx.antonioyee.pueblosmagicos.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.adapters.ImagesTownRVAdapter;
import mx.antonioyee.pueblosmagicos.models.MagicTown;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesTownFragment extends Fragment {

    private RecyclerView rvImagesTown;
    private ImagesTownRVAdapter adapter;
    private List<String> paths = new ArrayList<>();

    public ImagesTownFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images_town, container, false);

        rvImagesTown = (RecyclerView) view.findViewById(R.id.rvImagesTown);

        for(MagicTown town: MagicTown.getData()){
            paths.add(town.getPathMainPhoto());
        }

        adapter = new ImagesTownRVAdapter(paths, getActivity());

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 3);
        rvImagesTown.setLayoutManager(linearLayoutManager);
        rvImagesTown.setAdapter(adapter);

        return view;
    }

}
