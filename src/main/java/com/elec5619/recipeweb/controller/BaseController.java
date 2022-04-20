package com.elec5619.recipeweb.controller;

import com.elec5619.recipeweb.service.ex.*;
import com.elec5619.recipeweb.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/** controller baseEntity focusing on exception deal*/
public class BaseController {

    // successful operation
    public static final int CODE_OK = 200;

    public static final int CODE_USER_EXIST = 3000;

    public static final int CODE_USER_NOT_FOUND = 3001;

    public static final int CODE_USER_PASSWORD_NOT_MATCH= 3002;

    public static final int CODE_USER_NULL_VALUE= 3003;

    public static final int CODE_INSERT_FAILURE = 4000;

    public static final int CODE_REVIEW_INSERT_FAILURE = 400;

    public static final int CODE_NOT_FOUND = 404;

    public static final int CODE_DELETE_FAILURE = 4001;
    // catch Service Exception and handle it
    /**
     * 现有异常类型：
     * UsernameDuplicationException: 用户名重复异常
     * InsertException: 用户插入异常
     * UserNotFoundException: 用户未找到异常
     * PasswordNotMatchException: 密码不匹配异常
     * */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);

        if (e instanceof UsernameDuplicationException) {
            result.setState(CODE_USER_EXIST);
            result.setMessage("User has already existed");
        } else if (e instanceof InsertException) {
            result.setState(CODE_INSERT_FAILURE);
        } else if (e instanceof UserNotFoundException) {
            result.setState(CODE_USER_NOT_FOUND);
            result.setMessage("User can not be found");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(CODE_USER_PASSWORD_NOT_MATCH);
            result.setMessage("Password not match");
        } else if (e instanceof  InvalidValueException) {
            result.setState(CODE_USER_NULL_VALUE);
            result.setMessage("NULL value");
        } else if (e instanceof RecipeNotFoundException) {
            result.setState(CODE_NOT_FOUND);
            result.setMessage("can not found Recipe");
        } else if (e instanceof DeleteException) {
            result.setState(CODE_DELETE_FAILURE);
        }

        return result;
    }

    /**
     * @param session httpsession
     * @return UID data from session
     * get UID from session
     * */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * @param session httpsession
     * @return username data from session
     * get username from session
     * */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
}
