/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.rest;

import com.saurin.lotterysqlDb.entity.Settings;
import com.saurin.lotterysqlDb.repository.services.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Settings save(@RequestBody Settings settings){
        return settingsService.save(settings);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Settings getSettingsByStoreName(@RequestBody Settings settings){
        return settingsService.findByStoreName(settings.getStoreName());
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET )
    public Settings getSettingsById(@PathVariable("id") int id){
        return settingsService.findById(id);
    }
    
//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody Settings settings){
//        settingsRepo.updateSettings(settings.getNumberOfDigitsInBookNumber(), 
//                settings.getNumberOfDigitsInGameNumber(), settings.getStoreName());
//    }
}
