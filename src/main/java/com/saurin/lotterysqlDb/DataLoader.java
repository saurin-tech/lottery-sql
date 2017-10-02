/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb;

import com.saurin.lotterysqlDb.entity.Book;
import com.saurin.lotterysqlDb.entity.ScanTicket;
import com.saurin.lotterysqlDb.entity.Settings;
import com.saurin.lotterysqlDb.entity.Shift;
import com.saurin.lotterysqlDb.repository.services.BookService;
import com.saurin.lotterysqlDb.repository.services.ScanTicketService;
import com.saurin.lotterysqlDb.repository.services.SettingsService;
import com.saurin.lotterysqlDb.repository.services.ShiftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author saurin
 */
@Component
public class DataLoader implements CommandLineRunner{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public BookService bookService;
    @Autowired
    public ShiftService shiftService;
    @Autowired
    public ScanTicketService scanTicketService;
    @Autowired
    public SettingsService settingsService;
    
    public Shift shift;
    public Book book;
    public ScanTicket scanTicket;

    @Override
    public void run(String... strings) throws Exception {
        
        logger.info("Loading sample data in DataLoader....");
        
        //settingsService.save(new Settings("test",3,4,true,"<YOUR EMAIL ADDRESS>"));
        
        bookService.save(new Book("Game1", 101, 1001, 1, 299));
        bookService.save(new Book("Game2", 102, 1002, 2, 299));
        bookService.save(new Book("Game3", 103, 1003, 3, 299));
        //bookService.save(new Book("Game4", 103, 1003, 3, 299));  <-- Uncomment this to check for double entry of books!
        
        shiftService.openShift();
        //shiftService.openShift();  <-- Uncomment this to test blocking multiple shifts at once!
        
        //shift = shiftService.findByActiveTrue();
        
        scanTicketService.save(new ScanTicket(1001, 1, null));
        scanTicketService.save(new ScanTicket(1002, 1, null));
        
        scanTicketService.updateScanTicket(new ScanTicket (1001, 1, 2));
        scanTicketService.updateScanTicket(new ScanTicket (1002, 1, 2));
        
        shiftService.closeShift();
        
        shiftService.openShift();
        
        scanTicketService.save(new ScanTicket(1001, 2, null));
        scanTicketService.save(new ScanTicket(1002, 2, null));
                
        logger.info("Sample Data has been loaded!");
        
        
    }
    
}
