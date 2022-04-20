package com.elec5619.recipeweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController extends BaseController{

    /**
     * Get Login Page
     * */
    @RequestMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    /**
     * Get Register Page
     */
    @RequestMapping("/register")
    public String getRegPage() {
        return "register";
    }

    /**
     * Get Index Page
     */
    @RequestMapping("/index")
    public String getIndexPage() {
        return "index";
    }


    /**
     * Get personal account page
     */
    @RequestMapping("/account")
    public String account() {
        return "account";
    }


    /**
     * Get History Page
     */
    @RequestMapping("/history")
    public String getHistoryPage() {
        return "history";
    }

    /**
     * Get recipe page
     */
    @RequestMapping("/recipe")
    public String getRecipePage() {
        return "recipe";
    }


    /**
     * Get favourite recipe page
     */
    @RequestMapping("/favourite")
    public String favourite() {
        return "favourite";
    }

    /**
     * Get favourite recipe page
     */
    @RequestMapping("/password")
    public String changePassword() {
        return "password";
    }


}
