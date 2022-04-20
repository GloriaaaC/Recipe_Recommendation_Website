package com.elec5619.recipeweb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@TableName(value = "user_folder")

@Data
public class UserFolder  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1294394465942547955L;

    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private String folderName;

    private Integer userId;

    private Integer isDelete;

    @TableField(exist = false)
    private List<UserRecipe> recipeList;
}
