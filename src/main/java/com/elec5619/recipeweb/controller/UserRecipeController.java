package com.elec5619.recipeweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.bean.UserRecipe;
import com.elec5619.recipeweb.service.IUserRecipeService;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/recipes")
public class UserRecipeController extends BaseController{

    @Autowired
    private IUserRecipeService userRecipeService;

    /**
     * User registration
     * @author Andy
     * @param userRecipe userRecipe information
     * @return state_code_OK
     * */
    @RequestMapping("/createAndUpdate")
    @ResponseBody
    public JsonResult<Void> createAndUpdate(UserRecipe userRecipe, HttpSession session) {
        userRecipe.setUid(getUidFromSession(session));
        userRecipeService.createAndUpdateUserRecipe(userRecipe, getUsernameFromSession(session));
        return new JsonResult<>(CODE_OK);
    }


    /**
     * get Recipe info by uid and recipeId
     * @param userId
     * @param recipeId
     * @return
     */
    @GetMapping("/getRecipe")
    @ResponseBody
    public JsonResult<UserRecipe> getRecipe(Integer userId, Integer recipeId) {
        QueryWrapper<UserRecipe> queryWrapper = new QueryWrapper<UserRecipe>();
        queryWrapper.eq("uid", userId);
        queryWrapper.eq("recipe_id", recipeId);
        queryWrapper.eq("is_delete",0);
        UserRecipe result = userRecipeService.getOne(queryWrapper);
        return new JsonResult<>(CODE_OK, "success", result);
    }
}

