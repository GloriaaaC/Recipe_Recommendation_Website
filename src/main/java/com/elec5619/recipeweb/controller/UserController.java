package com.elec5619.recipeweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elec5619.recipeweb.bean.FolderRecipe;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.bean.UserFolder;
import com.elec5619.recipeweb.bean.UserRecipe;
import com.elec5619.recipeweb.service.IFolderRecipeService;
import com.elec5619.recipeweb.service.IUserFolderService;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.service.ex.DeleteException;
import com.elec5619.recipeweb.service.ex.InsertException;
import com.elec5619.recipeweb.service.ex.RecipeNotFoundException;
import com.elec5619.recipeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserFolderService userFolderService;

    @Autowired
    private IFolderRecipeService folderRecipeService;

    /**
     * User registration
     * @author Andy
     * @param user user information
     * @return state_code_OK
     * */
    @RequestMapping("/reg")
    @ResponseBody
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        createOrUpdateFolder("Default", user.getUid(), null);
        return new JsonResult<>(CODE_OK);
    } 

    /**
     * User login
     * @author Andy
     * @param username login username
     * @param password login password
     * @param session HttpSession
     * @return state_code_OK
     * */
    @RequestMapping("/login")
    @ResponseBody
    public JsonResult<User> login(String username,String password, HttpSession session) {
        User result = userService.login(username, password);
        session.setAttribute("uid", result.getUid());
        session.setAttribute("username", result.getUsername());

        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));
        return new JsonResult<User>(CODE_OK, result);
    }

    /**
     * get Folder List By User Id
     * @param userId
     * @return
     */
    @GetMapping("/favorites")
    @ResponseBody
    public JsonResult<List<UserFolder>> getFolderByUserId(Integer userId) {
        QueryWrapper<UserFolder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.ne("is_delete",1);
        List<UserFolder> resultList = userFolderService.list(queryWrapper);
        return new JsonResult(CODE_OK, "success", resultList);
    }

    /**
     * create or Update Folder info
     * @param folderName
     * @param userId
     * @param newFolderName
     * @return Folder Id
     */
    @PostMapping("/favorites")
    @ResponseBody
    public JsonResult<Integer> createOrUpdateFolder(String folderName, Integer userId, String newFolderName) {
        // to find the folder with folder name, if no exist return null
        QueryWrapper<UserFolder> queryWrapper = new QueryWrapper<UserFolder>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("folder_name", folderName);
        queryWrapper.ne("is_delete",1);
        UserFolder folderResult = userFolderService.getOne(queryWrapper);

        // get username by userId
        User user = userService.getById(userId);
        String username = user.getUsername();
        Date date = new Date();
        // folderId for return
        Integer folderId;

        // Create
        if (folderResult == null) {
            // set new folder information
            UserFolder newResult = new UserFolder();
            newResult.setIsDelete(0);
            newResult.setFolderName(folderName);
            newResult.setUserId(userId);
            newResult.setCreatedUser(username);
            newResult.setCreatedTime(date);
            newResult.setModifiedUser(username);
            newResult.setModifiedTime(date);

            // save info into database
            Boolean result = userFolderService.save(newResult);

            // get folder Id
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            queryWrapper.eq("folder_name", folderName);
            queryWrapper.ne("is_delete",1);
            folderId = userFolderService.getOne(queryWrapper).getId();

        } else {// update
            //get folder info with newFolderName
            queryWrapper = new QueryWrapper<UserFolder>();
            queryWrapper.eq("user_id", userId);
            queryWrapper.eq("folder_name", newFolderName);
            queryWrapper.ne("is_delete",1);
            UserFolder tempFolder = userFolderService.getOne(queryWrapper);

            // if the newFolderName has existed or as null, it is invalid
            if (newFolderName == null || tempFolder != null) throw new InsertException("invalid Folder Name");

            //to update
            folderResult.setFolderName(newFolderName);
            folderResult.setModifiedUser(username);
            folderResult.setModifiedTime(date);
            Boolean result = userFolderService.updateById(folderResult);

            // get folderId
            folderId = userFolderService.getOne(queryWrapper).getId();
        }

        return new JsonResult<Integer>(CODE_OK,"success", folderId);
    }


    /**
     * delete folder By folderId
     * @param userId
     * @param folderId
     * @return state code
     */
    @DeleteMapping("/favorites")
    @ResponseBody
    public JsonResult<Void> deleteFolder(Integer userId, Integer folderId){
        // query info from database
        QueryWrapper<UserFolder> queryWrapper = new QueryWrapper<UserFolder>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("id", folderId);
        queryWrapper.ne("is_delete",1);
        UserFolder tempFolder = userFolderService.getOne(queryWrapper);

        if (tempFolder!=null) {
           tempFolder.setIsDelete(1);
           userFolderService.updateById(tempFolder);
           folderRecipeService.setIsDeleteByFolderId(folderId, 1);
           return new JsonResult<Void>(CODE_OK, "success");
        }

        return new JsonResult<Void>(CODE_NOT_FOUND,"folder not found");
    }

    /**
     * get Recipes By FolderId
     * @param folderId
     * @return recipes List
     */
    @GetMapping("/favorites/recipes")
    @ResponseBody
    public JsonResult<List<UserRecipe>> getRecipesByFolderId(Integer folderId){
        List<UserRecipe> resultList = userFolderService.getRecipesByFolderId(folderId);
        return new JsonResult<List<UserRecipe>>(CODE_OK, "success", resultList);
    }

    /**
     * add recipes into folder
     * @param folderId
     * @param recipeId
     * @return state code
     */
    @PostMapping("/favorites/recipes")
    @ResponseBody
    public JsonResult<Void> putRecipeInFolder(Integer folderId, Integer recipeId, HttpSession session){
        // query whether recipe is in the folder
        QueryWrapper<FolderRecipe> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("folder_id", folderId);
        queryWrapper.eq("recipe_id", recipeId);
        FolderRecipe folderRecipe = folderRecipeService.getOne(queryWrapper);

        if (folderRecipe != null && folderRecipe.getIsDelete() == 0) {
            throw new InsertException("recipe has existed");
        }

        // set entity for update or insert
        folderRecipe = new FolderRecipe();
        folderRecipe.setFolderId(folderId);
        folderRecipe.setRecipeId(recipeId);
        folderRecipe.setIsDelete(0);

        Date date = new Date();
        folderRecipe.setCreatedTime(date);
        folderRecipe.setCreatedUser(getUsernameFromSession(session));

        // if meeting the conditions, means update.
        UpdateWrapper<FolderRecipe> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("folder_id", folderId);
        updateWrapper.eq("recipe_id", recipeId);
        updateWrapper.eq("is_delete",1);
        folderRecipeService.saveOrUpdate(folderRecipe, updateWrapper);

        return new JsonResult<Void>(CODE_OK,"success");
    }

    /**
     * delete Recipe In the Folder
     * @param folderId
     * @param recipeId
     * @return state code
     */
    @DeleteMapping("/favorites/recipes")
    @ResponseBody
    public JsonResult<Void> deleteRecipeInFolder(Integer folderId, Integer recipeId){
        // query instance from database
        QueryWrapper<FolderRecipe> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("folder_id", folderId);
        queryWrapper.eq("recipe_id", recipeId);
        queryWrapper.eq("is_delete", 0);
        FolderRecipe folderRecipe = folderRecipeService.getOne(queryWrapper);

        // if not exist
        if (folderRecipe == null) {
            throw new DeleteException("recipe has not existed in the folder");
        }

        // if exist
        folderRecipe.setIsDelete(1);
        folderRecipeService.updateById(folderRecipe);

        return new JsonResult<Void>(CODE_OK, "success");
    }

    /**
     * User change password
     * @param userId user id
     * @param newPassword new password
     * @return state_code_OK
     * */
    @RequestMapping("/changePassword")
    @ResponseBody
    public JsonResult<Void> changePassword(String userId, String newPassword) {
        Integer rows = userService.updatePassword(userId, newPassword);
        if (rows == 0) {
            throw new InsertException("Update failure");
        }
        return new JsonResult<>(CODE_OK, "success");
    }
}

