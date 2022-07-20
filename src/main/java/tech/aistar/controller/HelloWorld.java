package tech.aistar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2022/7/1 3:47 下午
 */
@RestController
public class HelloWorld {

    @GetMapping("hello")
    public String hello(){
        return "ok";
    }
}
