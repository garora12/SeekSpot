package retrofit;


import models.ContactList;
import models.Post;
import retrofit.http.GET;


public class PostsAPI {

    private static PostService postService;

    public static PostService getPostService() {
        if (postService == null) {

            Retrofit retrofit1 = new Retrofit.Builder().baseUrl("http://api.androidhive.info/").addConverterFactory(GsonConverterFactory.create()).build();
            postService = retrofit1.create(PostService.class);
        }
        return postService;
    }

    public interface PostService {
        @GET("/posts")
        Call<Post> getPostsList();

        @GET("contacts/")
        Call<ContactList> getContactslist();
    }

}
