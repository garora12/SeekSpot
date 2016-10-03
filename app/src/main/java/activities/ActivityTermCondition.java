package activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.seasia.android.seekspot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ActivityTermCondition extends AppCompatActivity {
    @BindView(R.id.btn_term_cndtn_signup)
    Button btnSignUp;
    @BindView(R.id.tv_term_cndtn_learn_more)
    TextView tvLearnMore;
    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_condition);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_term_cndtn_signup)
    public void onSignupClicked() {
        /*Uri gmmIntentUri = Uri.parse("geo:-8.409518,115.188919?q=restaurants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);*/
       Intent i = new Intent(ActivityTermCondition.this, ActivitySearch.class);
       startActivity(i);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return true;
    }
}
