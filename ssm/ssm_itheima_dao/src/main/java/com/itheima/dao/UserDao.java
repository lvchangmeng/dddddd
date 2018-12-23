package com.itheima.dao;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

    int findCount(PageBean pageBean);

    public List<User> findAll(PageBean pageBean);

    public User findLogin(User user);

    public void saveUser(User user);

    public void delUser(Integer id);

    public void updateUser(User user);

    User findById(Integer id);
}
