package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.UserRecipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRecipeMapper extends BaseMapper<UserRecipe> {

    UserRecipe findByRecipeId(Integer recipeId, Integer uid);

    List<UserRecipe> listUserRecipeByUid(Integer uid);

    Boolean updateIsFavoriteByRecipeId(Integer recipeId, Integer uid, Integer isFavorite);
}
