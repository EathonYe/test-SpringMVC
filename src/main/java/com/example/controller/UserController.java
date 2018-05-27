package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public User get(@PathVariable Integer id){

        User user = new User();

        try {
            user = userService.getUser(id);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return user;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addUser(@ModelAttribute User user) {
        JSONObject result = new JSONObject();
        try {
            userService.insertUser(user);
            result.put("successful", true);
            result.put("msg", "成功添加用户！");
        } catch (Exception e) {
            result.put("successful", false);
            result.put("msg", "添加用户失败！");
        } finally {

        }

        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteUser(User user) {
        JSONObject result = new JSONObject();
        try {
            userService.deleteUser(user.getId());
            result.put("successful", true);
            result.put("msg", "成功删除用户！");
        } catch (Exception e) {
            result.put("successful", false);
            result.put("msg", "删除用户失败！");
        } finally {

        }

        return result;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateUser(User user) {
        JSONObject result = new JSONObject();
        try {
            userService.updateUser(user);
            result.put("successful", true);
            result.put("msg", "用户更新成功!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("successful", false);
            result.put("msg", "用户更新失败!");
        } finally {

        }

        return result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public JSONObject list(User user) {
        JSONObject result = new JSONObject();

        try {
            List<User> userList = userService.getUsers(user);
            result.put("successful", true);
            result.put("data", userList);
        } catch (Exception e) {
            result.put("successful", false);
            result.put("msg", "用户列表获取失败！");
        }

        return result;
    }

    @RequestMapping("")
    public ModelAndView testShiro() {
//        List<User> users = userService.getUsers(new User());
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
