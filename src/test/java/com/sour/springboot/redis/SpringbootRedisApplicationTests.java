package com.sour.springboot.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sour.springboot.redis.pojo.User;
import com.sour.springboot.redis.utils.RedisUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtils redisUtils;


    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("key", "value");
//        redisTemplate.opsForList()
//        redisTemplate.opsForHash()

//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        System.out.println(redisTemplate.opsForValue().get("key"));

    }


    @SneakyThrows
    @Test
    void test01() {
        User user = new User("name", 12);
        // json字符串
        String asString = new ObjectMapper().writeValueAsString(user);
        System.out.println(asString);
        redisTemplate.opsForValue().set("user", user);

        System.out.println();

        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @SneakyThrows
    @Test
    void test02() {
        redisUtils.set("key-util", "value-util");
        System.out.println(redisUtils.get("key-util"));
    }
}
