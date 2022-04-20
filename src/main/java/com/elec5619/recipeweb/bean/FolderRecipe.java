package com.elec5619.recipeweb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "folder_recipe")
@Data
public class FolderRecipe extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2591767865109105409L;

    @TableId(value = "id", type= IdType.AUTO)
    private Integer Id;

    private Integer folderId;

    private Integer recipeId;

    private Integer isDelete;

}
