/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.rest;

import com.saurin.lotterysqlDb.entity.Shift;
import com.saurin.lotterysqlDb.repository.services.ShiftService;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saurin
 */
@RestController
@RequestMapping("/api/shift")
public class ShiftRest {
    
    @Autowired
    private ShiftService shiftService;
    
    @RequestMapping("/isopen")
    public Shift findByActiveTrue(){
        if(shiftService.findByActiveTrue() == null){
            Shift shift = new Shift();
            shift.setActive(false);
            return shift;
        }else{
            return shiftService.findByActiveTrue();
        }
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/open")
    public Shift openShift(){
        return shiftService.openShift();
//        if(shiftService.findByActiveTrue() == null){
//            return  Response.ok();
//        } else{
//            return (ResponseEntity<Shift>) ResponseEntity.badRequest();
//        }
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/close")
    public Shift closeShift(){
        
        return shiftService.closeShift();
//        if(shiftService.findByActiveTrue() != null){
//            return (ResponseEntity<Shift>) ResponseEntity.ok();
//        } else{
//            return (ResponseEntity<Shift>) ResponseEntity.badRequest();
//        }
    }
}
