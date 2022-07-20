package tech.aistar.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.moudle.pojo.User;


import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author:马立皓
 * @time:16:47 2022/7/2
 */
@SpringBootTest
public class  NucleicDaoTest {

    //格式化日期
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");

    //按属性自动获取对象
    @Autowired
    private NucleicDao nucleicDao;

    //增加用户
    @Test
    public void testSave() throws ParseException {
        //创建一个实体类对象
        Nucleic nucleic=new Nucleic();

        nucleic.setUserName("admin0");
        nucleic.setRemark("居家隔离");
        nucleic.setUserId(UUID.randomUUID().toString().replaceAll("-",""));//算法生成
        nucleic.setCreateDate(sf.parse("2028-3-2"));
        nucleic.setStatus(2);
        nucleic.setUrl("南京市XXX");
        nucleicDao.save(nucleic);

    }

    //删除用户
    @Test
    public void testDelById(){
        nucleicDao.deleteById(5);
    }

    //更改用户
    @Test
    public void testUpdate(){
        //1.根据id进行查询，id是唯一的，返回的是一个单个对象
        Nucleic nucleic = nucleicDao.findById(6).get();
        //直接在内存中进行修改
        nucleic.setRemark("自由外出");
        nucleic.setStatus(0);
        //更新 - 内存中的对象同步到表中
       nucleicDao.saveAndFlush(nucleic);
    }

    //查询用户
    @Test
    public void testFindAll(){
        List<Nucleic> nucleicList = nucleicDao.findAll();
        nucleicList.forEach(nucleic -> System.out.println(nucleic));
    }


/*--------------------------------------------------*/
    @Test
    public void test(){
        /**
         * 内置的分页
         * 设置分页的属性
         *
         *  page：当前页，从0开始
         *  size：每显示的条数
         */
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Nucleic> m = nucleicDao.findByUserNameContainsOrderByIdDesc("m", pageRequest);
        List<Nucleic> content = m.getContent();
        content.forEach(nucleic -> System.out.println(nucleic));
    }


}
