package com.example.netapp.chapters_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.netapp.R;
import com.example.netapp.models.Post;

import java.util.List;

public class ChapterListActivity extends AppCompatActivity implements ChapterListView {

    private RecyclerView mRecyclerView;

    private PostAdapter mPostAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_list);

        mRecyclerView = findViewById(R.id.posts_recycler);

        ChapterListPresenter chapterListPresenter = new ChapterListPresenter(this);
        chapterListPresenter.getChapters();
    }

    @Override
    public void displayChapters(List<Post> posts) {
        mPostAdapter = new PostAdapter(this, posts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ChapterListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mPostAdapter);
    }

    @Override
    public void displayError() {
        Toast.makeText(ChapterListActivity.this,
                "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }
}
