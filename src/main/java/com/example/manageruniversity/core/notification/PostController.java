package com.example.manageruniversity.core.notification;

import com.example.manageruniversity.common.pojo.CommonResult;
import jakarta.annotation.security.PermitAll;
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

    @PostMapping
    @PreAuthorize("@ss.hasAnyPermission('post:create-update')")
    public CommonResult<PostDto> createOrUpdate(@RequestBody PostRequest request) {
        return success(new PostDto(postService.createOrUpdate(request)));
    }

    @GetMapping("/{id}")
    @PermitAll
    public CommonResult<PostDto> getPostById(@PathVariable("id") Long id) {
        return success(new PostDto(postService.getById(id)));
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
