//package com.util;
//
//import redis.clients.jedis.*;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * RedisUtil
// *
// * @author zhougf
// * @date 2019/5/21
// */
//public class RedisUtil implements Serializable {
//    private static final long serialVersionUID = -1149678082569464779L;
//
//    /**
//     * Redis服务器IP
//     */
//    private String addr;
//
//    /**
//     * Redis的端口号
//     */
//    private int port;
//
//    /**
//     * 访问密码
//     */
//    private String auth;
//
//    /**
//     * 可用连接实例的最大数目，默认值为8；
//     * 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
//     */
//    private int maxActive;
//
//    /**
//     * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
//     */
//    private int maxIdle;
//
//    /**
//     * 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
//     */
//    private int maxWait;
//
//    private int timeOut;
//
//    /**
//     * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
//     */
//    private boolean testOnBorrow;
//
//    /**非切片额客户端连接*/
//    private Jedis jedis;
//
//    /**
//     * 非切片连接池
//     */
//    private JedisPool jedisPool;
//
//    /**
//     * 切片连接池
//     */
//    private ShardedJedisPool shardedJedisPool;
//
//    private void initialPool() {
//        // 池基本配置
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(maxActive);
//        config.setMaxIdle(maxIdle);
//        config.setMaxWaitMillis(maxWait);
//        config.setTestOnBorrow(testOnBorrow);
//        jedisPool = new JedisPool(config, addr, port);
//    }
//
//    private void initialShardedPool() {
//        // 池基本配置
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(maxActive);
//        config.setMaxIdle(maxIdle);
//        config.setMaxWaitMillis(maxWait);
//        config.setTestOnBorrow(testOnBorrow);
//        // slave链接
//        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
//        shards.add(new JedisShardInfo(addr, port, auth));
//
//        // 构造池
//        shardedJedisPool = new ShardedJedisPool(config, shards);
//    }
//
//    public void afterPropertiesSet() throws Exception {
//        /**
//         * 切片额客户端连接
//         */
//        ShardedJedis shardedJedis;
//        // TODO Auto-generated method stub
//        initialPool();
//        initialShardedPool();
//        try {
//            shardedJedis = shardedJedisPool.getResource();
//        } catch (Exception e) {
//            System.out.println("连接shardedJedisPool失败!");
//        }
//        try {
//            jedis = jedisPool.getResource();
//        } catch (Exception e) {
//            System.out.println("连接jedisPool失败!");
//        }
//    }
//
//    public String getAddr() {
//        return addr;
//    }
//
//    public void setAddr(String addr) {
//        this.addr = addr;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public String getAuth() {
//        return auth;
//    }
//
//    public void setAuth(String auth) {
//        this.auth = auth;
//    }
//
//    public int getMaxActive() {
//        return maxActive;
//    }
//
//    public void setMaxActive(int maxActive) {
//        this.maxActive = maxActive;
//    }
//
//    public int getMaxIdle() {
//        return maxIdle;
//    }
//
//    public void setMaxIdle(int maxIdle) {
//        this.maxIdle = maxIdle;
//    }
//
//    public int getMaxWait() {
//        return maxWait;
//    }
//
//    public void setMaxWait(int maxWait) {
//        this.maxWait = maxWait;
//    }
//
//    public int getTimeOut() {
//        return timeOut;
//    }
//
//    public void setTimeOut(int timeOut) {
//        this.timeOut = timeOut;
//    }
//
//    public boolean isTestOnBorrow() {
//        return testOnBorrow;
//    }
//
//    public void setTestOnBorrow(boolean testOnBorrow) {
//        this.testOnBorrow = testOnBorrow;
//    }
//}
