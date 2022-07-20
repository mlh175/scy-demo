package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.aistar.dao.NucleicDao;
import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.service.INucleicService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author:马立皓
 * @time:9:26 2022/7/7
 */
@Service
@Transactional
public class INucleicServiceImpl implements INucleicService {

    @Autowired
    private NucleicDao nucleicDao;
    @Override
    public List<Nucleic> loadAll(Integer status) {
        //当status为null的时候 - 查询所有的
        if(status == null)
            return nucleicDao.findAll();
        //status不为null,0或者1
        return nucleicDao.findByStatus(status);
    }

    @Override
    public Page<Nucleic> findByUserNameContainsOrderByIdDesc(String username, Pageable pageable) {
        Page<Nucleic> byUserNameContainsOrderByIdDesc = nucleicDao.findByUserNameContainsOrderByIdDesc(username, pageable);
        return byUserNameContainsOrderByIdDesc;
    }

    @Override
    public Page<Nucleic> loadAll(Integer status, Integer pageNum, Integer pageSize) {
        //判断status是否为空
        //第⼀个参数是从0开始的,0代表的是第⼀⻚.
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
        if(status == null){
            //希望展示第⼀⻚的,默认显示两条数据
            return nucleicDao.findAll(pageable);
        }
        return nucleicDao.findByStatus(status,pageable);
    }

    @Override
    public int delById(Integer id) {
        return nucleicDao.delById(id);
    }



}
