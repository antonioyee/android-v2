package mx.antonioyee.pueblosmagicos.fragments;


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

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.adapters.MagicTownRVAdapter;
import mx.antonioyee.pueblosmagicos.models.MagicTown;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMagicTownFragment extends Fragment implements MagicTownRVAdapter.OnItemClickListener {

    public static final String TAG = "ListMagicTownFragment";
    private RecyclerView rvMagicTown;
    private MagicTownRVAdapter adapter;
    private CallBacks callBack;

    public ListMagicTownFragment() {
        // Required empty public constructor
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
        adapter = new MagicTownRVAdapter(MagicTown.getData(), getContext(), this);

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

}
