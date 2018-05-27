package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询一个用户
     *
     * @param  id 用户id
     * @return User
     */
    public User getUser(Integer id)  throws Exception {
        return userMapper.getUser(id);
    }

    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception {
        return userMapper.insertUser(user);
    }

    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser(User user) throws Exception {
        return userMapper.updateUser(user);
    }

    /**
     * 刪除用戶
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(Integer id) throws Exception {
        return userMapper.deleteUser(id);
    }

    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<User> getUsers(User user) {
        return userMapper.getUsers(user);
    }

    /**
     * 查询用户角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        return userMapper.findRoles(username);
    }

    /**
     * 查询用户权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        return userMapper.findPermissions(username);
    }
}

