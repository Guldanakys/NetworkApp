package com.example.netapp.chapters_list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netapp.R;
import com.example.netapp.chapter_details.ChapterDetailsActivity;
import com.example.netapp.models.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> mPostList;

    private Context mContext;

    public PostAdapter(Context context, List<Post> posts) {
        mPostList = posts;
        mContext = context;
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
        Post post = mPostList.get(i);
        postViewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mPostTextId;

        private TextView mPostTextTitle;

        private Post mPost;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            mPostTextId = itemView.findViewById(R.id.post_id);
            mPostTextTitle = itemView.findViewById(R.id.post_title);
        }

        public void bind(Post post) {
            mPost = post;
            mPostTextId.setText(String.valueOf(mPost.getId()));
            mPostTextTitle.setText(mPost.getTitle());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), Integer.toString(mPost.getId()), Toast.LENGTH_SHORT).show();
            Intent intent = ChapterDetailsActivity.newIntent(mContext, mPost.getId());
            mContext.startActivity(intent);
        }
    }
}