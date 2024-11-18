package com.example.manageruniversity.system.notification.dal.redis;

public interface RedisPostConstant {
    /**
     * Luu thong tin nguoi dung da xem post nao
     * de tinh luot view cua moi post
     */
    String USER_POST = "client_ip::%s::post::%s";
    String POST_VIEW = "post::%s";
}
