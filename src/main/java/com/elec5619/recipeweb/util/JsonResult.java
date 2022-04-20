package com.elec5619.recipeweb.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<E> implements Serializable {

    private Integer state;

    private String message;

    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }


    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }
}
