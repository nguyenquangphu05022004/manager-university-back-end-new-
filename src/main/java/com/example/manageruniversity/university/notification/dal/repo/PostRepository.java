package com.example.manageruniversity.university.notification.dal.repo;

import com.example.manageruniversity.university.notification.dal.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
