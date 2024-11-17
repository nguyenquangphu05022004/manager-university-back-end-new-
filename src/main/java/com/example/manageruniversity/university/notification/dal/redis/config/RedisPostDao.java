package com.example.manageruniversity.university.notification.dal.redis.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

import static com.example.manageruniversity.university.notification.dal.redis.RedisPostConstant.POST_VIEW;
import static com.example.manageruniversity.university.notification.dal.redis.RedisPostConstant.USER_POST;

@RequiredArgsConstructor
@Repository
public class RedisPostDao {
    private final StringRedisTemplate stringRedisTemplate;

    public void countView(String clientIp, Long postId) {
        String key = String.format(USER_POST, clientIp, postId);
        Boolean result = this.stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 30, TimeUnit.SECONDS);
        if(result) {
            String keyPostView = String.format(POST_VIEW, postId);
            if(stringRedisTemplate.hasKey(keyPostView)) {
                this.stringRedisTemplate.opsForValue().increment(keyPostView, 1l);
            } else {
                this.stringRedisTemplate.opsForValue().set(keyPostView, "1");
            }
        }
    }

}
