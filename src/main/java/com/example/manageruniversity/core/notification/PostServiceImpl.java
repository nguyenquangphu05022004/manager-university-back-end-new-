package com.example.manageruniversity.core.notification;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourcesNotFoundException("post not found"));
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
