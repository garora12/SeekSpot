package activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.seasia.android.seekspot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ActivitySignupForm extends AppCompatActivity {
    @BindView(R.id.btn_signup_next)
    Button btnNext;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

       /* actionBar.setHomeAsUpIndicator(R.drawable.previous_icon);
        actionBar.setDisplayShowHomeEnabled(true);*/
    }

    @OnClick(R.id.btn_signup_next)
    public void onNextClicked() {
        Intent i = new Intent(ActivitySignupForm.this, ActivityMobilePhnNo.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feeds:
                Intent i =new Intent(ActivitySignupForm.this,ActivityTermCondition.class);
                startActivity(i);
                break;
            case R.id.friends:
                break;
            case R.id.about:
                break;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return true;
    }


}

