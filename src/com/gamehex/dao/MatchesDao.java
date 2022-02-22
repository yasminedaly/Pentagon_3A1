/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.gamehex.entity.Matches;
import com.gamehex.utils.ConnexionSingleton;


/**
 *
 * @author Yasmine Daly
 */
public class MatchesDao implements Idao<Matches>{
    
    private static MatchesDao instance;
    private Statement st;
    private ResultSet rs;
    
    private MatchesDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MatchesDao getInstance(){
        if(instance==null) 
            instance=new MatchesDao();
        return instance;
    }

    /**
     *
     * @param m
     */
    @Override
    public void insertMatch(Matches m) {
        String req="insert into macthes (matchid,team1,team2,matchres,matchcom) values ('"+m.getMatchId()+"','"+m.getTeam1()+"','"+m.getTeam2()+"','"+m.getMatchRes()+"','"+m.getMatchCom()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void deleteMatch(Matches m) {
        String req="delete from matches where matchid="+m.getMatchId();
        Matches p=displayById(m.getMatchId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("Match not found");
    }

    public ObservableList<Matches> displayAll() {
        String req="select * from matches";
        ObservableList<Matches> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Matches p=new Matches();
                p.setMatchId(rs.getInt(1));
                p.setTeam1(rs.getInt(2));
                p.setTeam2(rs.getInt(3));
                p.setMatchRes(rs.getInt(4));
                p.setMatchCom(rs.getString(5));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Matches> displayAllList() {
        String req="select * from matches";
        List<Matches> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Matches p=new Matches();
                p.setMatchId(rs.getInt(1));
                p.setTeam1(rs.getInt(2));
                p.setTeam2(rs.getInt(3));
                p.setMatchRes(rs.getInt(4));
                p.setMatchCom(rs.getString(5));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Matches displayById(int id) {
           String req="select * from matches where id ="+id;
           Matches p=new Matches();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setMatchId(rs.getInt("id"));
                p.setTeam1(rs.getInt("team1"));
                p.setTeam2(rs.getInt("team2"));
                p.setMatchRes(rs.getInt("match result"));
                p.setMatchCom(rs.getString("match comment"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    public boolean update(Matches m) {
        String qry = "UPDATE personne SET Id = '"+m.getMatchId()+"', Team1 = '"+m.getTeam1()+"', Team2 = '"+m.getTeam2()+"', Result = '"+m.getMatchRes()+"', Comment = '"+m.getMatchCom()+"' WHERE id = "+m.getMatchId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Matches> displayAllMatches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matches displayByMatchId(int matchid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateMath(Matches os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMatches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
    
}
