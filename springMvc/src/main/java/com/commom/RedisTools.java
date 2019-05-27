package com.commom;

import redis.clients.jedis.Jedis;

/**
 * RedisTools
 *
 * @author zhougf
 * @date 2019/5/27
 */
public class RedisTools {
    private static final Jedis instance = new Jedis("localhost");

    public static Jedis getJedis() {
        return instance;
    }

}
