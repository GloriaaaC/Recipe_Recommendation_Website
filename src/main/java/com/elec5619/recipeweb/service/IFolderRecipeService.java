package com.elec5619.recipeweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.FolderRecipe;
import org.springframework.stereotype.Service;


public interface IFolderRecipeService extends IService<FolderRecipe> {

    Integer setIsDeleteByFolderId(Integer FolderId, Integer isDelete);
}
