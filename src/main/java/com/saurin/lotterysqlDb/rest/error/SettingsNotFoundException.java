/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurin.lotterysqlDb.rest.error;

/**
 *
 * @author saurin
 */
public class SettingsNotFoundException extends RuntimeException{
    private Integer settingsId;
    
    public SettingsNotFoundException(Integer id){
        this.settingsId = id; 
    }
    
    public Integer getSettingsId(){
        return settingsId;
    }
}
