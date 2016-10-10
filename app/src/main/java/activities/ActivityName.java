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


public class ActivityName extends AppCompatActivity {
    @BindView(R.id.ed_name_firstname)
    EditText edFirtName;
    @BindView(R.id.ed_name_lastname)
    EditText edLastName;
    @BindView(R.id.btn_name_next)
    Button btnNext;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_name_next)
    public void onNextClicked() {
        if (!validate()) {
        } else {
            Intent i = new Intent(ActivityName.this, ActivityGender.class);
            startActivity(i);
        }
    }
    @OnClick(R.id.ll_name)
    public void onOutsideClicked() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private boolean validate() {
        boolean valid = true;
        String firstName = edFirtName.getText().toString();
        String lastName = edLastName.getText().toString();
        String validateName = "^[A-Za-z ]+$";
        if (firstName.isEmpty()) {
            edFirtName.setError(getString(R.string.cant_be_empty));
            edFirtName.requestFocus();
            valid = false;
        } else if (!firstName.matches(validateName)) {
            edFirtName.setError(getString(R.string.only_chars));
            edFirtName.requestFocus();
            valid = false;
        }
        if (lastName.isEmpty()) {
            edLastName.setError(getString(R.string.cant_be_empty));
            edLastName.requestFocus();
            valid = false;
        } else if (!lastName.matches(validateName)) {
            edLastName.setError(getString(R.string.only_chars));
            edLastName.requestFocus();
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




