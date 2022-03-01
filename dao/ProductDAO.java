/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexgame.dao;

import hexgame.entity.Product;
import hexgame.utils.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import hexgame.dao.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dr.Green
 */
public class ProductDAO implements Dao<Product> {

    Connection cnx;
    PreparedStatement statement;
    private Statement st;
    private ResultSet rs;

    public ProductDAO() {
        this.cnx = DbConnection.getInstance().getCnx();
    }

    //OVERRIDE FUNCTIONS AND SQL REQUESTS
    /*@Override
    public void ajouter(Reservation var) {
        System.out.println(var.getIdDemande());
    try {
        String req = "insert into reservation(idDemande,idAccompagnateur,idChauffeur,idVehicule,date) values (?,?,?,?,?)";
        statement = cnx.prepareStatement(req);
        statement.setInt(1, var.getIdDemande());
        statement.setInt(2, var.getIdAccompagnateur());
        statement.setInt(3, var.getIdChauffeur());
        statement.setInt(4, var.getIdVehicule());
        statement.setDate(5, (Date) var.getDate());
        statement.executeUpdate();
        System.out.println("Reservation ajoutee");
    } catch (SQLException ex) {
        Logger.getLogger(VehiculeService.class.getName()).log(Level.SEVERE, null, ex);
    }    

     */
    @Override
    public void Add(Product p) {
        String req = "insert into product (ref,name,description,price,review,state,id_supplier) values ('" + p.getRef()+ "','" + p.getName() + "','" + p.getDescription() + "','" + p.getPrice() + "','" + p.getReview() + "','" + p.getState() + "','" + p.getId_supplier() + "')";
        try {
            //st.executeUpdate(req);
            statement = cnx.prepareStatement(req);
            statement.executeUpdate();
            System.out.println("Item added");
        } catch (SQLException ex) {
            System.out.println("not working");
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Update(Product p) {
        String qry = "UPDATE product SET ref = '" + p.getRef()+ "', name = '" + p.getName()+  "', description = '" + p.getDescription() + "',price = '" + p.getPrice() + "',review = '" + p.getReview() + "',state = '" + p.getState() + "',id_supplier = '" + p.getId_supplier() + "' WHERE id_product = " + p.getId_product();

        try {
            statement = cnx.prepareStatement(qry);

            if (statement.executeUpdate(qry) > 0) {
                statement.executeUpdate();
                System.out.println("updated");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("update Failed");

        }
    }

    @Override
    public void Delete(Product p) {
        String req = "delete from product where id_product=" + p.getId_product();
        Product p1 = displayById(p);

        if (p != null) {
            try {
                statement = cnx.prepareStatement(req);
                statement.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("n'existe pas");
        }
    }

    @Override
    public ObservableList<Product> ViewAll() {
        ObservableList<Product> ProductsList = FXCollections.observableArrayList();
        
        
        String req = "select * from product";
        ObservableList<Product> l2 = FXCollections.observableArrayList();

        try {
            statement = cnx.prepareStatement(req);
            rs = statement.executeQuery(req);
            while (rs.next()) {
                Product p = new Product();

                p.setId_product(rs.getInt(1));
                p.setRef(rs.getString("ref"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getInt(5));
                p.setReview(rs.getInt(6));
                p.setState(rs.getString("state"));
                p.setId_supplier(rs.getInt(8));

                l2.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l2;
        
        
    }

    //DONE BUT THE ID NEEDS TO BE DYNAMIC
    @Override
    public Product displayById(Product p) {
        String req = "select * from product where id_product =" + p.getId_product();
        Product p1 = new Product();
        try {
            statement = cnx.prepareStatement(req);
            rs = statement.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p1.setId_product(rs.getInt("id_product"));
            p1.setRef(rs.getString("ref"));
            p1.setName(rs.getString("name"));
            p1.setDescription(rs.getString("description"));
            p1.setPrice(rs.getInt("price"));
            p1.setReview(rs.getInt("review"));
            p1.setState(rs.getString("state"));
            p1.setId_supplier(rs.getInt(8));
            System.out.println(p1);
//}  
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}
