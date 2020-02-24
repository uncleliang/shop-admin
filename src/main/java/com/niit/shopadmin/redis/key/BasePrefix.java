package com.niit.shopadmin.redis.key;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-24 14:01
 **/
public abstract class BasePrefix implements KeyPrefix{

    private long expire;
    private String prefix;

    public BasePrefix(long expire, String prefix) {
        this.expire = expire;
        this.prefix = prefix;
    }

    public BasePrefix(String prefix) {
        this.expire = 0L;
        this.prefix = prefix;
    }

    @Override
    public long expireSeconds() {
        return expire;
    }

    @Override
    public String getKeyPrefix() {
        // 类名
        String className = getClass().getSimpleName();
        return className+"："+prefix;
    }
}
