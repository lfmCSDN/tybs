package com.ty.tybs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by Lfm
 * on 2018-03-18 12:45
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }


}
