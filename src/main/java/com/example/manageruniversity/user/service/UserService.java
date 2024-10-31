package com.example.manageruniversity.user.service;

import com.example.manageruniversity.user.domain.request.UserRequest;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    void createUser(UserRequest userRequest);
    void updateProfile(Long userId, UserRequest userRequest);
    void updateAvatar(Long userId, MultipartFile file);
}
