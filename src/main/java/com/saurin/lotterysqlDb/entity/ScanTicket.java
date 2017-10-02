/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author saurin
 */
@Entity
//@JsonIgnoreProperties
public class ScanTicket {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private int bookNumber;
    
    private int openingTicketNumber;
    
    //@Column(nullable = true)
    //@JsonIgnore
    private Integer closingTicketNumber;
    
    @Column(nullable = true)
    private int numberOfTicketsSold;
    
    @Column(nullable = true)
    private int valueOfTicketsSold;
    
    @ManyToOne
    @JoinColumn(name="shiftId")
    private Shift shift;
    
    @ManyToOne
    @JoinColumn(name="bookId")
    private Book book;

    public ScanTicket(){}

    public ScanTicket(int bookNumber, int openingTicketNumber, Integer closingTicketNumber) {
        this.bookNumber = bookNumber;
        this.openingTicketNumber = openingTicketNumber;
        this.closingTicketNumber = closingTicketNumber;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getOpeningTicketNumber() {
        return openingTicketNumber;
    }

    public void setOpeningTicketNumber(int openingTicketNumber) {
        this.openingTicketNumber = openingTicketNumber;
    }

    public Integer getClosingTicketNumber() {
        return closingTicketNumber;
    }

    public void setClosingTicketNumber(Integer closingTicketNumber) {
        this.closingTicketNumber = closingTicketNumber;
    }

    public int getNumberOfTicketsSold() {
        return numberOfTicketsSold;
    }

    public void setNumberOfTicketsSold(int numberOfTicketsSold) {
        this.numberOfTicketsSold = numberOfTicketsSold;
    }

    public int getValueOfTicketsSold() {
        return valueOfTicketsSold;
    }

    public void setValueOfTicketsSold(int valueOfTicketsSold) {
        this.valueOfTicketsSold = valueOfTicketsSold;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "ScanTicket{" + "id=" + id + ", bookNumber=" + bookNumber + ", openingTicketNumber=" + openingTicketNumber + ", closingTicketNumber=" + closingTicketNumber + ", numberOfTicketsSold=" + numberOfTicketsSold + ", valueOfTicketsSold=" + valueOfTicketsSold + ", shift=" + shift + ", book=" + book + '}';
    }
    
    
    
}
