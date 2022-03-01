/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.HashMap;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Moudhaffer
 */
public class Session {
    private SimpleIntegerProperty sessionId;
    private Time startTime;
    private LocalDate date;
    private SimpleStringProperty coachAttendee;
    private SimpleStringProperty playerAttendee;
   

    public Session(int sessionId, Time startTime,LocalDate date, String coachAttendee, String playerAttendee) {
        this.sessionId = new SimpleIntegerProperty(sessionId);
        this.startTime = startTime;
        this.date = date;
        this.coachAttendee = new SimpleStringProperty(coachAttendee);
        this.playerAttendee = new SimpleStringProperty(playerAttendee);
    }
    
    public Session() {
        
    }

    public int getSessionId() {
        return sessionId.get();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSessionId(SimpleIntegerProperty sessionId) {
        this.sessionId = sessionId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.sessionId);
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
        return "Session{" + "sessionId=" + sessionId + ", startTime=" + startTime + ", date=" + date + ", coachAttendee=" + coachAttendee + ", playerAttendee=" + playerAttendee + '}';
    }

  

    public String getCoachAttendee() {
        return coachAttendee.get();
    }

    public void setCoachAttendee(SimpleStringProperty coachAttendee) {
        this.coachAttendee = coachAttendee;
    }

    public String getPlayerAttendee() {
        return playerAttendee.get();
    }

    public void setPlayerAttendee(SimpleStringProperty playerAttendee) {
        this.playerAttendee = playerAttendee;
    }
    
}
