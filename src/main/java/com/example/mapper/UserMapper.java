package com.example.mapper;

import com.example.model.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询一个用户
     *
     * @param  id 用户id
     * @return User
     */
    public User getUser(Integer id) throws Exception;

    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception;

    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser(User user) throws Exception;

    /**
     * 刪除用戶
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(Integer id) throws Exception;

    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<User> getUsers(User user) throws Exception;
}