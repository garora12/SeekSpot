package adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seasia.android.seekspot.R;

import java.util.ArrayList;

/**
 * Created by psharma1 on 2016-09-28.
 */
public class RecommendedSearchAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> mlistData, mlistdist;
    ArrayList<Integer> mIntTime;

    public RecommendedSearchAdapter(Context context, ArrayList<String> mlistData, ArrayList<Integer> mIntTime, ArrayList<String> mlistdist) {
        this.context = context;
        this.mlistData = mlistData;
        this.mlistdist = mlistdist;
        this.mIntTime = mIntTime;
    }

    @Override
    public int getCount() {
        return mlistData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_layout_recommended_serach, null);
            holder = new ViewHolder();
            holder.txtDist = (TextView) convertView.findViewById(R.id.dist_entry);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title_entry);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon_entry);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.txtDist.setText(mlistdist.get(position));
        holder.txtTitle.setText(mlistData.get(position));
        holder.imageView.setImageResource(mIntTime.get(position));

        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDist;
    }
}
