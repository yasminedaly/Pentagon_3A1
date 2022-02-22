/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.dao;

import java.util.List;


public interface Idao<T> {
    public void insertMatch(T o);
    public void deleteMatch(T o);
    public List<T> displayAllMatches();
    public T displayByMatchId(int matchid);
    
    public boolean updateMath(T os);
    public void showMatches();
    
}
