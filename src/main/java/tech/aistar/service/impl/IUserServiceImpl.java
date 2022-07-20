package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.aistar.dao.IUserDao;
import tech.aistar.dao.NucleicDao;
import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.moudle.pojo.User;
import tech.aistar.service.IUserService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author:马立皓
 * @time:15:25 2022/7/5
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    //service层调⽤dao层
    @Autowired
    private IUserDao userDao;

    @Override
    public User loadByEmail(String email) {
        //通过dao去和db进⾏直接的交互 - ⽐如获取数据
        //可以对这个获取出来的数据进⾏进⼀步的处理

        //可以对email进⾏⼀个格式的校验 - 是否是⼀个合法的邮箱地址
        return userDao.getByEmail(email);
    }

}
