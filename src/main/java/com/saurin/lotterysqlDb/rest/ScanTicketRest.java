/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.rest;

import com.saurin.lotterysqlDb.entity.ScanTicket;
import com.saurin.lotterysqlDb.entity.Shift;
import com.saurin.lotterysqlDb.repository.services.ScanTicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saurin
 */
@RestController
@RequestMapping("/api/scanticket")
public class ScanTicketRest {
    
    @Autowired
    public ScanTicketService scanTicketService;
    
    @RequestMapping(method = RequestMethod.POST, value="/openingticket")
    public ScanTicket save(@RequestBody ScanTicket scanTicket){
        return scanTicketService.save(scanTicket);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/getall")
    public List<ScanTicket> getAllScannedTickets(){
        return (List<ScanTicket>) scanTicketService.getAllScannedTickets();
    }
    
    // Need to provide Book number and the closing ticket number
    @RequestMapping(method=RequestMethod.PUT, value="/closingticket")
    public ScanTicket update(@RequestBody ScanTicket scanTicket){
        System.out.println("====>>>>Printing out the Closing ticket number: " + scanTicket.getClosingTicketNumber());
        System.out.println("To String of update ScanTicket: " + scanTicket.toString());
        return scanTicketService.updateScanTicket(scanTicket);
    }
    
//    //use it for closing shift scan.
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody ScanTicket scanTicket){
//        Shift shift = shiftRepo.findByIsOpen();
//        scanTicketRepo.updateScanTicket(scanTicket.getClosingTicketNumber(), 
//                shift.getId(), scanTicket.getBook().getBookNumber());
//    }
}
