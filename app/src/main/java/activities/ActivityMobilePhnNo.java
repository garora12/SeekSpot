package activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.seasia.android.seekspot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ActivityMobilePhnNo extends AppCompatActivity {
    @BindView(R.id.ed_mobphno_enter_mobno)
    EditText edMobileNumber;
    @BindView(R.id.btn_mobphnno_next)
    Button btnNext;
    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_phn_no);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_mobphnno_next)
    public void onNextClicked() {
        if (!validate()) {
        } else {
            Intent i = new Intent(ActivityMobilePhnNo.this, ActivityName.class);
            startActivity(i);
        }
    }
    @OnClick(R.id.ll_enter_mobno)
    public void onOutsideClicked() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private boolean validate() {
        boolean valid = true;
        String mobno = edMobileNumber.getText().toString();
        if (mobno.isEmpty()) {
            edMobileNumber.setError(getString(R.string.mobphn_cant_be_empty));
            valid = false;
        } else if (mobno.length() < 10 || mobno.length() > 20) {
            edMobileNumber.setError(getString(R.string.mbphn_length));
            edMobileNumber.requestFocus();
            valid = false;
        }
        return valid;
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


