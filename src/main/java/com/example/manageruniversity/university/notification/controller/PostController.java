package com.example.manageruniversity.university.notification.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.university.notification.controller.vo.PostDto;
import com.example.manageruniversity.university.notification.controller.vo.PostRequest;
import com.example.manageruniversity.university.notification.dal.entities.Post;
import com.example.manageruniversity.university.notification.dal.redis.config.RedisPostDao;
import com.example.manageruniversity.university.notification.service.PostService;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification/posts")
@CrossOrigin("*")
public class PostController {
    private final PostService postService;
    private final RedisPostDao redisPostDao;
    @PostMapping
    @PreAuthorize("@ss.hasAnyPermission('post:create-update')")
    public CommonResult<PostDto> createOrUpdate(@RequestBody PostRequest request) {
        return success(new PostDto(postService.createOrUpdate(request)));
    }

    @GetMapping("/{id}")
    @PermitAll
    public CommonResult<PostDto> getPostById(@PathVariable("id") Long id, HttpServletRequest request) {
        Post post = postService.getById(id);
        this.redisPostDao.countView(request.getRemoteAddr(), id);
        return success(new PostDto(post));
    }

    @GetMapping
    @PermitAll
    public CommonResult<List<PostDto>> getAllPost() {
        return success(postService.getAll(), PostDto::new);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('post:delete')")
    public CommonResult<?> delete(@PathVariable("id") Long postId) {
        this.postService.delete(postId);
        return success("deleted successfully");
    }
}
