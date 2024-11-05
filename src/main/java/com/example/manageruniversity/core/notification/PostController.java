package com.example.manageruniversity.core.notification;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    @PreAuthorize("@ss.hasAnyPermission('notification:post:create-update')")
    public CommonResult<PostDto> createOrUpdate(@RequestBody PostRequest request) {
        return CommonResult.success(new PostDto(postService.createOrUpdate(request)));
    }

    @GetMapping("/{id}")
    @PermitAll
    public CommonResult<PostDto> getPostById(@PathVariable("id") Long id) {
        return CommonResult.success(new PostDto(postService.getById(id)));
    }

    @GetMapping
    @PermitAll
    public PageResult<PostDto> getAllPost(@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
        return PageResult.success(
                postService.getAll(page),
                PostDto::new
        );
    }
}
