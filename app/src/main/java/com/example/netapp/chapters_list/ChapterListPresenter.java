package com.example.netapp.chapters_list;

import com.example.netapp.models.Post;
import com.example.netapp.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterListPresenter {

    private ChapterListView mChapterListView;

    private ApiClient mApiClient;

    public  ChapterListPresenter(ChapterListView view) {

        mChapterListView = view;

        if (mApiClient == null) {
            mApiClient = new ApiClient();
        }
    }

    public void getChapters() {
        mApiClient
                .getAPI()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        List<Post> postList = response.body();
                        mChapterListView.displayChapters(postList);
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        mChapterListView.displayError();
                    }
                });
    }
}
