package com.example.manageruniversity.system.notification.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.system.notification.controller.vo.PostRequest;
import com.example.manageruniversity.system.notification.dal.entities.Post;
import com.example.manageruniversity.system.notification.dal.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    @Override
    public Post createOrUpdate(PostRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request, "id");
        Post post = new Post(
                request.getId(),
                request.getTitle(),
                request.getContent()
        );
        this.postRepository.save(post);
        return post;
    }

    @Override
    public Post getById(Long postId) {
        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourcesNotFoundException("post not found"));
        return post;
    }

    @Override
    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    @Override
    public void delete(Long postId) {
        this.postRepository.deleteById(postId);
    }
}
