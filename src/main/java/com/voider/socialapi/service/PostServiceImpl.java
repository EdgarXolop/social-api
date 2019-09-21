package com.voider.socialapi.service;

import com.voider.socialapi.http.exception.InvalidPostPermission;
import com.voider.socialapi.model.Post;
import com.voider.socialapi.model.User;
import com.voider.socialapi.repository.PostRepositoryImpl;
import com.voider.socialapi.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepositoryImpl _posPostRepository;
    @Autowired
    private UserRepositoryImpl _userRepository;

    @Override
    public Post createPost(Post post, String user_name) {

        User user = _userRepository.getUserByEmail(user_name);

        post.setId_user_creator(user.getId_user());

        _posPostRepository.create(post);


        return post;
    }

    @Override
    public Post updatePost(Post post, String user_name) {

        if(!isValidPost(post.getId_post(),user_name)) throw new InvalidPostPermission("Insufficient permissions to change this post.");

        _posPostRepository.update(post);

        return post;
    }

    @Override
    public Post deletePost(Post post, String user_name) {

        if(!isValidPost(post.getId_post(),user_name)) throw new InvalidPostPermission("Insufficient permissions to change this post.");

        post.setDeleted_at(new Date());

        _posPostRepository.update(post);

        return post;
    }

    @Override
    public Post getPostById(Long id) {
        Post post = _posPostRepository.getPost(id);

        return post;
    }

    @Override
    public List<Post> getMyPosts(String user_name, int page_size, int page) {

        User user = _userRepository.getUserByEmail(user_name);

        return _posPostRepository.getMyPosts(user.getId_user(),page_size,page);
    }

    private Boolean isValidPost(Long id,String user_name){
        User user = _userRepository.getUserByEmail(user_name);

        return _posPostRepository.getMyPost(id,user.getId_user()) == null;
    }
}
