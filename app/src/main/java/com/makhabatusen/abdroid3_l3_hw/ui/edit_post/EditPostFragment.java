package com.makhabatusen.abdroid3_l3_hw.ui.edit_post;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.makhabatusen.abdroid3_l3_hw.data.model.Post;
import com.makhabatusen.abdroid3_l3_hw.data.remote.RetrofitBuilder;
import com.makhabatusen.abdroid3_l3_hw.databinding.FragmentEditPostBinding;
import com.makhabatusen.abdroid3_l3_hw.ui.base.BaseFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPostFragment extends BaseFragment<FragmentEditPostBinding> {

    private Post post;

    @Override
    protected FragmentEditPostBinding bind() {
        return FragmentEditPostBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            post = EditPostFragmentArgs.fromBundle(getArguments()).getPost();

            if (post != null) {
                ui.etTitle.setText(post.getTitle());
                ui.etContent.setText(post.getContent());
                ui.etUser.setText(String.valueOf(post.getUser()));
                ui.etGroup.setText(String.valueOf(post.getGroup()));
            }

            ui.btnSave.setOnClickListener(v -> {
                savePost();
            });
        }

    }

    private void savePost() {

        String title = ui.etTitle.getText().toString().trim();
        String content = ui.etContent.getText().toString().trim();
        int user = Integer.parseInt(ui.etUser.getText().toString().trim());
        int group = Integer.parseInt(ui.etGroup.getText().toString().trim());

        if (post == null) {
            post = new Post(title, content, user, group);
            RetrofitBuilder.getInstance().createPost(post).enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {

                }
            });
        } else {
            post.setTitle(title);
            post.setContent(content);
            post.setUser(user);
            post.setGroup(group);

            RetrofitBuilder.getInstance().updatePost(String.valueOf(post.getId()), post).enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {

                }
            });
        }

        navigateTo(EditPostFragmentDirections.actionEditPostFragmentToViewPostFragment());

    }


}




