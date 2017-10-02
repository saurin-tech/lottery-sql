/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.services;

import com.saurin.lotterysqlDb.entity.ScanTicket;
import com.saurin.lotterysqlDb.entity.Shift;
import com.saurin.lotterysqlDb.repository.services.SettingsService;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author saurin
 */
@Service
public class EmailNotificationService {
    
    private JavaMailSender javaMailSender;
    
    @Autowired
    private SettingsService settingsService;
    
    @Autowired
    public EmailNotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    
    //MimeMessages for sophiticated messages instead of simple mail message
    public void sendShiftCloseEmail(Shift shift){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(settingsService.findById(1).getEmail());
        mail.setFrom("<SENDERS EMAIL ADDRESS>");
        mail.setSubject("Shift Closed Today at " + LocalDate.now() + " " + LocalTime.now());
        mail.setText("Shift has been closed! "
                + "Your shift total amount is: " + shift.getTotalValueOfTicketsSold());
        
        javaMailSender.send(mail);
    }
}
