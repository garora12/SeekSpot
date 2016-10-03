package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seasia.android.seekspot.R;

import java.util.ArrayList;

/**
 * Created by psharma1 on 2016-09-27.
 */
public class NearMeAdapter extends RecyclerView.Adapter<NearMeAdapter.UserViewHolder> {
    Context context;
    ArrayList<Integer> mImages;
    private ArrayList<String> mDataSet;

    public NearMeAdapter(Context context, ArrayList<String> mDataSet, ArrayList<Integer> mImages) {
        this.mDataSet = mDataSet;
        this.context = context;
        this.mImages = mImages;
    }

    /*@Override
    public NearMeAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_layout, parent, false);
        NearMeAdapter userViewHolder = new NearMeAdapter(v);
        return userViewHolder;
    }*/

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_near_me, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.name_entry.setText(mDataSet.get(position).toString());
        // holder.email_entry.setText(mDataSet.get(position).getUser_email());
        holder.icon_entry.setImageResource(mImages.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name_entry;
        ImageView icon_entry;

        UserViewHolder(View itemView) {
            super(itemView);

            name_entry = (TextView) itemView.findViewById(R.id.title_entry);
            icon_entry = (ImageView) itemView.findViewById(R.id.img_nav);
        }
    }
}
