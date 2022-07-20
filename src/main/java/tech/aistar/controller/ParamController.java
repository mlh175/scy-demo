package tech.aistar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.aistar.moudle.pojo.ResultReturn;
import tech.aistar.moudle.pojo.User;

/**
 * @author:马立皓
 * @time:14:20 2022/7/3
 */
@RestController
@RequestMapping("/param")//根据模块先定义一个路径
public class ParamController {
    //1.
    @GetMapping("/hello")
    public ResultReturn hello(Integer id,String username){
        System.out.println("id:"+id);
        System.out.println("user:"+username);
        return new ResultReturn("200","摆地摊",id+":"+username);
    }

    //直接使用对象作为参数
    @GetMapping("/test01")
    public ResultReturn test01(User user){
        System.out.println("user:"+user);
        return new ResultReturn("200","摆地摊",user);
    }

    /*
        如果传过来的key假设 ?count=1&username=admin...
        场景 = url中的key找不到⼀个对象的属性进⾏完全对应的时候.
        解决⽅案 - ⾃定义⼀个对象,定义url中的key
     */
    public class UserQueryVo{
        private Integer count;
        private String username;
    }
    @GetMapping("test02")
    public ResultReturn test02(UserQueryVo user) {
        System.out.println("user:" + user);
        return new ResultReturn("200", "摆地摊", user);
    }
    }
