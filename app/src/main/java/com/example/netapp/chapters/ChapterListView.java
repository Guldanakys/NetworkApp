package com.example.netapp.chapters;

import com.example.netapp.models.Post;

import java.util.List;

public interface ChapterListView {

    void displayChapters(List<Post> posts);

    void displayError();
}
