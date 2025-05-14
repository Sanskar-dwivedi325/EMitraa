package com.sanskar.emitraa.controllers;


import com.sanskar.emitraa.model.Users;
import com.sanskar.emitraa.services.FarmerRegistrationService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

    @Autowired
    private FarmerRegistrationService farmerRegistrationService;

    @GetMapping("/register")
    public ModelAndView getRegistration(Model model){
        model.addAttribute("user", new Users());

        return new ModelAndView("registration");
    }

    @PostMapping("/register")
    public String postRegistration(Users users, RedirectAttributes redirectAttributes){



        if( farmerRegistrationService.create(users)) {

            redirectAttributes.addFlashAttribute("message", "Registration Successful");
           return "redirect:/register";
        }

       redirectAttributes.addFlashAttribute("message", "Already registered");
        return "redirect:/register";
    }

//    @GetMapping("/register/success")
//    public ModelAndView getRegistrationSuccess(){
//        return new ModelAndView("RegistrationSuccess");
//    }
//
//    @GetMapping("/register/failed")
//    public ModelAndView getRegistrationfailed(){
//        return new ModelAndView("RegistrationFailed");
//    }



}
