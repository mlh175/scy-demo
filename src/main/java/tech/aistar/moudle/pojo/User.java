package tech.aistar.moudle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 本类⽤来演示: 实体类
 * OO思想 - 分析业务中关键的对象,分析出这个对象拥有什么 - 对象的属性
 * 以及这个对象可以⼲什么 - 对象的功能/⽅法
 * 以及对象与对象之间的关系 - 1:1 1:N N:N ⾃关联
 *
 */
@NoArgsConstructor //空参构造
@AllArgsConstructor // 如果⼀个是实体类中没有提供任何⼀个构造的时候,那么系统默认会分配⼀个空参构造.但是如果⼀旦提供
                    //任何⼀个带参构造的时候,那么系统将不会再提供空参构
@Data  //空参构造, getter/setter,toString,equals&hashCode
@Entity // 这个类是⼀个实体类,表和这个类对应
@Table(name = "t_User")
public class User  {
    @Id  //对象的标识符
    @GeneratedValue  // 主键⽣成的策略 - 根据底层数据库的驱动来决定的,mysql - ⾃增⻓的策略
    private Integer id;
    //⽤户名 - 唯⼀性
    private String username;
    //邮箱 - 唯⼀性
    private String email;
    private String password;
    private String gender;
    private int power;
}