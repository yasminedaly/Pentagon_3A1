/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexgame.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dr.Green
 */
public class DbConnection {

    private final String url = "jdbc:mysql://127.0.0.1/hexgame";
    private final String username = "root";
    private final String password = "";

    private Connection cnx;
    public static DbConnection instance;


    private DbConnection() {
        try {
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println("err de Connexion ");
            System.out.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

}
