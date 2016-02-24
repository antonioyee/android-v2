package mx.antonioyee.pueblosmagicos.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.adapters.MagicTownRVAdapter;
import mx.antonioyee.pueblosmagicos.models.MagicTown;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMagicTownFragment extends Fragment {

    private RecyclerView rvMagicTown;
    private MagicTownRVAdapter adapter;

    public ListMagicTownFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_magic_town, container, false);

        rvMagicTown = (RecyclerView) view.findViewById(R.id.rvMagicTown);
        adapter = new MagicTownRVAdapter(MagicTown.getData(), getContext());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvMagicTown.setLayoutManager(linearLayoutManager);
        rvMagicTown.setAdapter(adapter);
    }
}
