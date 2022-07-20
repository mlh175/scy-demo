package tech.aistar.dao;

import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.aistar.moudle.pojo.User;

import java.util.List;

/**
 *本类用来演示：持久层接口-和db进行交互
 */
@Transactional
public interface IUserDao extends JpaRepository<User,Integer> {
    //1. 查询出来的对象是单对象还是多对象
    //根据邮箱进行查询-唯一性
    User findByEmail(String email);
    //根据邮箱进行删除
    int deleteById(String id);

    /**
     * 根据用户名和密码查询用户
     */
    User findByUsernameAndPassword(String user,String passwd);

/*
. 可以使⽤sql语句 - 原⽣的sql
 */
    //mybatis - ⼿写sql语句 - 互联⽹项⽬追求性能 - sql优化
    //后台管理系统 - jpa技术
    @Query(value = "select * from t_user where id=?1",nativeQuery = true)
    User loadById(Integer id);

    /*
    . 使⽤jpql语句 - ⾯向对象的语⾔
     */
    //hql - ⾯向对象的语⾔ - "忘记表"
    //对象以及对象中的属性
    //@Query("from User where id=?1")
    @Query("select u from User u where u.id=?1")
    User loadWithId(Integer id);

/*
⽀持DML操作 - delete举例    DML:数据库操作语言
接⼝上使⽤@Transactional注解
 */
    //为了⽀持DML操作
    @Modifying
    @Query("delete from User where gender=?1")
    int delBySex(String gender);

    //自带的模糊查询
    //根据username进行模糊查询 - 返回的是多个对象 -集合对象
    List<User> findByUsernameContains(String username);

    @Query("from User where username like %?1%")
    List<User> findByNameLike(String username);

    /**
     * 模糊查询加分页
     * @param username
     * @param pageable
     * @return
     */
    //查看根据用户进行查询，并且经行分页操作
    Page<User> findByUsernameContains(String username, Pageable pageable);

    /**
     * 排序+模糊查询+分页
     */
    Page<User> findByUsernameContainsOrderByIdDesc(String username, Pageable pageable);

    User getByEmail(String email);
}
