/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.repository.services;

import com.saurin.lotterysqlDb.entity.Book;
import com.saurin.lotterysqlDb.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author saurin
 */
@Service
public class BookService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public BookRepository bookRepo;
    
    @Autowired
    public BookService(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    public Book save(Book book) {
        if(hasBookBeenEntered(book.getBookNumber())){
            //bookRepo.save(book);
            logger.warn("Book has been already entered! " + book.getBookName());
            return null;
        }else{
            return bookRepo.save(book);
        }
    }
    
    public Book findBookByBookNumber(int bookNumber){
        return bookRepo.findBookByBookNumber(bookNumber);
    }
    
    public boolean hasBookBeenEntered(int bookNumber){
        boolean flag = false;
        if(bookRepo.findBookByBookNumber(bookNumber)!= null){
            flag = true;
        }
        return flag;
    }
    
}
