package com.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.Date;

/**
 * test
 *
 * @author zhougf
 * @date 2019/5/21
 */
public class test {
    public static void main(String[] args) {

//        new RedisClient().show();
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
        jedis.set("runoobkey", "www.runoob.com");
        // ��ȡ�洢�����ݲ����
        System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("redis"));
    }

}
