package org.zpf.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zpf.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    /**
     * 处理/main请求
     */
    @RequestMapping(value = "/main")
    public String main(Model model) {
    //模拟数据库所获得的所有图书集合
        List<Book> book_list=new ArrayList<>();
        book_list.add(new Book("java.jpg","疯狂java讲义","李刚",74.21));
        book_list.add(new Book("ee.jpg","轻量级JAVAEE企业应用实战","李刚",59.2));
        book_list.add(new Book("android.jpg","疯狂android讲义","李刚",60.6));
        book_list.add(new Book("ajax.jpg","疯狂AJAX讲义","李刚",66.66));
        //将图书添加到model中
        model.addAttribute("book_list",book_list);
        return "main";
    }
}
