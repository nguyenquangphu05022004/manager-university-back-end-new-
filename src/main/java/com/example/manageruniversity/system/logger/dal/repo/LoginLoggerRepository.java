package com.example.manageruniversity.system.logger.dal.repo;

import com.example.manageruniversity.system.logger.dal.dataobject.LoginLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLoggerRepository extends JpaRepository<LoginLogger, LoginLogger> {
}
