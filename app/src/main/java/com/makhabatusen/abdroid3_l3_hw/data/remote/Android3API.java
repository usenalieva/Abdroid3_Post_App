package com.makhabatusen.abdroid3_l3_hw.data.remote;

import com.makhabatusen.abdroid3_l3_hw.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Android3API {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(
            @Body Post post
    );

    @DELETE("posts/{id}")
    Call<Post> deletePost(@Path("id") String id);

    @PUT("posts/{id}")
    Call<Post> updatePost(@Path("id") String id, @Body Post post);

}
