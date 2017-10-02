/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.repository.services;

import com.saurin.lotterysqlDb.entity.Settings;
import com.saurin.lotterysqlDb.repository.SettingsRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author saurin
 */
@Service
public class SettingsService {
    public SettingsRepository settingsRepo;
    
    public SettingsService(SettingsRepository settingsRepo){
        this.settingsRepo = settingsRepo;
    }
    
    public Settings findByStoreName(String storeName){
        return settingsRepo.findByStoreName(storeName);
    }
    
    public Settings findById(int id){
        return settingsRepo.findOne(id);
    }
    
    public Settings save(Settings settings){
        return settingsRepo.save(settings);
    }
    
    public boolean isAscendingOrder(){
        return settingsRepo.findOne(1).isAscendingOrder();
    }
}
