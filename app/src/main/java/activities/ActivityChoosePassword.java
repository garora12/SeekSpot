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


public class ActivityChoosePassword extends AppCompatActivity {
    @BindView(R.id.btn_choose_pswd_next)
    Button btnNext;
    @BindView(R.id.ed_choose_pswd_enter_password)
    EditText edPassword;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_password);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @OnClick(R.id.ll_choose_pswd)
    public void onOutsideClicked() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
    @OnClick(R.id.btn_choose_pswd_next)
    public void onNextClicked() {
        if (!validate()) {
        } else {
            Intent i = new Intent(ActivityChoosePassword.this, ActivityVerifyEmailAddress.class);
            startActivity(i);
        }
    }

    private boolean validate() {
        boolean valid = true;
        String password = edPassword.getText().toString();
        if (password.isEmpty()) {
            edPassword.setError(getString(R.string.choose_pswd_cnt_empty));
            valid = false;
        } else if (password.length() < 8 || password.length() > 25) {
            edPassword.setError(getString(R.string.choose_pswd_length));
            edPassword.requestFocus();
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
