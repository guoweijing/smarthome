import redis.clients.jedis.Jedis;

import java.util.*;
public class Main {
public static void main(String[] args) {
    //连接本地的 Redis 服务
    Jedis jedis = new Jedis("127.0.0.1");
    System.out.println("连接成功");
    //查看服务是否运行
    System.out.println("服务正在运行: "+jedis.ping());
    //设置redis字符串数据
    jedis.set("pig", "3");
    //获取存储的数据并输出
    System.out.println("redis 存储的字符串为: "+ jedis.get("pig"));
    System.out.println("=======");

    //存储数据到列表中
    jedis.lpush("site-list", "Runoob");
    jedis.lpush("site-list", "Google");
    jedis.lpush("site-list", "Taobao");
    // 获取存储的数据并输出
    List<String> list = jedis.lrange("site-list", 0 ,2);
    for (String s : list) {
        System.out.println("列表项为: " + s);
    }
    System.out.println("=======");
    // 获取数据并输出
    Set<String> keys = jedis.keys("*");
    Iterator<String> it=keys.iterator() ;
    System.out.println("redis的所有key:");
    while(it.hasNext()){
        String key = it.next();
        System.out.println(key);
    }
}
}
