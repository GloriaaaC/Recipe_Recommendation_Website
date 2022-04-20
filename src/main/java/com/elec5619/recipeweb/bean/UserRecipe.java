package com.elec5619.recipeweb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.io.Serializable;
import java.util.List;


// 指定表格
@TableName(value = "user_recipe")
// 自动生成 getter，setter， toString method
@Data
public class UserRecipe extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7820056143005998627L;

    @TableId(value = "rid", type= IdType.AUTO)
    private Integer rid;

    private Integer recipeId;

    private Integer uid;

    private String recipeName;

    private String imageUrl;

    private Integer isDelete;

    private Integer isFavorite;

    @TableField(exist = false)
    private List<RecipeReview> reviewList;

    @TableField(exist = false)
    private Integer avgRating;
}

