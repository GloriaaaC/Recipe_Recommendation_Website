package com.elec5619.recipeweb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


// 指定表格
@TableName(value = "t_user")
// 自动生成 getter，setter， toString method
@Data
public class User extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -8272847649823095045L;

    @TableId(value = "uid", type= IdType.AUTO)
    private Integer uid;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String salt;

    private String Phone;

    private String email;

    private Integer gender;

    private String avatar;

    private Integer isDelete;
}
