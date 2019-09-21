package com.voider.socialapi.service;

import com.voider.socialapi.model.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post, String user_name);
    Post updatePost(Post post, String user_name);
    Post deletePost(Post post, String user_name);
    Post getPostById(Long id);
    List<Post> getMyPosts(String user_name, int page_size, int page);

}
