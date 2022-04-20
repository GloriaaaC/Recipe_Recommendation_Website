package com.elec5619.recipeweb.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * 用于给递送前端数据，不用于数据库交互
 */
@Data
public class UserHistory implements Serializable {
    private static final long serialVersionUID = -8655130590432259674L;

    private static final String datePattern = "YYYY-MM-DD";

    @TableField(exist = false)
    private String date;

    @TableField(exist = false)
    private List<UserRecipe> items;

    public void updateRecipeList(UserRecipe recipe){
        this.items.add(recipe);
    }
}
