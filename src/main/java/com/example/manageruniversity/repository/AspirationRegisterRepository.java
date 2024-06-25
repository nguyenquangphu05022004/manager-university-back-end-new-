package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.AspirationRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AspirationRegisterRepository extends JpaRepository<AspirationRegister, Long> {
    List<AspirationRegister> findAllByOrderById();
}
