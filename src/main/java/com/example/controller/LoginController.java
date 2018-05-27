package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

//    @RequestMapping("")
//    public ModelAndView getLoginView() {
//        ModelAndView modelAndView = new ModelAndView("login");
//
//        return modelAndView;
//    }

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
                result.put("msg", "登录成功！");

                HttpSession session = request.getSession();
                user.setPassword(null);
                session.setAttribute("subject", user);
            } else {
                result.put("msg", "用户名或密码错误！");
            }
        } catch (Exception e) {
            result.put("msg", "用户名或密码错误！");
        }

        return result;

//        return "login";
    }

    @PostMapping("/")
    public @ResponseBody JSONObject shiroLogin(User user) {
        JSONObject result = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword()) ;
        try {
            subject.login(token);
            result.put("successful", true);
            result.put("msg", "登录成功！");
            return result;
        }catch (Exception e){
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//            e.printStackTrace();
            result.put("successful", true);
            result.put("msg", "用户名或密码错误！");
            return result;
        }
    }
}

