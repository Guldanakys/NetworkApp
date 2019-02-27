package com.example.netapp.chapters;

import com.example.netapp.models.Post;
import com.example.netapp.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterListPresenter {

    private ChapterListView chapterListView;

    private ApiClient apiClient;

    public  ChapterListPresenter(ChapterListView view) {
        this.chapterListView = view;

        if (this.apiClient == null) {
            this.apiClient = new ApiClient();
        }
    }

    public void getChapters() {
        apiClient
                .getAPI()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        List<Post> postList = response.body();
                        chapterListView.displayChapters(postList);
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        chapterListView.displayError();
                    }
                });
    }
}
