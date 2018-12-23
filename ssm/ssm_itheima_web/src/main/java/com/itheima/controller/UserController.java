package com.itheima.controller;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findLogin")
    public String findLogin(User user,String ck,HttpSession session,HttpServletResponse response){
        User u = userService.findLogin(user);
        if (u != null){
            session.setAttribute("user",u);
            Cookie cookieName = new Cookie("username",u.getUsername());
            Cookie cookPwd = new Cookie("pwd", u.getPwd());
            if("1".equals(ck)){
                cookieName.setMaxAge(60*60*24*7);
                cookPwd.setMaxAge(60*60*24*7);
                //设置响应路径
                cookieName.setPath("/");
                cookPwd.setPath("/");
            }else{
                cookieName.setMaxAge(0);
                cookPwd.setMaxAge(0);
            }
            response.addCookie(cookieName);
            response.addCookie(cookPwd);
            return "index1";
        }else{
            return "loginError";
        }

    }

    @RequestMapping("/findAll")
    public String findAll(PageBean pageBean,Model model){
        int totalCount = userService.findCount(pageBean);//获取总记录数

        if(pageBean != null){
            if(pageBean.getCurrentPage() == null){
                pageBean.setCurrentPage(1);
            }
            if(pageBean.getRows() == null){
                pageBean.setRows(3);
            }
        }

        pageBean.setTotalCount(totalCount);//总记录数
        List<User> users = userService.findAll(pageBean);

        model.addAttribute("userList",users);
        model.addAttribute("pages",pageBean);
        return "list";
    }

    @RequestMapping("/listToadd")
    public String listToadd(){
        return "add";

    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        userService.saveUser(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/delUser")
    public String delUser(User user) {

        userService.delUser(user.getId());
        return "redirect:/user/findAll";
    }

    @RequestMapping("/listToupdate")
    public String listToupdate(Integer id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){

        userService.updateUser(user);

        return "redirect:/user/findAll";
    }

    @RequestMapping("/delAll")
    public String delAll(HttpServletRequest request){
        String[] uids = request.getParameterValues("uid");
        userService.delAll(uids);
        return "redirect:/user/findAll";
    }
}
