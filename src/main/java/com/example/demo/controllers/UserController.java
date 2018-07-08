package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @RequestMapping("/showReg")
    public ModelAndView chatWindow(){
        return new ModelAndView("registerUser");
    }
}
