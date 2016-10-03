package activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.seasia.android.seekspot.R;

import models.ContactList;
import models.Contacts;
import presenters.LoginPresenter;
import views.LoginView;

/**
 * Created by psharma1 on 2016-09-21.
 */
public class DummyActivity extends Activity implements LoginView {

    LoginPresenter loginPresenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = (ListView) findViewById(R.id.lv);
        setContentView(R.layout.dummy);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.listofContacts();


    }

    @Override
    public void onError(String s) {

    }

    @Override
    public void onSuccess(ContactList body) {
        int size = body.getContacts().length;

        Contacts[] hfds = body.getContacts();

        //  for(int i=0;i<hfds.length;i++){

        Log.d("onSuccess--", "" + hfds[7].getEmail());
        //  }

    }


}
