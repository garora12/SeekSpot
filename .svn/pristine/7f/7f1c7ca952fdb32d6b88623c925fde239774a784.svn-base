package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seasia.android.seekspot.R;

import java.util.ArrayList;

import adapters.NearMeAdapter;
import adapters.SearchOptionsAdapter;
import utils.Utils;

/**
 * Created by psharma1 on 2016-09-30.
 */



public class Fragment_search_options extends BaseFragment implements View.OnClickListener {

    RelativeLayout mrel;
    LinearLayout mlstRecommendedSearch;
    RecyclerView horizontal_recycler_view, vertical_recycler_view;
    LinearLayoutManager horizontalLayoutManagaer, verticalLayoutManagaer;
    ImageView mbtnPrev;
    ImageView mbtnNext;
    int width;
    ArrayList<String> dist = new ArrayList<>();
    ArrayList<String> mtitle = new ArrayList<>();
    ArrayList<Integer> mImages = new ArrayList<>();

    private ArrayList<Integer> horizontalList;
    private SearchOptionsAdapter horizontalAdapter;
    private NearMeAdapter userAdapter;
    private View view;
    FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_serach_options, container, false);

        mrel = (RelativeLayout)view. findViewById(R.id.rel_base);
        mbtnNext = (ImageView) view.findViewById(R.id.btn_next);
        mbtnPrev = (ImageView)view. findViewById(R.id.btn_previous);
        mbtnNext.setOnClickListener(this);
        mbtnPrev.setOnClickListener(this);

        horizontalList = new ArrayList<>();

        horizontalList.add(R.drawable.ic_brightness_1_24dp);
        horizontalList.add(R.drawable.ic_brightness_1_24dp);
        horizontalList.add(R.drawable.ic_brightness_1_24dp);
        horizontalList.add(R.drawable.ic_brightness_1_24dp);
        horizontalList.add(R.drawable.ic_brightness_1_24dp);
        horizontalList.add(R.drawable.ic_brightness_1_24dp);


        horizontal_recycler_view = (RecyclerView)view. findViewById(R.id.recyclerviewhorizontal);
        vertical_recycler_view = (RecyclerView) view.findViewById(R.id.recyclerviewvertical);
        mlstRecommendedSearch = (LinearLayout) view.findViewById(R.id.lstrecommendedserach);
        ViewTreeObserver vto = mbtnNext.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mbtnNext.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                width = mbtnNext.getMeasuredWidth();
            }
        });
        horizontalLayoutManagaer = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        //horizontalLayoutManagaer.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                horizontalAdapter = new SearchOptionsAdapter(getActivity(), horizontalList, width);
                horizontal_recycler_view.setAdapter(horizontalAdapter);
            }
        }, 3000);

        mtitle.add("title1");
        mtitle.add("title2");
        mtitle.add("title3");
        dist.add("100m");
        dist.add("200m");
        dist.add("300m");

        mImages.add(R.drawable.ic_history_24dp);
        mImages.add(R.drawable.ic_history_24dp);
        mImages.add(R.drawable.ic_history_24dp);
        addItemsToList();
        //  RecommendedSearchAdapter adapter = new RecommendedSearchAdapter(this, mtitle,mImages,dist);
        //mlstRecommendedSearch.setAdapter(adapter);
        verticalLayoutManagaer = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        //horizontalLayoutManagaer.setOrientation(LinearLayoutManager.HORIZONTAL);
        vertical_recycler_view.setLayoutManager(verticalLayoutManagaer);
        userAdapter = new NearMeAdapter(getActivity(), mtitle, mImages);
        vertical_recycler_view.setAdapter(userAdapter);

        vertical_recycler_view.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);

                  /*  if(verticalLayoutManagaer.findLastCompletelyVisibleItemPosition()==0){
                        fab.setVisibility(View.INVISIBLE);
                    }else{
                        fab.setVisibility(View.VISIBLE);
                    }*/

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 || dy < 0 && fab.isShown())
                    fab.hide();

            }
        });
        horizontal_recycler_view.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == 0) {

                    if (horizontalLayoutManagaer.findFirstVisibleItemPosition() == 0) {
                        mbtnPrev.setVisibility(View.INVISIBLE);
                        mbtnNext.setVisibility(View.VISIBLE);


                    } else {
                        if (horizontalLayoutManagaer.findLastVisibleItemPosition() == horizontalList.size() - 1) {
                            mbtnNext.setVisibility(View.INVISIBLE);
                            mbtnPrev.setVisibility(View.VISIBLE);
                        } else {
                            mbtnNext.setVisibility(View.VISIBLE);
                            mbtnPrev.setVisibility(View.VISIBLE);
                        }
                    }
                }


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void addItemsToList() {
        for (int i = 0; i < mtitle.size(); i++) {

            LayoutInflater mInflater = (LayoutInflater)getActivity().
                    getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            View convertView = mInflater.inflate(R.layout.row_layout_recommended_serach, null);

            TextView txtDist = (TextView) convertView.findViewById(R.id.dist_entry);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.title_entry);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.icon_entry);


            txtDist.setText(dist.get(i));
            txtTitle.setText(mtitle.get(i));
            imageView.setImageResource(mImages.get(i));

            /**
             * add view in top linear
             */

            mlstRecommendedSearch.addView(convertView);

            /**
             * get item row on click
             *
             */

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                mbtnPrev.setVisibility(View.VISIBLE);
                int lastVisibleItemPosition = horizontalLayoutManagaer.findLastVisibleItemPosition();

                if (lastVisibleItemPosition == horizontalAdapter.getItemCount() - 1) {
                    mbtnNext.setVisibility(View.INVISIBLE);
                } else {
                    horizontal_recycler_view.smoothScrollBy(horizontalAdapter.width, 0);
                    //horizontal_recycler_view.smoothScrollToPosition(lastVisibleItemPosition + 1);
                }
                break;

            case R.id.btn_previous:
                mbtnNext.setVisibility(View.VISIBLE);
                int firstVisibleItemPosition = horizontalLayoutManagaer.findFirstVisibleItemPosition();
                if (firstVisibleItemPosition == 0) {
                    mbtnPrev.setVisibility(View.INVISIBLE);
                } else {
                    //horizontal_recycler_view.scrollToPosition(firstVisibleItemPosition-1);
                    horizontal_recycler_view.smoothScrollBy(-horizontalAdapter.width, 0);
                    //horizontal_recycler_view.smoothScrollToPosition(firstVisibleItemPosition-1);
                }
                break;
        }
    }



  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getActivity(). getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Log.d("Serach", "222222222");

            return true;
        }

        return false;
    }
}
