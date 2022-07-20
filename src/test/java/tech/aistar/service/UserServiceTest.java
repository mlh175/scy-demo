package tech.aistar.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.aistar.moudle.pojo.User;

/**
 * @author:马立皓
 * @time:15:29 2022/7/5
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;
        @Test
        public void testLoadByEmail() {
            User user = userService.loadByEmail("849962874@qq.com");
            System.out.println("user:" + user);
        }
    }

