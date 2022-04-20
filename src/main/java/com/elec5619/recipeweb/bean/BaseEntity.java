package com.elec5619.recipeweb.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    private String createdUser;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createdTime;

    private String modifiedUser;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifiedTime;
}
