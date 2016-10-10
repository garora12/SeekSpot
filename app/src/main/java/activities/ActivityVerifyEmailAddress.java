package activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
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


public class ActivityVerifyEmailAddress extends AppCompatActivity {
    @BindView(R.id.btn_verify_emailid_verify)
    Button btnVerify;
    @BindView(R.id.ed_verify_email_enter_mailid)
    EditText edVerifyEmail;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email_address);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_verify_emailid_verify)
    public void onVerifyClicked() {
        if (!validate()) {
        } else {
            Intent i = new Intent(ActivityVerifyEmailAddress.this, ActivityTermCondition.class);
            startActivity(i);
        }
    }
    @OnClick(R.id.ll_verify_email)
    public void onOutsideClicked() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
    private boolean validate() {
        boolean valid = true;
        String verifyEmailAddress = edVerifyEmail.getText().toString();
        if (verifyEmailAddress.isEmpty()) {
            edVerifyEmail.setError(getString(R.string.cant_be_empty));
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(verifyEmailAddress).matches()) {
            edVerifyEmail.setError(getString(R.string.login_invalid_email));
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

