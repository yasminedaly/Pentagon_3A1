/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleListProperty;

/**
 *
 * @author Yasmine Daly
 */
public class Teams {
    private SimpleIntegerProperty teamid;
    private SimpleStringProperty teamlogo;
    private SimpleStringProperty teamname;
    private SimpleStringProperty teamcountry;
    private SimpleStringProperty teamcoach;
    private SimpleStringProperty teamcap;
    private SimpleListProperty <ProPlayers> players;

    public Teams(SimpleIntegerProperty teamid, SimpleStringProperty teamlogo, SimpleStringProperty teamname, SimpleStringProperty teamcountry, SimpleStringProperty teamcoach, SimpleStringProperty teamcap, SimpleListProperty<ProPlayers> players) {
        this.teamid = teamid;
        this.teamlogo = teamlogo;
        this.teamname = teamname;
        this.teamcountry = teamcountry;
        this.teamcoach = teamcoach;
        this.teamcap = teamcap;
        this.players = players;
    }

    public SimpleIntegerProperty getTeamid() {
        return teamid;
    }

    public SimpleStringProperty getTeamlogo() {
        return teamlogo;
    }

    public SimpleStringProperty getTeamname() {
        return teamname;
    }

    public SimpleStringProperty getTeamcountry() {
        return teamcountry;
    }

    public SimpleStringProperty getTeamcoach() {
        return teamcoach;
    }

    public SimpleStringProperty getTeamcap() {
        return teamcap;
    }

    public SimpleListProperty<ProPlayers> getPlayers() {
        return players;
    }

    public void setTeamid(SimpleIntegerProperty teamid) {
        this.teamid = teamid;
    }

    public void setTeamlogo(SimpleStringProperty teamlogo) {
        this.teamlogo = teamlogo;
    }

    public void setTeamname(SimpleStringProperty teamname) {
        this.teamname = teamname;
    }

    public void setTeamcountry(SimpleStringProperty teamcountry) {
        this.teamcountry = teamcountry;
    }

    public void setTeamcoach(SimpleStringProperty teamcoach) {
        this.teamcoach = teamcoach;
    }

    public void setTeamcap(SimpleStringProperty teamcap) {
        this.teamcap = teamcap;
    }

    public void setPlayers(SimpleListProperty<ProPlayers> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Teams{" + "teamid=" + teamid + ", teamlogo=" + teamlogo + ", teamname=" + teamname + ", teamcountry=" + teamcountry + ", teamcoach=" + teamcoach + ", teamcap=" + teamcap + ", players=" + players + '}';
    }
    
    
}
