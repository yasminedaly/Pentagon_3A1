/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.entity;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Moudhaffer
 */
public class User {
    private SimpleIntegerProperty userid;
    private SimpleStringProperty username;
    private SimpleStringProperty email;
    private SimpleStringProperty profileInfo;
    private SimpleStringProperty type;
    
    public User(){
        
    }
    
    public User(int userid, String username, String email, String profileInfo, String type){
        this.userid = new SimpleIntegerProperty(userid);
        this.username = new SimpleStringProperty(username);
        this.email = new SimpleStringProperty(email);
        this.profileInfo = new SimpleStringProperty(profileInfo);
        this.type = new SimpleStringProperty(type);
    }
    
        public User(String username, String email, String profileInfo, String type){
        this.username = new SimpleStringProperty(username);
        this.email = new SimpleStringProperty(email);
        this.profileInfo = new SimpleStringProperty(profileInfo);
        this.type = new SimpleStringProperty(type);
    }

    public SimpleIntegerProperty getUserid() {
        return userid;
    }

    public void setUserid(SimpleIntegerProperty userid) {
        this.userid = userid;
    }

    public SimpleStringProperty getUsername() {
        return username;
    }

    public void setUsername(SimpleStringProperty username) {
        this.username = username;
    }

    public SimpleStringProperty getEmail() {
        return email;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

    public SimpleStringProperty getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(SimpleStringProperty profileInfo) {
        this.profileInfo = profileInfo;
    }

    public SimpleStringProperty getType() {
        return type;
    }

    public void setType(SimpleStringProperty type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", username=" + username + ", email=" + email + ", profileInfo=" + profileInfo + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.userid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.userid, other.userid);
    }
    
        
}
