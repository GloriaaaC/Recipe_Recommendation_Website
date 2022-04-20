package com.elec5619.recipeweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.RecipeReview;

import java.util.List;

public interface IRecipeReviewService extends IService<RecipeReview> {

    /**
     * find review by ID
     * @param reviewId
     * @return Recipe Review
     */
    RecipeReview findByReviewId(Integer reviewId);

    /**
     * find review by Recipe ID
     * @param recipeId
     * @return Recipe Review
     */
    List<RecipeReview> findByRecipeId(Integer recipeId);

    /**
     * update review by id
     * @param recipeReview
     * @return flag
     */
    Integer updateByRecipeId(RecipeReview recipeReview);

    /**
     * get Avg Rating By RecipeId
     * @param recipeId
     * @return ratings
     */
    Integer getAvgRatingByRecipeId(Integer recipeId);
}
