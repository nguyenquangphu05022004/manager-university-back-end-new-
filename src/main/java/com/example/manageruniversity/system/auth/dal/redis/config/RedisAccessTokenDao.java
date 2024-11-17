package com.example.manageruniversity.system.auth.dal.redis.config;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.json.JsonUtils;
import com.example.manageruniversity.system.auth.dal.dataobject.AuthAccessToken;
import com.example.manageruniversity.system.auth.dal.redis.RedisConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Repository
public class RedisAccessTokenDao {

    private final StringRedisTemplate stringRedisTemplate;

    public AuthAccessToken get(String accessToken) {
        String key = formatKey(accessToken);
        if(stringRedisTemplate.hasKey(key)) {
            return JsonUtils.read(stringRedisTemplate.opsForValue().get(key), AuthAccessToken.class);
        }
        return null;
    }


    public void setToken(AuthAccessToken authAccessToken) {
        String key = formatKey(authAccessToken.getAccessToken());
        Long time = 0l;
        if(time > 0) {
            this.stringRedisTemplate.opsForValue().set(
                    key,
                    JsonUtils.write(authAccessToken),
                    time,
                    TimeUnit.SECONDS
            );
        }
    }

    public void delete(String accessToken) {
        String key = formatKey(accessToken);
        if(this.stringRedisTemplate.hasKey(key)) {
            this.stringRedisTemplate.delete(key);
        }
    }

    public void delete(List<String> accessToken) {
        List<String> keys = ListUtils.convertToList(accessToken, s -> formatKey(s));
        this.stringRedisTemplate.delete(keys);
    }

    public String formatKey(String accessToken) {
        return String.format(RedisConstant.ACCESS_TOKEN, accessToken);
    }
}
