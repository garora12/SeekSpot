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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.seasia.android.seekspot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import utils.Logger;
import utils.Utils;


public class ActivityGender extends AppCompatActivity {
    @BindView(R.id.radiogrp_name)
    RadioGroup radioGroup;
    @BindView(R.id.radio_gender_male)
    RadioButton radioButtonMale;
    @BindView(R.id.radio_gender_female)
    RadioButton radioButtonFemale;
    @BindView(R.id.btn_gender_next)
    Button btnNxt;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        unbinder = ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @OnClick(R.id.btn_gender_next)
    public void onNextClicked() {
        if (validate()) {
        }
    }


    private boolean validate() {
        boolean valid = true;
        if (radioButtonMale.isChecked() || radioButtonFemale.isChecked()) {
            Logger.log("Navneet", "Gender is Selected");
            Intent i = new Intent(ActivityGender.this, ActivityBirthDate.class);
            startActivity(i);
        } else {
            Utils.showToast(getApplicationContext(), getString(R.string.gender_select_gender), Toast.LENGTH_SHORT).show();
            Logger.log("Navneet", "Gender is Null");
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