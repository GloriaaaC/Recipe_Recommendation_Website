package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.RecipeReview;
import com.elec5619.recipeweb.bean.UserRecipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeReviewMapper extends BaseMapper<RecipeReview> {
    List<RecipeReview> selectByRecipeId(Integer recipeId);

    Integer selectAvgRatingByRecipeId(Integer recipeId);
}
