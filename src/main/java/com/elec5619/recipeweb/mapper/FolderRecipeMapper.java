package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.FolderRecipe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FolderRecipeMapper extends BaseMapper<FolderRecipe> {

    Integer setIsDeleteByFolderId(Integer folderId, Integer isDelete);
}
