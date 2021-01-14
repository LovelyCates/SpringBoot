package edu.sakura.entity;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  // get 和 set 方法
@NoArgsConstructor // 无参构造方法
@AllArgsConstructor // 有参构造方法
@ToString // ToString 方法
@ApiModel("管理员实体类")
public class Admin {
    private Integer id;
    private String name;
    private String pwd;
    private String tel;
    private Integer status;
}
