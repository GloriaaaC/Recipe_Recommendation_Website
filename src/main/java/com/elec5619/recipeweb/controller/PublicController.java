package com.elec5619.recipeweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elec5619.recipeweb.bean.*;
import com.elec5619.recipeweb.service.IRecipeReviewService;
import com.elec5619.recipeweb.service.IUserFolderService;
import com.elec5619.recipeweb.service.IUserRecipeService;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/api")
@Controller
public class PublicController extends BaseController {
    @Autowired
    private IRecipeReviewService recipeReviewService;

    @Autowired
    private IUserRecipeService userRecipeService;

    @Autowired
    private IUserFolderService userFolderService;

    @Autowired
    private IUserService userService;

    /**
     * get AVG Rating By RecipeId
     * @param recipeId
     * @return
     */
    @GetMapping("/ratings")
    @ResponseBody
    public JsonResult<HashMap> getAvgRatingByRecipeId(Integer recipeId) {
        Integer rating = recipeReviewService.getAvgRatingByRecipeId(recipeId);
        HashMap<String,Integer> result = new HashMap<String, Integer>();
        result.put("rating", rating == null? -1 :rating);
        return new JsonResult<>(CODE_OK, result);
    }

    /**
     * save or update user rating on a recipe
     * @param userId
     * @param recipeId
     * @param rating
     * @return state code
     */
    @PostMapping("/ratings")
    @ResponseBody
    public JsonResult<Void> saveOrUpdateRating(Integer userId, Integer recipeId, Integer rating, HttpSession session){
        // create recipeReview Instance
        Date date = new Date();
        RecipeReview recipeReview = new RecipeReview();
        recipeReview.setUserId(userId);
        recipeReview.setRating(rating);
        recipeReview.setRecipeId(recipeId);
        recipeReview.setModifiedUser(getUsernameFromSession(session));

        recipeReview.setModifiedTime(date);
        recipeReview.setIsDelete(0);

        // set query wrapper for search conditions
        QueryWrapper<RecipeReview> recipeReviewQueryWrapper = new QueryWrapper<RecipeReview>();
        recipeReviewQueryWrapper.eq("user_id", userId);
        recipeReviewQueryWrapper.eq("recipe_id",recipeId);

        RecipeReview queryResult = recipeReviewService.getOne(recipeReviewQueryWrapper);

        // judge update or insert
        if (queryResult ==null) {
            recipeReview.setCreatedTime(date);
            recipeReview.setCreatedUser(getUsernameFromSession(session));
        }

        // set Update wrapper for search conditions
        UpdateWrapper<RecipeReview> recipeReviewUpdateWrapper = new UpdateWrapper<RecipeReview>();
        recipeReviewUpdateWrapper.eq("user_id", userId);
        recipeReviewUpdateWrapper.eq("recipe_id", recipeId);

        boolean result = recipeReviewService.saveOrUpdate(recipeReview, recipeReviewUpdateWrapper);
        if (result) {
            return new JsonResult<>(CODE_OK, "Success insert or update ratings");
        }
        else {
            return new JsonResult<>(CODE_REVIEW_INSERT_FAILURE,"You have rated the recipe");
        }
    }


    /**
     * get Reviews by recipeId
     * @param recipeId
     * @return review List
     */
    @GetMapping("/reviews")
    @ResponseBody
    public JsonResult<UserRecipe> getReviewsByRecipeId(Integer recipeId){
        List<RecipeReview> result = recipeReviewService.findByRecipeId(recipeId);
        UserRecipe recipe = new UserRecipe();
        recipe.setReviewList(result);
        return new JsonResult<UserRecipe>(CODE_OK,recipe);
    }

    /**
     * save or Update Review
     * @param userId
     * @param recipeId
     * @param review
     * @param session
     * @return state code
     */
    @PostMapping("/reviews")
    @ResponseBody
    public JsonResult<Void> saveOrUpdateReview(@NotNull  Integer userId, @NotNull  Integer recipeId, String review, HttpSession session){
        // set recipeReview instance
        Date date = new Date();
        RecipeReview recipeReview = new RecipeReview();
        recipeReview.setUserId(userId);
        recipeReview.setReview(review);
        recipeReview.setRecipeId(recipeId);
        recipeReview.setModifiedUser(getUsernameFromSession(session));

        recipeReview.setModifiedTime(date);
        recipeReview.setIsDelete(0);

        // set query wrapper for search conditions
        QueryWrapper<RecipeReview> recipeReviewQueryWrapper = new QueryWrapper<RecipeReview>();
        recipeReviewQueryWrapper.eq("user_id", userId);
        recipeReviewQueryWrapper.eq("recipe_id",recipeId);

        RecipeReview queryResult = recipeReviewService.getOne(recipeReviewQueryWrapper);

        // judge update or insert
        if (queryResult ==null) {
            recipeReview.setCreatedTime(date);
            recipeReview.setCreatedUser(getUsernameFromSession(session));
        }

        // set Update wrapper for search conditions
        UpdateWrapper<RecipeReview> recipeReviewUpdateWrapper = new UpdateWrapper<RecipeReview>();
        recipeReviewUpdateWrapper.eq("user_id", userId);
        recipeReviewUpdateWrapper.eq("recipe_id",recipeId);

        boolean result = recipeReviewService.saveOrUpdate(recipeReview, recipeReviewUpdateWrapper);
        if (result) {
            return new JsonResult<>(CODE_OK, "Success insert or update review");
        }
        else {
            return new JsonResult<>(CODE_REVIEW_INSERT_FAILURE,"you have reviewed the recipe");
        }
    }

