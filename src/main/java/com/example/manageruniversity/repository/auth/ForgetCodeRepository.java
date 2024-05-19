package com.example.manageruniversity.repository.auth;

import com.example.manageruniversity.entity.auth.ForgetCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ForgetCodeRepository extends JpaRepository<ForgetCode, Long> {
    @Query("select f from ForgetCode f inner join User  u on u.id = f.user.id " +
            "where u.username = :username and f.code = :code")
    Optional<ForgetCode> findByCodeValid(@Param("username") String username,
                                         @Param("code") String code);

}
