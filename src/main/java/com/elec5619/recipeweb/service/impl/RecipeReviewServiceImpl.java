package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.RecipeReview;
import com.elec5619.recipeweb.mapper.RecipeReviewMapper;
import com.elec5619.recipeweb.service.IRecipeReviewService;
import com.elec5619.recipeweb.service.ex.InsertException;
import com.elec5619.recipeweb.service.ex.ReviewNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RecipeReviewServiceImpl extends ServiceImpl<RecipeReviewMapper, RecipeReview> implements IRecipeReviewService {

    @Autowired
    RecipeReviewMapper recipeReviewMapper;

    @Override
    public RecipeReview findByReviewId(Integer reviewId) {
        RecipeReview result = recipeReviewMapper.selectById(reviewId);
        if (result == null) {
            throw new ReviewNotFoundException("Review not Found by reviewId");
        }
        return result;
    }

    @Override
    public List<RecipeReview> findByRecipeId(Integer recipeId) {
        List<RecipeReview> result = recipeReviewMapper.selectByRecipeId(recipeId);
        if (result.size() == 0) {
            throw new ReviewNotFoundException("No Review Found by recipeId");
        }
        return result;
    }

    @Override
    public Integer updateByRecipeId(RecipeReview recipeReview) {
        Integer result = recipeReviewMapper.updateById(recipeReview);
        if (result !=1) {
            throw  new InsertException("Review update failure");
        }
        return result;
    }

    @Override
    public Integer getAvgRatingByRecipeId(Integer recipeId) {
        return recipeReviewMapper.selectAvgRatingByRecipeId(recipeId);
    }
}
