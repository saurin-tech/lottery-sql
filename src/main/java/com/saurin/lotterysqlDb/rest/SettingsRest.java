/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.rest;

import com.saurin.lotterysqlDb.entity.Settings;
import com.saurin.lotterysqlDb.repository.services.SettingsService;
import com.saurin.lotterysqlDb.rest.error.SettingsNotFoundException;
import jersey.repackaged.com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saurin
 */
@RestController
@RequestMapping("/api/settings")
public class SettingsRest {
    
    @Autowired
    public SettingsService settingsService;
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Settings save(@RequestBody Settings settings){
        Preconditions.checkNotNull(settings);
        return settingsService.save(settings);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Settings getSettingsByStoreName(@RequestBody Settings settings){
        return settingsService.findByStoreName(settings.getStoreName());
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET )
    public Settings getSettingsById(@PathVariable("id") int id){
        Settings settings = settingsService.findById(id);
        if(settings == null){ throw new SettingsNotFoundException(id);}
        return settings;
    }
    
    @ExceptionHandler(SettingsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error settingsNotFound(SettingsNotFoundException e){
        Integer settingsId = e.getSettingsId();
        return new Error ("Settings [" + settingsId + "] not found!");
    }
    
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody Settings settings){
//        settingsRepo.updateSettings(settings.getNumberOfDigitsInBookNumber(), 
//                settings.getNumberOfDigitsInGameNumber(), settings.getStoreName());
//    }
}
