package com.voider.socialapi.repository;

import com.voider.socialapi.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("FROM Post WHERE id_user_creator = :id_user ORDER BY updated_at")
    List<Post> getMyPosts(Long id_user, Pageable pageable);

    @Query("FROM Post WHERE id_user_creator = :id_user AND id_post = :id_post")
    Optional<Post> getMyPost(Long id_post,Long id_user);

    @Query("FROM Post ORDER BY updated_at")
    List<Post> getPosts( Pageable pageable);
}
