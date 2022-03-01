/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Moudhaffer
 */
public class Coaches {
    private SimpleIntegerProperty coachId;
    private SimpleStringProperty username;
    private SimpleStringProperty passwd;
    private SimpleStringProperty email;
    private SimpleStringProperty profileInfo;
    private SimpleStringProperty sessionList;
    private SimpleStringProperty type;
    private SimpleFloatProperty rating;    
    
    public Coaches(){
        
    }

    public Coaches(int id, String username, String passwd, String email, String profileInfo, String sessionList, String type, float rating) {
        this.coachId = new SimpleIntegerProperty(id);
        this.username = new SimpleStringProperty(username);
        this.passwd = new SimpleStringProperty(passwd);
        this.email = new SimpleStringProperty(email);
        this.profileInfo = new SimpleStringProperty(profileInfo);
        this.sessionList = new SimpleStringProperty(sessionList);
        this.type = new SimpleStringProperty(type);
        this.rating = new SimpleFloatProperty(rating);
    }

    public int getId() {
        return coachId.get();
    }

    public void setId(int id) {
        this.coachId = new SimpleIntegerProperty(id);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String title) {
        this.username = new SimpleStringProperty(title);
    }

    public String getPasswd() {
        return passwd.get();
    }

    public void setPasswd(String passwd) {
        this.passwd = new SimpleStringProperty(passwd);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public String getType() {
        return type.get();
    }

    public void setType(SimpleStringProperty type) {
        this.type = type;
    }

    public String getProfileInfo() {
        return profileInfo.get();
    }

    public void setSessionList(String sessionList) {
        this.profileInfo = new SimpleStringProperty(sessionList);
    }
    
    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }
    
    public void setRating(float rating) {
        this.rating = new SimpleFloatProperty(rating);
    }

    public SimpleFloatProperty getRating() {
        return rating;
    }

    public SimpleStringProperty getSessionList() {
        return sessionList;
    }

    public void setSessionList(SimpleStringProperty sessionList) {
        this.sessionList = sessionList;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.coachId);
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
        final Coaches other = (Coaches) obj;
        return Objects.equals(this.coachId, other.coachId);
    }

    @Override
    public String toString() {
        return "Coaches{" + "coachId=" + coachId + ", username=" + username + ", passwd=" + passwd + ", email=" + email + ", profileInfo=" + profileInfo + ", sessionList=" + sessionList + ", type=" + type + ", rating=" + rating + '}';
    }



    public Coaches(SimpleStringProperty username, SimpleStringProperty passwd, SimpleStringProperty email, SimpleStringProperty profileInfo, SimpleStringProperty sessionList, SimpleStringProperty type, SimpleFloatProperty rating) {
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.profileInfo = profileInfo;
        this.sessionList = sessionList;
        this.type = type;
        this.rating = rating;
    }
    
    
}
