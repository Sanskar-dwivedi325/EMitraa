package com.sanskar.emitraa.controllers;


import com.sanskar.emitraa.model.Users;
import com.sanskar.emitraa.services.FarmerRegistrationService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RegistrationController {

    @Autowired
    private FarmerRegistrationService farmerRegistrationService;

    @GetMapping("/register")
    public ModelAndView getRegistration(Model model){
        model.addAttribute("user", new Users());

        return new ModelAndView("registration");
    }

    @PostMapping("/register")
    public ModelAndView postRegistration(Users users){

        RedirectView rd = new RedirectView();

        if( farmerRegistrationService.create(users)) {

            rd.setUrl("/register/success");
            return new ModelAndView(rd);

        }

        rd.setUrl("/register/failed");

        return new ModelAndView(rd);
    }

    @GetMapping("/register/success")
    public ModelAndView getRegistrationSuccess(){
        return new ModelAndView("RegistrationSuccess");
    }

    @GetMapping("/register/failed")
    public ModelAndView getRegistrationfailed(){
        return new ModelAndView("RegistrationFailed");
    }



}
