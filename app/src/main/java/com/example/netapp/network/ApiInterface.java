package com.example.netapp.network;

import com.example.netapp.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/posts")
    Call<List<Post>> getAllPosts();
}
