/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexgame.dao;

import java.util.List;

/**
 *
 * @author Dr.Green
 */
public interface Dao<t> {
    //FUNCTIONS NEEDED
    
     public void Add(t p);
     public void Update(t p);
     void Delete(t p);
     public List<t> ViewAll();
     public t displayById(t p);

    
    
}
