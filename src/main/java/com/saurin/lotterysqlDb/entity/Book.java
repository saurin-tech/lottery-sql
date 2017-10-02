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
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String bookName;
    
    private int gameNumber;

    private int bookNumber;
    
    private int price;
    
    private int maxNumber;
    
    private String wholeNumber;
    
    public Book(){}
    
    public Book(String bookName, int gameNumber, int bookNumber, int price, int maxNumber){
        this.bookName = bookName;
        this.gameNumber = gameNumber;
        this.bookNumber = bookNumber;
        this.price = price;
        this.maxNumber = maxNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getWholeNumber() {
        return wholeNumber;
    }

    public void setWholeNumber(String wholeNumber) {
        this.wholeNumber = wholeNumber;
    }
    
    
}
