package tech.aistar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.aistar.moudle.pojo.ResultReturn;

/**
 * @author:马立皓
 * @time:9:43 2022/7/2
 */
@Controller
public class ResultHelloController {
    //映射路劲，必须在整个引用中保持一致

    @GetMapping("test")
    @ResponseBody
    public ResultReturn hello(){
        return new ResultReturn("200","测试");
    }

}
