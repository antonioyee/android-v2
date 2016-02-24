package mx.antonioyee.pueblosmagicos.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.antonioyee.pueblosmagicos.R;

/**
 * Created by antonioyee on 24/02/16.
 */
public class ImagesTownRVAdapter extends RecyclerView.Adapter<ImagesTownRVAdapter.ViewHolder> {

    private List<String> images;
    private Activity activity;
    private OnItemClickListener onItemClickListener;

    public ImagesTownRVAdapter(List<String> images, Activity activity, @NonNull OnItemClickListener onItemClickListener) {
        this.images = images;
        this.activity = activity;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ImagesTownRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_photo, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ImagesTownRVAdapter.ViewHolder holder, final int position) {

        Picasso.with(activity).load(images.get(position)).into(holder.imgPhoto);

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                intent.putExtra(Intent.EXTRA_TEXT, images.get(position));

                activity.startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(images.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton btnShare;
        ImageView imgPhoto;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);

            btnShare = (ImageButton) itemView.findViewById(R.id.btnShare);
            imgPhoto = (ImageView) itemView.findViewById(R.id.imgPhoto);
            this.itemView = itemView;
        }

    }

    public interface OnItemClickListener{
        public void onClick(String path);
    }
}
