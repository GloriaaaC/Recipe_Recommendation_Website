package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.UserRecipe;
import com.elec5619.recipeweb.mapper.UserRecipeMapper;
import com.elec5619.recipeweb.service.IUserRecipeService;
import com.elec5619.recipeweb.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/** RecipeService Implementation */
//@Slf4j
@Service
public class UserRecipeServiceImpl extends ServiceImpl<UserRecipeMapper, UserRecipe> implements IUserRecipeService {

    @Autowired
    private UserRecipeMapper userRecipeMapper;

    @Override
    public void createAndUpdateUserRecipe(UserRecipe recipe, String username) {
        UserRecipe result = userRecipeMapper.findByRecipeId(recipe.getRecipeId(), recipe.getUid());

        Date date = new Date();
        if (result == null) {
            recipe.setIsDelete(0);
            recipe.setIsFavorite(0);
            recipe.setCreatedUser(username);
            recipe.setModifiedUser(username);
            recipe.setCreatedTime(date);
            recipe.setModifiedTime(date);
            Integer rows = userRecipeMapper.insert(recipe);
            if (rows != 1) {
                throw new InsertException("Fail to insert Recipe");
            }
        } else {
            // if deleted, some part of data has been inserted before.
            if (result.getIsDelete() == 1) {
                result.setIsDelete(0);
                result.setIsFavorite(0);
                result.setCreatedUser(username);
                result.setModifiedUser(username);
                result.setCreatedTime(date);
            }

            result.setModifiedTime(date);
            Integer rows = userRecipeMapper.updateById(result);
            if (rows != 1) {
                throw new InsertException("Fail to update Recipe");
            }
        }
    }

    @Override
    public List<UserRecipe> listUserRecipeByUid(Integer uid) {
        return userRecipeMapper.listUserRecipeByUid(uid);
    }

    @Override
    public UserRecipe findRecipeByUidAndRecipeId(Integer recipeId, Integer userId) {
        return userRecipeMapper.findByRecipeId(recipeId, userId);
    }

    @Override
    public Integer deleteFavoriteByRecipeId(Integer recipeId, Integer userId, String username) {
        UserRecipe userRecipe = userRecipeMapper.findByRecipeId(recipeId, userId);
        if (userRecipe == null) {
            throw new RecipeNotFoundException("Fail to find Recipe");
        }
        Date date = new Date();
        userRecipe.setIsFavorite(1);
        userRecipe.setModifiedUser(username);
        userRecipe.setModifiedTime(date);

        Integer rows = userRecipeMapper.updateById(userRecipe);
        if (rows != 1) {
            throw new InsertException("Fail to update Recipe Favorite");
        }
        return rows;
    }

    @Override
    public Integer addFavoriteByRecipeId(Integer recipeId, Integer userId, String username) {
        UserRecipe userRecipe = userRecipeMapper.findByRecipeId(recipeId, userId);
        if (userRecipe == null) {
            throw new RecipeNotFoundException("Fail to find Recipe");
        }
        Date date = new Date();
        userRecipe.setIsFavorite(0);
        userRecipe.setModifiedUser(username);
        userRecipe.setModifiedTime(date);

        Integer rows = userRecipeMapper.updateById(userRecipe);
        if (rows != 1) {
            throw new InsertException("Fail to add Recipe Favorite");
        }
        return rows;
    }


}
