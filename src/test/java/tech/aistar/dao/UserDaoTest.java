package tech.aistar.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tech.aistar.moudle.pojo.User;

import java.util.List;

/**
 * @author:马立皓
 * @time:15:13 2022/7/2
 */
@SpringBootTest
public class UserDaoTest {

    //测试IUserDao接口
    @Autowired
    private IUserDao UserDao;

    //测试
    @Test
    public void testSave(){
        //模拟一个user对象
        //本质 - java内存中的对象持久化（保存）到磁盘上的数据库的表中

        //创建一个User对象
        User user=new User();
        //setter赋值scy
        //id自增长不需要设置
        //id是主键列-用来唯一确定一行

        //唯一性
        user.setEmail("1976886491@qq.com");
        user.setUsername("admin");
        user.setGender("M");
        user.setPower(0);
        user.setPassword("123456");

        //调用dao中的save方法
        UserDao.save(user);

    }

    //查询
    @Test
    public void testFindAll(){
        List<User> userList = UserDao.findAll();
        userList.forEach(user -> System.out.println(user));
    }

    //根据id删除
    @Test
    public void testDelById(){
       UserDao.deleteById(1);
    }

    //更新
    @Test
    public void testUpdate(){
        //跟新的是db中存在的数据
        //1.根据id进行查询，id是唯一的，返回的是一个单个对象
        User user = UserDao.findById(1).get();
        //直接在内存中进行修改
        user.setPassword("123654");
        user.setGender("W");
        //更新 - 内存中的对象同步到表中
        UserDao.saveAndFlush(user);
    }
/*
--------------------------------------
 */
    @Test
    public void testFindByEmail(){
        User byEmail = UserDao.findByEmail("1976886491@qq.com");
        System.out.println(byEmail);
    }
    @Test
    public void testDelByEmail(){
        UserDao.deleteById(1);
    }

    @Test
    public void testGetById(){
        System.out.println(UserDao.loadById(2));
    }

    @Test
    public void testDelBySex(){
        int count = UserDao.delBySex("W");
        System.out.println("删除了"+count+"⾏!");
    }

    //模糊查询
    @Test
    public void testFindLike(){
        List<User> contains = UserDao.findByUsernameContains("m");
        List<User> nameLike = UserDao.findByNameLike("m");
        nameLike.forEach(user -> System.out.println(user));
//        User admin = UserDao.findByUsernameAndPassword("admin", "123456");
//        System.out.println(admin);

    }

    //分页
    @Test
    public void testPage(){
        //内置的分页
        //设置分页的属性

        //page：当前页，从0开始
        //size：每显示的条数
        Pageable pageable= PageRequest.of(0,3);
        //内置的page对象，包含分页的所有数据
        Page<User> all = UserDao.findAll(pageable);
        //具体分页得到的数据
        List<User> content = all.getContent();
        content.forEach(user -> System.out.println(user));
    }

    //模糊查询+分页
    @Test
    public void testFindAndPage(){
        //内置的分页
        //设置分页的属性

        //page：当前页，从0开始
        //size：每显示的条数
        Pageable pageable= PageRequest.of(0,3);
        //内置的page对象，包含分页的所有数据
        Page<User> all = UserDao.findByUsernameContains("m",pageable);
        //具体分页得到的数据
        List<User> content = all.getContent();
        content.forEach(user -> System.out.println(user));
    }
}
