package com.sanskar.emitraa.controllers;

import com.sanskar.emitraa.model.SlotDetails;
import com.sanskar.emitraa.services.FarmerSlotBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @Autowired
    private FarmerSlotBookingService farmerSlotBookingService;

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/home/CropBooking")
    public ModelAndView homeCropBooking() {
        return new ModelAndView("CropBooking");
    }

    @PostMapping("/home/CropBooking/BookSlot")
    public String homeCropBookingBookSlot(SlotDetails slotDetails, RedirectAttributes redirectAttributes) {



       if( farmerSlotBookingService.saveFarmerSlotBooking(slotDetails)){
          redirectAttributes.addFlashAttribute("message", "Farmer Slot Booking Successfully Saved");
           return "redirect:/home/CropBooking";
       }

       redirectAttributes.addFlashAttribute("message", "Slot is already booked");
       return "redirect:/home/CropBooking";
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
