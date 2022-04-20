package com.elec5619.recipeweb.controller;

import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.elec5619.recipeweb.controller.BaseController.CODE_OK;

@Controller
@RequestMapping("/user")
public class TestController {
//
//    @Autowired
//    private IUserService userService;
//
//    @RequestMapping("/history")
//    public String history() {
//        return "history";
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping("/register")
//    public String register() {
//        return "register";
//    }
//
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
//
//    /**
//     * @param username 用户名
//     * @param password 密码
//     * @return 返回状态码和用户ID（int）
//     */
//    @RequestMapping("/loginCheck")
//    @ResponseBody
//    public JsonResult<User> loginCheck(String username, String password){
//        User result = userService.login(username, password);
//        return new JsonResult<User>(CODE_OK, result);
//    }
//
//    /**
//     *
//     * @param username 用户名
//     * @param password 用户密码
//     * @return 返回状态码，200表示注册成功
//     */
//    @RequestMapping("/registerCheck")
//    @ResponseBody
//    public JsonResult<Void> registerCheck(String username, String password){
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        userService.reg(user);
//        return new JsonResult<>(CODE_OK);
//    }
//
//    /**
//     *
//     * @param userID 当前用户ID
//     * @param id 食谱ID
//     * @param title 食谱title
//     * @param image 食谱图像url
//     * @return 状态码，是否成功接收到数据
//     */
    @RequestMapping("/indexCheck")
    @ResponseBody
    public JsonResult<Void> indexCheck(String id, String title, String image){
        System.out.println(id);
        System.out.println(title);
        System.out.println(image);
        return new JsonResult<>(CODE_OK);
    }
}
