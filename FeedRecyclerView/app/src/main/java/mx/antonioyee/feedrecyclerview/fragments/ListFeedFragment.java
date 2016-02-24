package mx.antonioyee.feedrecyclerview.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.antonioyee.feedrecyclerview.R;
import mx.antonioyee.feedrecyclerview.adapters.FeedRVAdapter;
import mx.antonioyee.feedrecyclerview.models.Feed;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFeedFragment extends Fragment {

    private RecyclerView rvFeed;
    private FeedRVAdapter adapter;

    public ListFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_feed, container, false);

        rvFeed = (RecyclerView) view.findViewById(R.id.rvFeed);
        adapter = new FeedRVAdapter(Feed.getData(), getContext());

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvFeed.setLayoutManager(linearLayoutManager);
        rvFeed.setAdapter(adapter);
    }
}
