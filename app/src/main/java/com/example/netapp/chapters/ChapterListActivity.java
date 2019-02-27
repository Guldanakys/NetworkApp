package com.example.netapp.chapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.netapp.R;
import com.example.netapp.models.Post;

import java.util.List;

public class ChapterListActivity extends AppCompatActivity implements ChapterListView {

    private RecyclerView recyclerView;

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_list);

        recyclerView = findViewById(R.id.posts_recycler);

        ChapterListPresenter chapterListPresenter = new ChapterListPresenter(this);
        chapterListPresenter.getChapters();
    }

    @Override
    public void displayChapters(List<Post> posts) {
        postAdapter = new PostAdapter(posts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ChapterListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
    }

    @Override
    public void displayError() {
        Toast.makeText(ChapterListActivity.this,
                "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }
}
