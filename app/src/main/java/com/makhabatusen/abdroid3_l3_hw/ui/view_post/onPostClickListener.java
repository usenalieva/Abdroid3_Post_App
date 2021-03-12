package com.makhabatusen.abdroid3_l3_hw.ui.view_post;


import com.makhabatusen.abdroid3_l3_hw.data.model.Post;

public interface onPostClickListener {
    void navigate( int pos);
    void deletePost(int pos, Post post);
}
