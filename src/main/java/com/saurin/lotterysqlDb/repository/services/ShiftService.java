/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.repository.services;

import com.saurin.lotterysqlDb.entity.ScanTicket;
import com.saurin.lotterysqlDb.entity.Shift;
import com.saurin.lotterysqlDb.repository.ShiftRepository;
import com.saurin.lotterysqlDb.services.EmailNotificationService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author saurin
 */
@Service
public class ShiftService {
    
    public Shift shift;
    public ShiftRepository shiftRepo;
    public SettingsService settingsService;
    public ScanTicketService scanTicketService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public EmailNotificationService emailNotificationService;
    
    @Autowired
    public ShiftService(ShiftRepository shiftRepo, SettingsService settingsService){
        this.shiftRepo = shiftRepo;
        this.settingsService = settingsService;
    }
    
    @Autowired
    public void setScanTicketService(ScanTicketService scanTicketService){
        this.scanTicketService = scanTicketService;
    }
    
    public Shift findByActiveTrue(){
        return shiftRepo.findByActiveTrue();
    }

    public Shift save(Shift shift) {
        return shiftRepo.save(shift);
    }
    
    public Shift openShift(){
        if(findByActiveTrue() == null){
            shift = new Shift();
            shift.setActive(true);
            shiftRepo.save(shift);
            return shift;
        }else{
            logger.warn("Shift is already open!");
            return shift;
        }
    }
    
    public Shift closeShift(){
        boolean ascendingOrder = settingsService.isAscendingOrder();
        if(findByActiveTrue() == null){
            logger.warn("Open a shift first!");
            return null;
        }else{  // When the shift is open this ELSE clause takes place
            List<ScanTicket> completelySoldOffTickets = shiftRepo.completelySoldOffTickets();
            if(!completelySoldOffTickets.isEmpty()){
                logger.info("Working on completely sold off tickets!");
                assigningClosingTicketNumbersToCompletelySoldTickets(ascendingOrder,
                        completelySoldOffTickets);
            }
            
            setTicketNumberAndValue(ascendingOrder);
            
            int sumOfTicketsSold = shiftRepo.sumOfTicketsSold();
            logger.info("Sum of Tickets Sold: " + sumOfTicketsSold);
            int sumValueOfTicketsSold = shiftRepo.sumValueOfTicketsSold();
            logger.info("Sum value of tickets sold: " + sumValueOfTicketsSold);
            shift = findByActiveTrue();
            shift.setTotalNumberOfTicketsSold(sumOfTicketsSold);
            shift.setTotalValueOfTicketsSold(sumValueOfTicketsSold);
            shift.setActive(false);
            save(shift);
            //emailNotificationService.sendShiftCloseEmail(shift);
            return shift;
        }
    }
    
    public void assigningClosingTicketNumbersToCompletelySoldTickets(boolean ascendingOrder,
            List<ScanTicket> completelySoldOffTickets){
        
        for(ScanTicket scanTicket : completelySoldOffTickets){
            if(ascendingOrder){
                scanTicket.setClosingTicketNumber(scanTicket.getBook().getMaxNumber()+1);
            }else{
                scanTicket.setClosingTicketNumber(-1);
            }
            scanTicketService.saveMultipleScanTickets(completelySoldOffTickets);
        }
    }
    
    public void setTicketNumberAndValue(boolean ascendingOrder){
        List<ScanTicket> currentShiftEntireScanTicketList =
                    shiftRepo.currentShiftEntireScanTicketList();

        for(ScanTicket scanTicket: currentShiftEntireScanTicketList){
            int price = scanTicket.getBook().getPrice();
            if(ascendingOrder){
                int ticketsSold = scanTicket.getClosingTicketNumber() 
                        - scanTicket.getOpeningTicketNumber();
                scanTicket.setNumberOfTicketsSold(ticketsSold);
                int valueOfTicketsSold = price * ticketsSold;
                scanTicket.setValueOfTicketsSold(valueOfTicketsSold);
            }else{
                int ticketsSold = scanTicket.getOpeningTicketNumber()
                        - (scanTicket.getClosingTicketNumber());
                scanTicket.setNumberOfTicketsSold(ticketsSold);
                int valueOfTicketsSold = price * ticketsSold;
                scanTicket.setValueOfTicketsSold(valueOfTicketsSold);
            }
            scanTicketService.saveMultipleScanTickets(currentShiftEntireScanTicketList);
        }
    }
}
