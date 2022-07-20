package tech.aistar.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.aistar.moudle.pojo.Nucleic;

import java.util.List;

/**
 * @author:马立皓
 * @time:16:38 2022/7/2
 */
public interface NucleicDao extends JpaRepository<Nucleic,Integer> {

/**
 * 模糊查询+排序+分页
 */
  Page<Nucleic> findByUserNameContainsOrderByIdDesc(String username, Pageable pageable);


  List<Nucleic> findByStatus(Integer status);

  //分⻚
  Page<Nucleic> findByStatus(Integer status, Pageable pageable);

  @Modifying
  @Query("delete from Nucleic where id=?1")
  int delById(Integer id);


}
