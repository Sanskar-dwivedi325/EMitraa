package com.sanskar.emitraa.services;


import com.sanskar.emitraa.model.SlotDetails;
import com.sanskar.emitraa.repository.SlotDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerSlotBookingService {

    @Autowired
    private SlotDetailsRepo slotDetailsRepo;

    public Boolean saveFarmerSlotBooking(SlotDetails farmerSlotDetails) {
        try {
            slotDetailsRepo.save(farmerSlotDetails);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
