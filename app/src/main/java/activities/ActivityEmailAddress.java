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


public class ActivityEmailAddress extends AppCompatActivity {
    @BindView(R.id.btn_emailid_next)
    Button btnNext;
    @BindView(R.id.et_email_enter_mailid)
    EditText edEmailAddress;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_address);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_emailid_next)
    public void onNextClicked() {
        if (!validate()) {
        } else {
            Intent i = new Intent(ActivityEmailAddress.this, ActivityChoosePassword.class);
            startActivity(i);
        }
    }
    @OnClick(R.id.ll_email)
    public void onOutsideClicked() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private boolean validate() {
        boolean valid = true;
        String emailAddress = edEmailAddress.getText().toString();
        if (emailAddress.isEmpty()) {
            edEmailAddress.setError(getString(R.string.emailadd_cant_empty));
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            edEmailAddress.setError(getString(R.string.email_add_invalid));
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


