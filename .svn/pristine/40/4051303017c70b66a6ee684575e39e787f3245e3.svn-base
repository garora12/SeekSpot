package adapters;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.seasia.android.seekspot.R;

import java.util.List;

import custom.CircularImageView;


/**
 * Created by psharma1 on 2016-09-22.
 */
public class SearchOptionsAdapter extends RecyclerView.Adapter<SearchOptionsAdapter.MyViewHolder> {

    public int width, position1;
    int screenWidth, finalwidth;
    Context context;
    private List<Integer> horizontalList;


    public SearchOptionsAdapter(Context context, List<Integer> horizontalList, int screenWidth) {
        this.horizontalList = horizontalList;
        this.context = context;
        this.screenWidth = screenWidth;
        Log.d("screenWidth", "" + screenWidth);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_search_options, parent, false);

        // itemView.getWidth()=screenWidth/4;
        itemView.getLayoutParams().width = (getScreenWidth() / 4);
        itemView.requestLayout();
        width = itemView.getLayoutParams().width;
        Log.d("screenWidth-width--", "" + itemView.getLayoutParams().width);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        position1 = position;
        holder.circularImageView.setBackgroundResource(horizontalList.get(position));


    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public int getScreenWidth() {

        // if (screenWidth == 0) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        finalwidth = size.x;
        Log.d("screenWidth---", "" + finalwidth);
        //}
        return finalwidth - screenWidth * 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CircularImageView circularImageView;

        public MyViewHolder(View view) {
            super(view);
            circularImageView = (CircularImageView) view.findViewById(R.id.circularimageview);


        }
    }
}
