package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.UserFolder;
import com.elec5619.recipeweb.bean.UserRecipe;
import com.elec5619.recipeweb.mapper.UserFolderMapper;
import com.elec5619.recipeweb.service.IUserFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFolderServiceImpl extends ServiceImpl<UserFolderMapper, UserFolder> implements IUserFolderService {
    @Autowired
    UserFolderMapper userFolderMapper;

    @Override
    public List<UserRecipe> getRecipesByFolderId(Integer folderId) {
        return  userFolderMapper.getRecipesByFolderId(folderId);
    }
}
