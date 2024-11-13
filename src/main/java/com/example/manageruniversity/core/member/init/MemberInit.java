package com.example.manageruniversity.core.member.init;

import com.example.manageruniversity.core.member.dal.entities.Student;
import com.example.manageruniversity.core.member.dal.entities.Teacher;
import com.example.manageruniversity.core.member.dal.entities.User;
import com.example.manageruniversity.core.member.dal.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.example.manageruniversity.core.member.domain.enums.MemberType.STUDENT;
import static com.example.manageruniversity.core.member.domain.enums.MemberType.TEACHER;

@Component
@RequiredArgsConstructor
public class MemberInit {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    void init() {
        String pass = passwordEncoder.encode("admin");
        if(this.userRepository.findAll().size() == 0) {
            List<User> users = List.of(
                    new User("admin",pass, null, "admin1", "admin", "admin", "admin", new Date(), true),
                    new Teacher("TEA001", pass ,TEACHER, "admin2", "admin", "admin", "admin", new Date(), true),
                    new Teacher("TEA002", pass, TEACHER, "admin3", "admin", "admin", "admin", new Date(), true),
                    new Teacher("TEA003", pass, TEACHER, "admin4", "admin", "admin", "admin", new Date(), true),
                    new Student("SV0001", pass, STUDENT, "admin5", "admin", "admin", "admin", new Date(), true)
            );
            this.userRepository.saveAll(users);
        }
    }
}

