package com.sparrow.redis;

import com.sparrow.boot.ApplicationBoot;
import com.sparrow.passport.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@SpringBootTest(classes = {ApplicationBoot.class})
@RunWith(SpringRunner.class)
public class RedisTest {
    @Inject
    private RedisTemplate redisTemplate;

    @Inject
    private StringRedisTemplate stringRedisTemplate;

    @Inject
    private RedisTemplate originRedisTemplate;

    @Test
    public void stringTest() {
        redisTemplate.opsForValue().set("name", "lisi");
        stringRedisTemplate.opsForValue().set("string-name", "lisi");
        originRedisTemplate.opsForValue().set("origin-name", "lisi");
    }

    @Test
    public void objectTest() {
        User user = new User();
        user.setUserName("lisi");
        redisTemplate.opsForValue().set("name", user);
//        stringRedisTemplate.opsForValue().set("string-name", user);
        originRedisTemplate.opsForValue().set("origin-name", user);

        Long s = redisTemplate.opsForValue().increment("new2");
        redisTemplate.opsForValue().get("new");
        System.out.println("end");

    }
}
