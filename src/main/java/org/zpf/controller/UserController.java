package org.zpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zpf.domain.User;

import javax.validation.Valid;

@Controller
public class UserController {
    @RequestMapping(value = "/{formName}")
    public String loginForm(
            @PathVariable String formName,
            Model model
    ) {
        User user = new User();
        model.addAttribute("user", user);
        //动态跳转
        return formName;
    }

    //数据校验使用@Valid,后面跟着Errors对象保存校验信息
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @Valid @ModelAttribute User user,
            Errors errors,
            Model model
    ) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        model.addAttribute("user", user);
        return "success";
    }

}
