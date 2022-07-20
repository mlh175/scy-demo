package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.aistar.dao.IUserDao;
import tech.aistar.moudle.pojo.ResultReturn;

/**
 * @author:马立皓
 * @time:14:28 2022/7/5
 */
@RestController
@RequestMapping("user02")
public class UserController05 {
    @Autowired
    private IUserDao userDao;
    //接受邮箱,并且进⾏验证码的⼀个发送功能
    //如果此处接受⼀个ajax传过来的json对象的值.
    //保证该⽅法的参数的名称和json对象的key的命名⾼度保持⼀致
    @GetMapping("sendCode")
    public ResultReturn sendCode(String email){
        System.out.println(email);
        return new ResultReturn("200","查收邮件!查看验证码!");
    }
}
