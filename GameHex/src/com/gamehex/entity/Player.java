/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.entity;

import javafx.beans.property.SimpleListProperty;

/**
 *
 * @author Moudhaffer
 */
public class Player {
    private SimpleListProperty sessionsList;

    public Player(SimpleListProperty sessionsList) {
        this.sessionsList = sessionsList;
    }
    
    public Player(){
        
    }

    public SimpleListProperty getSessionsList() {
        return sessionsList;
    }

    public void setSessionsList(SimpleListProperty sessionsList) {
        this.sessionsList = sessionsList;
    }

    @Override
    public String toString() {
        return super.toString() + "Player{" + "sessionsList=" + sessionsList + '}';
    }
    
}
