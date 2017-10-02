/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.repository.services;

import com.saurin.lotterysqlDb.entity.ScanTicket;
import com.saurin.lotterysqlDb.repository.BookRepository;
import com.saurin.lotterysqlDb.repository.ScanTicketRepository;
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
public class ScanTicketService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public ScanTicketRepository scanTicketRepo;
    public BookRepository bookRepo;
    public BookService bookService;
    public ShiftService shiftService;
    
    @Autowired
    public ScanTicketService(ScanTicketRepository scanTicketRepo, BookRepository bookRepo,
            BookService bookService, ShiftService shiftService){
        this.scanTicketRepo = scanTicketRepo;
        this.bookRepo = bookRepo;
        this.bookService = bookService;
        this.shiftService = shiftService;
    }
    
    public ScanTicket save(ScanTicket scanTicket){
        if(scanTicketRepo.checkTheCurrentShiftScanForThisBook(scanTicket.getBookNumber()) == null){
            if(bookService.hasBookBeenEntered(scanTicket.getBookNumber())){
                scanTicket.setBook(bookRepo.findBookByBookNumber(scanTicket.getBookNumber()));
                scanTicket.setShift(shiftService.findByActiveTrue());
                return scanTicketRepo.save(scanTicket); 
            } else{
                logger.warn("The ticket that you scanned has no book record in the book table!");
                return null;
            }
        } else{
            logger.warn("Ticket has been scanned previously!");
            return null;
        }
    }
    
    public Iterable<ScanTicket> getAllScannedTickets(){
        return scanTicketRepo.findAll();
    }
    
    public ScanTicket updateScanTicket(ScanTicket scanTicket){
//        System.out.println("printing modifying query: " + 
//                scanTicketRepo.updateScanTicket(scanTicket.getClosingTicketNumber(), scanTicket.getBookNumber()));
        if(scanTicketRepo.updateScanTicket(scanTicket.getClosingTicketNumber(), scanTicket.getBookNumber()) == 1){
            System.out.println("ScanTicket has been updated!");
            return scanTicket;
        } else{
            System.out.println("ScanTicket failed to update!");
            return null;
        }
    }
    
    public void saveMultipleScanTickets(List<ScanTicket> listOfScanTickets){
        scanTicketRepo.save(listOfScanTickets);
    }
}
