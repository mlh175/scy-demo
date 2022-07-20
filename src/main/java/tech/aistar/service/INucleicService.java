package tech.aistar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.aistar.moudle.pojo.Nucleic;

import java.util.List;

/**
 * @author:马立皓
 * @time:9:25 2022/7/7
 */
public interface INucleicService {

    List<Nucleic> loadAll(Integer status);

    Page<Nucleic> findByUserNameContainsOrderByIdDesc(String username, Pageable pageable);

    /**
     *
     * @param status 0
     * @param pageNum 当前页
     * @param pageSize 每页显示的条数
     * @return
     */
    Page<Nucleic> loadAll(Integer status,Integer pageNum,Integer pageSize);

    /**
     * 根据id进⾏删除
     * @param id
     * @return
     */
    int delById(Integer id);
}
