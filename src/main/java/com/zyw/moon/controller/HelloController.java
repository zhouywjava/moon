package com.zyw.moon.controller;

import com.zyw.moon.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 欢迎
 * @Author: zyw
 * @Date: 2018/3/29
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private Book book;

    @GetMapping("/index")
    public String index() {
        return book.getBookName()+":"+book.getBookAuthor();
    }
}
