package com.elec5619.recipeweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.UserFolder;
import com.elec5619.recipeweb.bean.UserRecipe;

import java.util.List;

public interface IUserFolderService extends IService<UserFolder> {

    List<UserRecipe> getRecipesByFolderId(Integer folderId);
}
