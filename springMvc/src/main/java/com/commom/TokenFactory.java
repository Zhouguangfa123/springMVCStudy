package com.commom;

import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;

/**
 * TokenFactory 生成token
 *
 * @author zhougf
 * @date 2019/5/27
 */
public class TokenFactory {
    private static final TokenFactory instance = new TokenFactory();

    private TokenFactory() {
    }

    public static TokenFactory getInstance() {
        return instance;
    }

    /**
     * 生成Token
     *
     * @return
     */
    public String makeToken(Map<String, String> params) {
        //参数判断
        if (params == null) {
            return null;
        }
        //查询redis中是否有
        /** tokenKey 在redis中 存储的key*/
        String tokenKey = "X-Token";
         Jedis jedis = RedisTools.getJedis();
        if (StringUtils.isEmpty(jedis.get(tokenKey))) {
            return jedis.get(tokenKey);
        }

        //token生成 当前时间 随机数 用户名 密码
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        token = token + params.get("userName") + params.get("password");
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            //放入redis
            // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
            jedis.set(tokenKey, encoder.encode(md5), "NX", "EX", 2000000000000000L);
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
