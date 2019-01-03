package redis;

import redis.clients.jedis.Jedis;

/*
 * redis,Redis
 */
public class RedisJava {
	public static void main(String[] args) {
		//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        //获取redis的值
        System.out.println(jedis.get("mykey"));
        //setRedis的值
        jedis.set("key", "中文");
        System.out.println(jedis.get("key"));
	}
}
