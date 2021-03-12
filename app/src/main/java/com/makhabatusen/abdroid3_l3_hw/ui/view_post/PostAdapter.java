package com.makhabatusen.abdroid3_l3_hw.ui.view_post;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.abdroid3_l3_hw.data.model.Post;
import com.makhabatusen.abdroid3_l3_hw.databinding.ItemPostBinding;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private static List<Post> posts;
    private onPostClickListener listener;

    public PostAdapter() {
        posts = new ArrayList<>();
    }

    public void setListener(onPostClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding ui = ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new PostViewHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public Post getPost(int pos) {
       return posts.get(pos);
    }

    public void addPosts(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder {
        private final ItemPostBinding ui;

        public PostViewHolder(@NonNull ItemPostBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
            ui.getRoot().setOnClickListener(v-> {
                listener.navigate(getAdapterPosition());
            });

        }

        public void onBind(Post post) {
                ui.tvTitle.setText(post.getTitle());
                ui.tvContent.setText(post.getContent());
                ui.tvUser.setText(String.valueOf(post.getUser()));
                ui.tvGroup.setText(String.valueOf(post.getGroup()));


        }
    }
}
