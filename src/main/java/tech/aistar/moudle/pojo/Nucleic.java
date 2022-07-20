package tech.aistar.moudle.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author:马立皓
 * @time:16:10 2022/7/2
 */
@NoArgsConstructor  //空参构造
@AllArgsConstructor // 如果⼀个是实体类中没有提供任何⼀个构造的时候,那么系统默认会分配⼀个空参构造.但是如果⼀旦提供
                     //任何⼀个带参构造的时候,那么系统将不会再提供空参构

@Data  //空参构造, getter/setter,toString,equals&hashCode
@Entity // 这个类是⼀个实体类,表和这个类对应
@Table(name = "t_Nucleic")
public class Nucleic implements Serializable {
    @Id //对象的标识符(唯一)
    @GeneratedValue  //主键生成方法，实现主键自增
    private Integer id;
    //唯一性
    private String userId;
    private String userName;  //小驼峰命名 - 自动将数据库中响应的表名改成 user_name

    //date:年月日
    //datetime:年月日时分秒
    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )

    private Date createDate;
    //0 表示绿码   1 表示黄码    2 表示红码
    private int status;
    //评论
    private String remark;
    //住址
    private String url;


}
