package com.example.netapp.chapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.netapp.R;
import com.example.netapp.models.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;

    public PostAdapter(List<Post> posts) {
        this.postList = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.post_list_item, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        postViewHolder.postTextId.setText("Chapter " + Integer.toString(postList.get(i).getId()));
        postViewHolder.postTextTitle.setText(postList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        private TextView postTextId;

        private TextView postTextTitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postTextId = itemView.findViewById(R.id.post_id);
            postTextTitle = itemView.findViewById(R.id.post_title);
        }
    }
}