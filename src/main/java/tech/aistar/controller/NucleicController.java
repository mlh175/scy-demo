package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.moudle.pojo.ResultReturn;
import tech.aistar.service.INucleicService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author:马立皓
 * @time:9:54 2022/7/7
 */
@RestController
@RequestMapping("/nucleic")
public class NucleicController {
    //controller层调⽤service层
    @Autowired
    private INucleicService nucleicService;

    @GetMapping("index")
    public ResultReturn index(Integer status, @RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "2") Integer pageSize){
        //System.out.println("status:"+status);
        //查询所有的信息
        Page<Nucleic> page = nucleicService.loadAll(status,pageNum,pageSize);
        //将这个数据返回到前端
        //@ResponseBody=>jackson⼯具=>java对象转换成json字符串
        //需要对⽇期进⾏进⼀步处理
        return new ResultReturn("200","所有核酸样本信息",page);
    }

    @PostMapping("del")
    public ResultReturn del(Integer id){
        int count = nucleicService.delById(id);
        if(count!=0)
            return new ResultReturn("200","删除成功!");
        return new ResultReturn("500","删除失败!");
    }

    @PostMapping("delMore")
    public ResultReturn delMore(String sids) {
        //字符串的处理
        //System.out.println("sids:"+sids);
        if (null != sids && sids.length() > 0) {
            //切割
            String[] arr = sids.split(":");
            for (String id : arr) {
                //corejava - 基操
                //String类型转成Integer类型[包装类型]
                nucleicService.delById(Integer.valueOf(id));
            }
        }
        return new ResultReturn("200", "删除成功!");
    }
    //录⼊信息
    @PostMapping("add")
    public ResultReturn add(Nucleic nucleic){
        System.out.println("nucleic:"+nucleic);
        return new ResultReturn("200","录⼊成功!");
    }
}


