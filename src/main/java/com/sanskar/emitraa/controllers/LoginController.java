package com.sanskar.emitraa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ModelAndView getLogin(){
        return new ModelAndView("index");
    }

    @GetMapping("/")
    public ModelAndView getDefault(){
        return new ModelAndView("index");
    }



}
