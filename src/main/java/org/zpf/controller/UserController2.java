package org.zpf.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zpf.domain.User;

import javax.servlet.http.HttpSession;

@Controller
public class UserController2 {
    /**
     * 处理action请求
     */
    @RequestMapping(value = "/login2")
    public ModelAndView login(
            String loginName,
            String password,
            ModelAndView modelAndView,
            HttpSession session
    ) {
        //模拟数据库根据用户名和密码查找用户,判断用户登录
        if (loginName != null
                && loginName.equals("zpf")
                && password != null
                && password.equals("123456")
        ) {
            //模拟创建用户
            User user = new User();
            user.setLoginName(loginName);
            user.setPassword(password);
            user.setUserName("管理员");
            //登录成功。将user对象设置到HttpSession作用域中
            session.setAttribute("user", user);
            //转发到main请求
            modelAndView.setViewName("redirect:main");
        } else {
            //登录失败,设置失败信息,并跳转到登录页面
            modelAndView.addObject("message", "登录名或密码错误，请重新输入");
            modelAndView.setViewName("loginForm");
        }
        return modelAndView;
    }
}
