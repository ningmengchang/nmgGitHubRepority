package redis;

import redis.clients.jedis.Jedis;

/*
 * redis,Redis
 */
public class RedisJava {
	public static void main(String[] args) {
		//���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
        //��ȡredis��ֵ
        System.out.println(jedis.get("mykey"));
        //setRedis��ֵ
        jedis.set("key", "����");
        System.out.println(jedis.get("key"));
	}
}
