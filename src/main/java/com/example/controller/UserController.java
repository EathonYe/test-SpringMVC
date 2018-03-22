package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public User get(){

        User user = new User();

        try {
            user = userService.getUser(1);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return user;
    }
}
