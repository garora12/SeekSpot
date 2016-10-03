package presenters;

import com.google.gson.Gson;

import models.ContactList;
import retrofit.Callback;
import retrofit.PostsAPI;
import retrofit.Response;
import retrofit.Retrofit;
import views.LoginView;

/**
 * Created by psharma1 on 2016-09-21.
 */
public class LoginPresenter {

    LoginView loginView;
    //Gson gson = new Gson();

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }


    public void listofContacts() {

        PostsAPI.getPostService().getContactslist().enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Response<ContactList> response, Retrofit retrofit) {
                loginView.onSuccess(response.body());
                // loginView.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void loginService() {


     /*PostsAPI.getPostService().getPostsList().enqueue(new Callback<Post>() {
         @Override
         public void onResponse(Response<Post> response, Retrofit retrofit) {
             loginView.onSuccess(response.toString());
         }

         @Override
         public void onFailure(Throwable t) {

         }
     });*/
    }


}
