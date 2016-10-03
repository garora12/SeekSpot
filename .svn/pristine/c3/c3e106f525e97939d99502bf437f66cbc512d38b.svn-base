package activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.widget.ShareDialog;
import com.seasia.android.seekspot.R;

import org.json.JSONException;
import org.json.JSONObject;

import utils.Utils;

/**
 * Created by sandhunavneet on 9/22/2016.
 */
public class ActivityFBLogin extends AppCompatActivity {
    CallbackManager callbackManager;
    Button details, btnContinue;
    ShareDialog shareDialog;
    LoginButton login;
    ProfilePictureView profile;
    Dialog details_dialog;
    TextView details_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_fb_login);
        btnContinue = (Button) findViewById(R.id.btn_fb_login_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityFBLogin.this, ActivityTermCondition.class);
                startActivity(i);
            }
        });
        callbackManager = CallbackManager.Factory.create();
        login = (LoginButton) findViewById(R.id.btn_fb_login_loginbtn);
        profile = (ProfilePictureView) findViewById(R.id.btn_fb_login_pictureview);
        shareDialog = new ShareDialog(this);
        details = (Button) findViewById(R.id.btn_fb_login_details);
        login.setReadPermissions(getString(R.string.fblogin_public_profile_email));
        details.setVisibility(View.INVISIBLE);
        details_dialog = new Dialog(this);
        details_dialog.setContentView(R.layout.activity_fb_user_details);
        details_dialog.setTitle(R.string.fblogin_details);
        details_txt = (TextView) details_dialog.findViewById(R.id.tv_fb_user_details_details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details_dialog.show();
            }
        });

        if (AccessToken.getCurrentAccessToken() != null) {
            RequestData();
            details.setVisibility(View.VISIBLE);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AccessToken.getCurrentAccessToken() != null) {
                    details.setVisibility(View.INVISIBLE);
                    profile.setProfileId(null);
                }
            }
        });
        login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                if (AccessToken.getCurrentAccessToken() != null) {
                    RequestData();
                    details.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {
                Utils.showToast(getApplicationContext(), "Internal Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void RequestData() {
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                JSONObject json = response.getJSONObject();
                try {
                    if (json != null) {
                        String text = getString(R.string.fblogin_name) + json.getString(getString(R.string.fblogin_namee)) + getString(R.string.fblogin_email) + json.getString(getString(R.string.fblogin_emaill)) + getString(R.string.fblogin_profile) + json.getString(getString(R.string.fblogin_link));
                        details_txt.setText(Html.fromHtml(text));
                        profile.setProfileId(json.getString(getString(R.string.fblogin_id)));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString(getString(R.string.fblogin_fields), getString(R.string.fblogin_id_name_link_email_picture));
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
