package fragments;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import activities.ActivitySearch;

/**
 * Created by psharma1 on 2016-09-30.
 */
public class BaseFragment extends Fragment {

    public ActivitySearch activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activity= activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= (ActivitySearch) context;
    }
}
