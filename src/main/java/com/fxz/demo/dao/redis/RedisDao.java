package com.fxz.demo.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by fuxiaozhi on 2018\8\27 0027.
 */

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    private ValueOperations<String, String> ops;

    @PostConstruct
    public void init() {
        if(null == this.ops) {
            this.ops = this.stringRedisTemplate.opsForValue();
        }

    }

    public String get(String key) {
        return (String)this.ops.get(key);
    }

    public Boolean exists(String key) {
        return this.stringRedisTemplate.hasKey(key);
    }

    public boolean setWithCheck(String key, String value, long second) {
        if(this.exists(key).booleanValue()) {
            return false;
        } else {
            this.set(key, value, second);
            return true;
        }
    }

    public void set(String key, String value, long time) {
        this.ops.set(key, value, time, TimeUnit.SECONDS);
    }

    public Boolean setNX(String key, String value, long second) {
        boolean flag = this.ops.setIfAbsent(key, value).booleanValue();
        if(!flag) {
            return Boolean.valueOf(flag);
        } else {
            this.expire(key, second);
            return Boolean.valueOf(flag);
        }
    }

    public void set(String key, String value) {
        this.ops.set(key, value);
    }

    public long incr(String key) {
        return this.ops.increment(key, 1L).longValue();
    }

    public long incrBy(String key, long delta) {
        return this.ops.increment(key, delta).longValue();
    }

    public long decr(String key) {
        return this.ops.increment(key, -1L).longValue();
    }

    public long decrBy(String key, long delta) {
        return this.ops.increment(key, delta).longValue();
    }

    public boolean expire(String key, long second) {
        return this.stringRedisTemplate.expire(key, second, TimeUnit.SECONDS).booleanValue();
    }

    public long ttl(String key) {
        return this.stringRedisTemplate.getExpire(key).longValue();
    }

    public boolean del(String key) {
        return this.stringRedisTemplate.delete(key).booleanValue();
    }

    public boolean hset(String setName, String key, String value) {
        this.redisTemplate.opsForHash().put(setName, key, value);
        return true;
    }

    public boolean hsetAll(String setName, Map<String, Object> map) {
        this.redisTemplate.opsForHash().putAll(setName, map);
        return true;
    }

    public boolean hdel(String setName, String... key) {
        this.redisTemplate.opsForHash().delete(setName, key);
        return true;
    }

    public boolean hexists(String setName, String key) {
        return this.redisTemplate.opsForHash().hasKey(setName, key).booleanValue();
    }

    public Set<String> hkeys(String setName) {
        return this.redisTemplate.opsForHash().keys(setName);
    }

}
