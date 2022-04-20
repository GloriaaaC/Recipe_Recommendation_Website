package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.UserFolder;
import com.elec5619.recipeweb.bean.UserRecipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFolderMapper extends BaseMapper<UserFolder> {

    List<UserRecipe> getRecipesByFolderId(Integer folderId);
}
