package com.elec5619.recipeweb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.UserRecipe;

import java.util.List;

/** User module Service Interface*/
public interface IUserRecipeService extends IService<UserRecipe> {

    /**
     * @author Andy
     * @param recipe user recipe
     * recipe insert
     */
    void createAndUpdateUserRecipe(UserRecipe recipe, String username);


    /**
     * @author Andy
     * @param uid user ID
     * @return matching recipe by uid
     * */
    List<UserRecipe> listUserRecipeByUid(Integer uid);

    /**
     * find Recipe By Uid And RecipeId
     * @param userId
     * @param recipeId
     * @return userRecipe
     */
    UserRecipe findRecipeByUidAndRecipeId(Integer recipeId, Integer userId);

    /**
     *
     * @param recipeId
     * @param userId
     * @return
     */
    Integer deleteFavoriteByRecipeId(Integer recipeId, Integer userId, String username);

    /**
     *
     * @param recipeId
     * @param userId
     * @return
     */
    Integer addFavoriteByRecipeId(Integer recipeId, Integer userId, String username);
}
