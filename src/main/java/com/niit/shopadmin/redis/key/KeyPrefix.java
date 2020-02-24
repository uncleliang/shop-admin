package com.niit.shopadmin.redis.key;

public interface KeyPrefix {

    /**
     * 获取过期时间
     * @return 过期时间
     */
    long expireSeconds();

    /**
     * 获取前缀
     * @return 前缀
     */
    String getKeyPrefix();
}
