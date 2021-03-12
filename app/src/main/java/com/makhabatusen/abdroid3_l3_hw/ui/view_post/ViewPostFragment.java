package com.makhabatusen.abdroid3_l3_hw.ui.view_post;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.makhabatusen.abdroid3_l3_hw.data.model.Post;
import com.makhabatusen.abdroid3_l3_hw.data.remote.RetrofitBuilder;
import com.makhabatusen.abdroid3_l3_hw.databinding.FragmentViewPostBinding;
import com.makhabatusen.abdroid3_l3_hw.ui.base.BaseFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPostFragment extends BaseFragment<FragmentViewPostBinding> {

    private PostAdapter adapter;

    @Override
    protected FragmentViewPostBinding bind() {
        return FragmentViewPostBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PostAdapter();
    }

    private void loadPosts() {
        RetrofitBuilder.getInstance().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                adapter.addPosts(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadPosts();
        init();

    }


    private void init() {
        ui.rvPosts.setAdapter(adapter);
        ui.rvPosts.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        ui.fab.setOnClickListener(v -> {
            navigateTo(ViewPostFragmentDirections.actionViewPostFragmentToEditPostFragment());
        });

        adapter.setListener(new onPostClickListener() {
            @Override
            public void navigate(int pos) {
                navigateTo(ViewPostFragmentDirections.actionViewPostFragmentToEditPostFragment().setPost(adapter.getPost(pos)));
            }
        });
    }

}