/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.rest;

import com.saurin.lotterysqlDb.entity.Book;
import com.saurin.lotterysqlDb.repository.services.BookService;
import jersey.repackaged.com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saurin
 */
@RestController
@RequestMapping("/api/book")
public class BookRest {
    
    @Autowired
    public BookService bookService;
    
    @RequestMapping(method = RequestMethod.POST)
    public Book save(@RequestBody Book book){
        Preconditions.checkNotNull(book);
        return bookService.save(book);
    }
}
