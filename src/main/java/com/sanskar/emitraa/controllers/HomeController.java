package com.sanskar.emitraa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/home/CropBooking")
    public ModelAndView homeCropBooking() {
        return new ModelAndView("CropBooking");
    }

    @GetMapping("/home/MilkMarket")
    public ModelAndView homeMilkMarket() {
        return new ModelAndView("MilkMarket");
    }

    @GetMapping("/home/AgricultureSchemes")
    public ModelAndView homeAgricultureSchemes() {
        return new ModelAndView("AgricultureSchemes");
    }

    @GetMapping("/home/AnimalHusbandry")
    public ModelAndView homeAnimalHusbandry() {
        return new ModelAndView("AnimalHusbandry");
    }


}
