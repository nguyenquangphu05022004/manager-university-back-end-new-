package com.example.manageruniversity.university.member.service;

import com.example.manageruniversity.university.member.controller.vo.MemberCreateReqVO;
import com.example.manageruniversity.university.member.controller.vo.MemberResetPasswordVO;
import com.example.manageruniversity.university.member.controller.vo.MemberUpdateReqVO;
import com.example.manageruniversity.university.member.dal.entities.User;
import com.example.manageruniversity.university.member.domain.enums.MemberType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    void createMember(MemberCreateReqVO memberCreateReqVO);
    void updateProfile(Long userId, MemberUpdateReqVO memberUpdateReqVO);
    void updateAvatar(Long userId, MultipartFile file);
    boolean isPasswordMatch(String rawPass, String encode);
    List<User> getListMember();
    List<User> getListByMemberType(MemberType memberType);
    void resetPassword(Long userId, MemberResetPasswordVO memberResetPasswordVO);
    void forgetPassword(String email);
    User getById(Long id);
    User getByUsername(String username);
}
