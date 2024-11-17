package com.example.manageruniversity.university.notification.service;

import com.example.manageruniversity.university.notification.controller.vo.PostRequest;
import com.example.manageruniversity.university.notification.dal.entities.Post;

import java.util.List;

public interface PostService {
    Post createOrUpdate(PostRequest request);
    Post getById(Long postId);
    List<Post> getAll();
    void delete(Long postId);
}
