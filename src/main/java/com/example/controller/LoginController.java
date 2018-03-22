package com.example.controller;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("")
    public ModelAndView getLoginView() {
        ModelAndView modelAndView = new ModelAndView("login");

        return modelAndView;
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username", "Eathon");
        session.setAttribute("loginSuccess", true);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "success");
        return jsonObject;

//        return "login";
    }
}

