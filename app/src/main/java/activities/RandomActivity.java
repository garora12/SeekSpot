package activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.util.Log;

/**
 * Created by psharma1 on 2016-10-04.
 */
public class RandomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(RandomActivity.this,"this is a toast",Toast.LENGTH_SHORT).show();
        Log.d("RandomActivity","Modified");
        Log.d("RandomActivity","Test");

    }

}
