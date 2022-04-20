package com.elec5619.recipeweb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class RecipeReview extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4851015344861278774L;

    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private Integer recipeId;

    private Integer userId;

    private Integer rating;

    private String review;

    private Integer isDelete;

    @TableField(exist = false)
    private String username;
}
