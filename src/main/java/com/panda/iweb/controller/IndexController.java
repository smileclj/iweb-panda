package com.panda.iweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huixiangdou on 2016/8/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/model")
    public ModelAndView index(){
        System.out.println(222);
        return new ModelAndView("index.jsp");
    }
}
