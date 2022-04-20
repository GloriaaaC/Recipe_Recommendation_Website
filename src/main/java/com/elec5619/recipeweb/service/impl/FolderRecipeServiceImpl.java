package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.FolderRecipe;
import com.elec5619.recipeweb.mapper.FolderRecipeMapper;
import com.elec5619.recipeweb.service.IFolderRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderRecipeServiceImpl extends ServiceImpl<FolderRecipeMapper, FolderRecipe> implements IFolderRecipeService {

    @Autowired
    FolderRecipeMapper folderRecipeMapper;

    @Override
    public Integer setIsDeleteByFolderId(Integer FolderId, Integer isDelete) {
        return folderRecipeMapper.setIsDeleteByFolderId(FolderId, isDelete);
    }
}
