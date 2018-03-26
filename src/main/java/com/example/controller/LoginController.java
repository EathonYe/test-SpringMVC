package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ModelAndView getLoginView() {
        ModelAndView modelAndView = new ModelAndView("login");

        return modelAndView;
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        result.put("successful", false);

        User userSelective = new User();
        userSelective.setUsername(username);

        try {
            List<User> userList = userService.getUsers(userSelective);
            User user = userList.get(0);
            if (userList != null && !userList.isEmpty() &&
                    user.getPassword().equals(password)) {
                result.put("successful", true);
                result.put("message", "登录成功！");

                HttpSession session = request.getSession();
                user.setPassword(null);
                session.setAttribute("subject", user);
            } else {
                result.put("message", "用户名或密码错误！");
            }
        } catch (Exception e) {
            result.put("message", "用户名或密码错误！");
        }

        return result;

//        return "login";
    }
}

