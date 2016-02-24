package mx.antonioyee.feedrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.antonioyee.feedrecyclerview.R;
import mx.antonioyee.feedrecyclerview.models.Feed;
import mx.antonioyee.feedrecyclerview.util.DateUtil;

/**
 * Created by antonioyee on 24/02/16.
 */
public class FeedRVAdapter extends RecyclerView.Adapter<FeedRVAdapter.ViewHolder> {

    private List<Feed> objects;
    private Context context;

    public FeedRVAdapter(List<Feed> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    public FeedRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_feed, parent, false);

        ViewHolder holder = new ViewHolder(view);

        holder.imgFeed = (ImageView) view.findViewById(R.id.imgFeed);
        holder.txtDate = (TextView) view.findViewById(R.id.txtDate);
        holder.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        holder.txtDescription = (TextView) view.findViewById(R.id.txtDescription);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feed feed = objects.get(position);
        holder.txtTitle.setText(feed.getTitle());
        holder.txtDate.setText(DateUtil.getDateFormat(feed.getDate()));
        holder.txtDescription.setText(feed.getDescription());
        Picasso.with(context).load(feed.getPathImage()).into(holder.imgFeed);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate;
        TextView txtTitle;
        TextView txtDescription;
        ImageView imgFeed;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
