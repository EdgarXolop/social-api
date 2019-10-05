package com.voider.socialapi.repository;

import com.voider.socialapi.http.exception.InvalidPostId;
import com.voider.socialapi.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class PostRepositoryImpl {

    @Autowired
    PostRepository _postRepository;

    public Post create(Post post){
        _postRepository.save(post);

        return post;

    }

    public Post getPost(Long id){

        Optional<Post> valid = _postRepository.findById(id);

        valid.orElseThrow(() -> new InvalidPostId("Invalid  post_id, Post not found."));

        return valid.get();
    }

    public Post update(Post post){

        if(post.getId_post() == null) throw new InvalidPostId("The post id can't be null.");

        Optional<Post> valid = _postRepository.findById(post.getId_post());

        valid.orElseThrow(() -> new InvalidPostId("Invalid  post_id, Post not found."));

        _postRepository.save(post);

        return post;
    }

    public List<Post> getMyPosts(Long id_user, int page_size, int page){

        Pageable pageable = PageRequest.of(page-1, page_size);

        return  _postRepository.getMyPosts(id_user,pageable);
    }

    public Post getMyPost(Long id_post, Long id_user){
        Optional<Post> oPost = _postRepository.getMyPost(id_post,id_user);

        if(oPost.isPresent()) return oPost.get();

        return null;
    }


    public List<Post> getPosts( int page_size, int page){

        Pageable pageable = PageRequest.of(page-1, page_size);

        return  _postRepository.getPosts(pageable);
    }

}
