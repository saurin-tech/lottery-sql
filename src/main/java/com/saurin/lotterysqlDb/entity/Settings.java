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
public class Settings {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String storeName;
    
    private int numberOfDigitsInGameNumber;
    
    private int numberOfDigitsInBookNumber;
    
    private boolean ascendingOrder;
    
    private String email;
    
    public Settings(){}

    public Settings(String storeName, int numberOfDigitsInGameNumber, 
            int numberOfDigitsInBookNumber, boolean ascendingOrder, String email) {
        this.storeName = storeName;
        this.numberOfDigitsInGameNumber = numberOfDigitsInGameNumber;
        this.numberOfDigitsInBookNumber = numberOfDigitsInBookNumber;
        this.ascendingOrder = ascendingOrder;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    public int getNumberOfDigitsInGameNumber() {
        return numberOfDigitsInGameNumber;
    }

    public void setNumberOfDigitsInGameNumber(int numberOfDigitsInGameNumber) {
        this.numberOfDigitsInGameNumber = numberOfDigitsInGameNumber;
    }

    public int getNumberOfDigitsInBookNumber() {
        return numberOfDigitsInBookNumber;
    }

    public void setNumberOfDigitsInBookNumber(int numberOfDigitsInBookNumber) {
        this.numberOfDigitsInBookNumber = numberOfDigitsInBookNumber;
    }

    public boolean isAscendingOrder() {
        return ascendingOrder;
    }

    public void setAscendingOrder(boolean ascendingOrder) {
        this.ascendingOrder = ascendingOrder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
