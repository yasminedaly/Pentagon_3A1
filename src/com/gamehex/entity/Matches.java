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
 * @author Yasmine Daly
 */
public class Matches {
    private Integer matchid;
   // private SimpleIntegerProperty matchid;
    private SimpleIntegerProperty team1;
    private SimpleIntegerProperty team2;
    private SimpleIntegerProperty matchres;
    private String matchcom;
    public Matches() {
    }

    
    public Matches(int matchid, int team1,int team2,int matchres, String matchcom) {
        //this.matchid = new SimpleIntegerProperty(matchid);
        this.matchid= matchid;
        this.team1 = new SimpleIntegerProperty(team1);
        this.team2 = new SimpleIntegerProperty(team2);
        this.matchres = new SimpleIntegerProperty(matchres);
        this.matchcom = matchcom;
    }

    
    public int getMatchId() {
        //return matchid.get();
        return matchid;
    }

    public void setMatchId(int matchid) {
        //this.matchid = new SimpleIntegerProperty(matchid);
        this.matchid= matchid;
    }

    public int getTeam1() {
        return team1.get();
    }

    public void setTeam1(int team1) {
        this.team1 = new SimpleIntegerProperty(team1);
    }
     public int getTeam2() {
        return team2.get();
    }

    public void setTeam2(int team2) {
        this.team2 = new SimpleIntegerProperty(team2);
    }

    public int getMatchRes() {
        return matchres.get();
    }
    public void setMatchRes(int matchres) {
        this.matchres = new SimpleIntegerProperty(matchres);
    }
    public String  getMatchCom(){
        return matchcom;
    }
    public void setMatchCom(String matchcom) {
        this.matchcom = matchcom;
    }
   

    /*@Override
    public String toString() {
        return "Matches{" + "id=" + matchid.get() + ", team1=" + team1.get() + ", team2=" + team2.get()+ ", Result=" + matchres.get() + ", Comment=" + matchcom.get()+'}';
    }*/

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.matchid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matches other = (Matches) obj;
        if (!Objects.equals(this.matchid, other.matchid)) {
            return false;
        }
        return true;
    
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
    
    
    
}
