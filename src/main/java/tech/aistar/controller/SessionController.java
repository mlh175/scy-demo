package tech.aistar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.aistar.moudle.pojo.ResultReturn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author:马立皓
 * @time:10:21 2022/7/4
 */
@Controller
@RequestMapping("/ses")
public class SessionController {
    @GetMapping("/from")
    public String from(HttpServletRequest request){
        //获取对象
        HttpSession session = request.getSession();
        //将数据放在作用域里中
        session.setAttribute("username","admin");
        return "redirect:to";
    }

    @ResponseBody
    @GetMapping("/to")
    public ResultReturn to(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        return new ResultReturn("200","成功","user="+username);
    }
}
