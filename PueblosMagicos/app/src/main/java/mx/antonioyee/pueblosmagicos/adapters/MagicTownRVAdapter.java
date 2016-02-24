package mx.antonioyee.pueblosmagicos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.models.MagicTown;

/**
 * Created by antonioyee on 23/02/16.
 */
public class MagicTownRVAdapter extends RecyclerView.Adapter<MagicTownRVAdapter.ViewHolder> {

    private List<MagicTown> objects;
    private Context context;

    public MagicTownRVAdapter(List<MagicTown> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    public MagicTownRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_magic_town, parent, false);

        ViewHolder holder = new ViewHolder(view);

        holder.imgTown = (ImageView) view.findViewById(R.id.imgTown);
        holder.txtTownName = (TextView) view.findViewById(R.id.txtTownName);

        return holder;
    }

    @Override
    public void onBindViewHolder(MagicTownRVAdapter.ViewHolder holder, int position) {

        MagicTown magicTown = objects.get(position);
        holder.txtTownName.setText(magicTown.getName());
        Picasso.with(context).load(magicTown.getPathMainPhoto()).into(holder.imgTown);

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgTown;
        TextView txtTownName;

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
