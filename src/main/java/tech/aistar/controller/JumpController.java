package tech.aistar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.aistar.moudle.pojo.ResultReturn;

import javax.servlet.http.HttpServletRequest;

/**
 * 转发和重定向
 */
@Controller
@RequestMapping("/jump")
public class JumpController {

    @GetMapping("/from")
    public String from(HttpServletRequest request){
        System.out.println("form");

        //将数据放在request作用域中，存储型式也是 key-value
        request.setAttribute("username","admin");
        //重定向
        //return "redirect:to";
        //转发
        return "forward:to";
    }

    @GetMapping("/to")
    @ResponseBody
    public ResultReturn to(HttpServletRequest request){
        System.out.println("to");
        System.out.println("name="+request.getAttribute("username"));
        return new ResultReturn("200","hello");
    }
}
