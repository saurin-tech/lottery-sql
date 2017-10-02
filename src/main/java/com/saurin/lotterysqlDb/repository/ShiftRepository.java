/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.repository;

import com.saurin.lotterysqlDb.entity.ScanTicket;
import com.saurin.lotterysqlDb.entity.Shift;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saurin
 */
@Repository
public interface ShiftRepository extends CrudRepository<Shift, Long>{
    
    Shift findByActiveTrue();
    
    //@Modifying
    @Query("from ScanTicket s where s.shift.active = true and s.closingTicketNumber = null")
    List<ScanTicket> completelySoldOffTickets();
    
    //@Modifying
    @Query("from ScanTicket s where s.shift.active = true")
    List<ScanTicket> currentShiftEntireScanTicketList();
    
    //@Modifying
    @Query("select sum(numberOfTicketsSold) from ScanTicket s where s.shift.active = true")
    int sumOfTicketsSold();
    
    //@Modifying
    @Query("select sum(valueOfTicketsSold) from ScanTicket s where s.shift.active = true")
    int sumValueOfTicketsSold();
}
