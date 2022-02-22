/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;

/**
 *
 * @author Moudhaffer
 */
public class Coach extends User{
    private SimpleListProperty sessionsList;
    private SimpleIntegerProperty rating;

    //ID constructor
    public Coach(SimpleListProperty sessionsList, SimpleIntegerProperty rating, int userid, String username, String email, String profileInfo, String type) {
        super(userid, username, email, profileInfo, type);
        this.sessionsList = sessionsList;
        this.rating = rating;
    }
    //Default constructor
    public Coach() {
    }
    
    //No ID constructor
    public Coach(SimpleListProperty sessionsList, SimpleIntegerProperty rating, String username, String email, String profileInfo, String type) {
        super(username, email, profileInfo, type);
        this.sessionsList = sessionsList;
        this.rating = rating;
    }

    public SimpleListProperty getSessionsList() {
        return sessionsList;
    }

    public void setSessionsList(SimpleListProperty sessionsList) {
        this.sessionsList = sessionsList;
    }

    public SimpleIntegerProperty getRating() {
        return rating;
    }

    public void setRating(SimpleIntegerProperty rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString() + "Coach{" + "sessionsList=" + sessionsList + ", rating=" + rating + '}';
    }
    
}
