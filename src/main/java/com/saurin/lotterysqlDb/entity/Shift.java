/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author saurin
 */
@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private boolean active;
    
    private int totalNumberOfTicketsSold;
    
    private int totalValueOfTicketsSold;
    
    public Shift(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getTotalNumberOfTicketsSold() {
        return totalNumberOfTicketsSold;
    }

    public void setTotalNumberOfTicketsSold(int totalNumberOfTicketsSold) {
        this.totalNumberOfTicketsSold = totalNumberOfTicketsSold;
    }

    public int getTotalValueOfTicketsSold() {
        return totalValueOfTicketsSold;
    }

    public void setTotalValueOfTicketsSold(int totalValueOfTicketsSold) {
        this.totalValueOfTicketsSold = totalValueOfTicketsSold;
    }
    
    
}
