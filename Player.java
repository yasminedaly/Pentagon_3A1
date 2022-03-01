/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;

/**
 *
 * @author Moudhaffer
 */
public class Player extends User{
        private LinkedList<Session> sessionsList;
        private String rank;

    public Player() {
    }

    public Player(LinkedList<Session> sessionsList, String rank, int userid, String username, String passwd, String email, String profileInfo, String type) {
        super(userid, username, passwd, email, profileInfo, type);
        this.sessionsList = sessionsList;
        this.rank = rank;
    }

    public Player(LinkedList<Session> sessionsList, String rank, String username, String passwd, String email, String profileInfo, String type) {
        super(username, passwd,  email, profileInfo, type);
        this.sessionsList = sessionsList;
        this.rank = rank;
    }

    public LinkedList<Session> getSessionsList() {
        return sessionsList;
    }

    public void setSessionsList(LinkedList<Session> sessionsList) {
        this.sessionsList = sessionsList;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return super.toString() + "Player{" + "sessionsList=" + sessionsList + ", rank=" + rank + '}';
    }


        
        
}
