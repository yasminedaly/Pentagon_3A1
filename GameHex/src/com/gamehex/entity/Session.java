/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.entity;

import com.gamehex.utils.Attendees;
import java.sql.Time;
import java.util.LinkedList;
import javafx.beans.property.SimpleIntegerProperty;
import java.time.Duration;
import java.util.Objects;
import java.util.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class Session {

    private SimpleIntegerProperty sessionId;
    private Time sessionTime; //Needs to be changed
    private SimpleListProperty<Attendees> sessionAttendees;
    private Duration session;
    private SimpleIntegerProperty sessionRating;

    public Session(SimpleIntegerProperty sessionId, Time sessionTime, SimpleListProperty<Attendees> sessionAttendees, Duration session, SimpleIntegerProperty sessionRating) {
        this.sessionId = sessionId;
        this.sessionTime = sessionTime;
        this.sessionAttendees = sessionAttendees;
        this.session = session;
        this.sessionRating = sessionRating;
    }

    public Session() {

    }

    public Session(Time sessionTime, SimpleListProperty<Attendees> sessionAttendees, Duration session, SimpleIntegerProperty sessionRating) {
        this.sessionTime = sessionTime;
        this.sessionAttendees = sessionAttendees;
        this.session = session;
        this.sessionRating = sessionRating;
    }

    public SimpleIntegerProperty getSessionId() {
        return sessionId;
    }

    public void setSessionId(SimpleIntegerProperty sessionId) {
        this.sessionId = sessionId;
    }

    public Time getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Time sessionTime) {
        this.sessionTime = sessionTime;
    }

    public ObservableList<Attendees> getSessionAttendees() {
        return sessionAttendees;
    }

    public void setSessionAttendees(SimpleListProperty<Attendees> sessionAttendees) {
        this.sessionAttendees = sessionAttendees;
    }

    public Duration getSession() {
        return session;
    }

    public void setSession(Duration session) {
        this.session = session;
    }

    public SimpleIntegerProperty getSessionRating() {
        return sessionRating;
    }

    public void setSessionRating(SimpleIntegerProperty sessionRating) {
        this.sessionRating = sessionRating;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.sessionId);
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
        final Session other = (Session) obj;
        if (!Objects.equals(this.sessionId, other.sessionId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Session{" + "sessionId=" + sessionId
                + ", sessionTime=" + sessionTime + ", sessionAttendees="
                + sessionAttendees + ", session=" + session
                + ", sessionRating=" + sessionRating + '}';
    }

}
