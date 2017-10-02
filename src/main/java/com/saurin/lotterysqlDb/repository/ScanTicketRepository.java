/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.repository;

import com.saurin.lotterysqlDb.entity.ScanTicket;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author saurin
 */
@Repository
public interface ScanTicketRepository extends CrudRepository<ScanTicket, Long>{
    
    @Query("from ScanTicket s where s.bookNumber = ?1 and shift.id in (select id "
            + "from Shift where active = true)")
    ScanTicket checkTheCurrentShiftScanForThisBook (int bookNumber);
   
    @Modifying
    @Transactional
    @Query("update ScanTicket set closingTicketNumber = ?1 "
            + " where bookNumber = ?2 and shift.id in (select id from Shift"
            + " where active = true)" )
    int updateScanTicket (int closingTicketNumber, int bookNumber);
    
}
