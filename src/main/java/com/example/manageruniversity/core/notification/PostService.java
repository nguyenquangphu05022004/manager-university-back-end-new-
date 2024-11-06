package com.example.manageruniversity.core.notification;

import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    Post createOrUpdate(PostRequest request);
    Post getById(Long postId);
    List<Post> getAll();
    void delete(Long postId);
}