    /**
     * get User history by userId
     * @param userId
     * @return user history
     */
    @GetMapping("/history")
    @ResponseBody
    public JsonResult<ArrayList<UserHistory>> getHistoryByUserId(Integer userId){
        // query all recipe by user id
        List<UserRecipe> result = userRecipeService.listUserRecipeByUid(userId);

        // spilt the recipes by dates, the key is date, the value is history list.
        HashMap<String, UserHistory> tempMap = new HashMap<String, UserHistory>();


        // set Date into format
        String datePattern = "yyyy-MM-dd";
        for (UserRecipe u: result) {
            SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
            String tempDate = formatter.format(u.getModifiedTime());

            //get avg rating of recipe
            Integer rating = recipeReviewService.getAvgRatingByRecipeId(u.getRecipeId());
            u.setAvgRating(rating == null? -1 :rating);

            // add into user history
            UserHistory tempUserHistory;
            if (tempMap.containsKey(tempDate)) {
                tempUserHistory = tempMap.get(tempDate);
            }
            else {
                tempUserHistory = new UserHistory();
                tempUserHistory.setItems(new ArrayList<UserRecipe>());
                tempUserHistory.setDate(tempDate);
            }
            tempUserHistory.updateRecipeList(u);
            tempMap.put(tempDate,tempUserHistory);
        }

        // change into format
        Map<String, UserHistory> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        reverseSortedMap.putAll(tempMap);

        Collection<UserHistory> valueCollection = reverseSortedMap.values();
        ArrayList<UserHistory> resultList = new ArrayList<UserHistory>(valueCollection);
        return new JsonResult<ArrayList<UserHistory>>(CODE_OK,"success", resultList);
    }

    /**
     * User registration
     * @author Andy
     * @param userRecipe userRecipe information
     * @return state_code_OK
     * */
    @PutMapping("/history")
    @ResponseBody
    public JsonResult<Void> createAndUpdateHistory(UserRecipe userRecipe, HttpSession session) {
        userRecipe.setUid(getUidFromSession(session));
        userRecipeService.createAndUpdateUserRecipe(userRecipe, getUsernameFromSession(session));
        return new JsonResult<>(CODE_OK, "success");
    }


    /**
     * delete History By HistoryId
     * @param historyId
     * @return statecode
     */
    @DeleteMapping("/history")
    @ResponseBody
    public JsonResult<Void> deleteHistoryByHistoryId(Integer historyId){
        // get user Recipe History
        UserRecipe userRecipeResult = userRecipeService.getById(historyId);


        // has been deleted
        if (userRecipeResult.getIsDelete() == 1) {
            return new JsonResult<Void>(CODE_NOT_FOUND, "no such history item");
        }

        // success
        userRecipeResult.setIsDelete(1);
        boolean result = userRecipeService.updateById(userRecipeResult);
        if (result) {
            return new JsonResult<Void>(CODE_OK, "success");
        }

        return new JsonResult<Void>(CODE_NOT_FOUND, "delete failure");
    }


    /**
     * get Is Liked By Uid And RecipeId
     * @param recipeId
     * @param userId
     * @return
     */
    @GetMapping("/liked")
    @ResponseBody
    public JsonResult<HashMap> getLikedByUidAndRecipeId(Integer recipeId, Integer userId){
        UserRecipe userRecipeResult = userRecipeService.findRecipeByUidAndRecipeId(recipeId, userId);

        if (null == userRecipeResult) return new JsonResult<>(CODE_NOT_FOUND, "Not Such Liked Item", null);

        HashMap<String, Boolean> resultMap = new HashMap<>();
        Boolean resultFlag = userRecipeResult.getIsFavorite() == 0 ? false : true;
        resultMap.put("liked", resultFlag);
        return new JsonResult<HashMap>(CODE_OK, "success", resultMap);
    }

    /**
     * delete liked by uid and recipeId
     * @param recipeId
     * @param userId
     * @param session
     * @return state code
     */
    @DeleteMapping("/liked")
    @ResponseBody
    public JsonResult<Void> deleteLikedByUidAndRecipeId(Integer recipeId, Integer userId, HttpSession session){
        userRecipeService.deleteFavoriteByRecipeId(recipeId, userId, getUsernameFromSession(session));
        return new JsonResult<Void>(CODE_OK, "success");
    }
}
