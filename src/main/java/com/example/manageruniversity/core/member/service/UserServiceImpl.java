package com.example.manageruniversity.core.member.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.exception.ServiceException;
import com.example.manageruniversity.core.media.Media;
import com.example.manageruniversity.core.media.MediaService;
import com.example.manageruniversity.core.member.controller.vo.MemberCreateReqVO;
import com.example.manageruniversity.core.member.controller.vo.MemberResetPasswordVO;
import com.example.manageruniversity.core.member.controller.vo.MemberUpdateReqVO;
import com.example.manageruniversity.core.member.dal.entities.User;
import com.example.manageruniversity.core.member.dal.repo.UserRepository;
import com.example.manageruniversity.core.member.domain.enums.MemberType;
import com.example.manageruniversity.mq.producer.EmailProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailProducer emailProducer;
    private final MediaService mediaService;

    @Override
    public void createMember(MemberCreateReqVO memberCreateReqVO) {
        User user = new User(
                memberCreateReqVO.getUsername(),
                passwordEncoder.encode(memberCreateReqVO.getPassword()),
                memberCreateReqVO.getMemberType(),
                memberCreateReqVO.getEmail(),
                memberCreateReqVO.getFullName(),
                memberCreateReqVO.getAddress(),
                memberCreateReqVO.getPhoneNumber(),
                memberCreateReqVO.getDateOfBirth(),
                memberCreateReqVO.getSex()
        );
        this.userRepository.save(user);
    }

    @Override
    public void updateProfile(Long userId, MemberUpdateReqVO memberUpdateReqVO) {
        User user = this.getById(userId);
        user.setEmail(memberUpdateReqVO.getEmail());
        user.setAddress(memberUpdateReqVO.getAddress());
        user.setPhoneNumber(memberUpdateReqVO.getPhoneNumber());
        this.userRepository.save(user);
    }

    @Override
    public void updateAvatar(Long userId, MultipartFile file) {
        User user = this.getById(userId);
        Media media = this.mediaService.upload(file);
        user.setAvatar(media.getPath());
        this.userRepository.save(user);
    }

    @Override
    public boolean passwordMatch(String rawPass, String encode) {
        return this.passwordEncoder.matches(rawPass, encode);
    }

    @Override
    public List<User> getListMember() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> getListByMemberType(MemberType memberType) {
        return getListMember().stream().filter(u -> u.getMemberType() == memberType).toList();
    }

    @Override
    public void resetPassword(Long userId, MemberResetPasswordVO memberResetPasswordVO) {
        User user = this.getById(userId);
        if(passwordMatch(memberResetPasswordVO.getOldPass(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(memberResetPasswordVO.getOldPass()));
            this.userRepository.save(user);
        }
        throw new ServiceException("Password not match");
    }

    @Override
    public void forgetPassword(String email) {
        User user = this.userRepository.findUserByEmailIgnoreCase(email)
                .orElseThrow(() -> new ResourcesNotFoundException("Email not found"));
        this.emailProducer.publish(
                "Forget Password",
                "Code: " + UUID.randomUUID(),
                user.getUsername(),
                email
        );
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("user not found"));
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.findUserByUsernameIgnoreCase(username)
                .orElseThrow(() -> new ResourcesNotFoundException("not found user"));
    }
}
