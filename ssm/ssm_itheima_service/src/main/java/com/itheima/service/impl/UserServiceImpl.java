package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int findCount(PageBean pageBean) {
        if(pageBean.getUser()!=null){
            if(pageBean.getUser().getUsername()!=null&&pageBean.getUser().getUsername().trim().length()==0){
                pageBean.getUser().setUsername(null);
            }
            if(pageBean.getUser().getAddress()!=null&&pageBean.getUser().getAddress().trim().length()==0){
                pageBean.getUser().setAddress(null);
            }
            if(pageBean.getUser().getEmail()!=null&&pageBean.getUser().getEmail().trim().length()==0){
                pageBean.getUser().setEmail(null);
            }
        }
        return userDao.findCount(pageBean);
    }

    public List<User> findAll(PageBean pageBean) {
        /**
         *  limit:  start 起始位置索引
         *          rows 每页显示条数
         *
         *          start = 当前页码-1*每页显示条数
         */

        if(pageBean.getUser()!=null){
            if(pageBean.getUser().getUsername()!=null&&pageBean.getUser().getUsername().trim().length()==0){
                pageBean.getUser().setUsername(null);
            }
            if(pageBean.getUser().getAddress()!=null&&pageBean.getUser().getAddress().trim().length()==0){
                pageBean.getUser().setAddress(null);
            }
            if(pageBean.getUser().getEmail()!=null&&pageBean.getUser().getEmail().trim().length()==0){
                pageBean.getUser().setEmail(null);
            }
        }
        pageBean.setStart((pageBean.getCurrentPage() - 1) * pageBean.getRows());
        return userDao.findAll(pageBean);
    }

    @Override
    public User findLogin(User user) {
        return userDao.findLogin(user);
    }

    @Override
    public void saveUser(User user) {

        userDao.saveUser(user);
    }

    @Override
    public void delUser(Integer id) {
        userDao.delUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void delAll(String[] uids) {
        if(uids != null && uids.length>0){
            for (String uid : uids) {
                userDao.delUser(Integer.parseInt(uid));
            }
        }
    }
}
