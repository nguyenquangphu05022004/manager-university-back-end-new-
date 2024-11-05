package com.example.manageruniversity.core.notification;

import org.springframework.data.domain.Page;

public interface PostService {
    Post createOrUpdate(PostRequest request);
    Post getById(Long postId);
    Page<Post> getAll(int page);
    void delete(Long postId);
}
