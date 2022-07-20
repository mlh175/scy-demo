package tech.aistar.service;


import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.moudle.pojo.User;

import java.util.List;

/**
 * @author:马立皓
 * @time:15:05 2022/7/5
 */
public interface IUserService {
    /**
     * 根据邮箱去查找⽤户
     * @param email
     * @return
     */
    User loadByEmail(String email);


}
