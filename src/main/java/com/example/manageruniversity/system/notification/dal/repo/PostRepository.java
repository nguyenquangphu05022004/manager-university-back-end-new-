package com.example.manageruniversity.system.notification.dal.repo;

import com.example.manageruniversity.system.notification.dal.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
