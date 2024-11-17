package com.example.manageruniversity.system.logger.dal.repo;

import com.example.manageruniversity.system.logger.dal.dataobject.OperationLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationLoggerRepository extends JpaRepository<OperationLogger, Long> {
}
