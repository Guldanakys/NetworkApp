package com.example.netapp.chapter_details;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netapp.R;
import com.example.netapp.models.Post;
import com.example.netapp.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterDetailsActivity extends AppCompatActivity {

    private static final String POST_ID = "com.example.netapp.chapter_details.post_id";

    private ApiClient mApiClient;

    private TextView mPostTextBody;

    public static Intent newIntent(Context packageContext, int postId) {
        Intent intent = new Intent(packageContext, ChapterDetailsActivity.class);
        intent.putExtra(POST_ID, postId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_details);

        int postId = (int) getIntent().getSerializableExtra(POST_ID);
        mPostTextBody = (TextView) findViewById(R.id.post_body);

        if (mApiClient == null) {
            mApiClient = new ApiClient();
        }

        mApiClient.getAPI().getPostById(postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                String body = post.getBody();
                mPostTextBody.setText(body);
                Log.d("Post", body);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(ChapterDetailsActivity.this,
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
