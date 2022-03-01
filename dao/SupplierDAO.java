/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexgame.dao;

import hexgame.entity.Product;
import hexgame.entity.Supplier;
import hexgame.utils.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dr.Green
 */
public class SupplierDAO implements Dao<Supplier> {

    Connection cnx;
    PreparedStatement statement;
    private Statement st;
    private ResultSet rs;

    public SupplierDAO() {
        this.cnx = DbConnection.getInstance().getCnx();
    }

    @Override
    public void Add(Supplier p) {
        String req = "insert into supplier (name,start_date,leave_date,nbr_units_sold) values ('" + p.getName() + "','" + p.getStart_date() + "','" + p.getLeave_date() + "','" + p.getNbr_units_sold() + "')";
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
    public void Update(Supplier p) {
        String qry = "UPDATE supplier SET name = '" + p.getName() + "', start_date = '" + p.getStart_date() + "',leave_date = '" + p.getLeave_date() + "',nbr_units_sold = '" + p.getNbr_units_sold() + "' WHERE id_supplier = " + p.getId_supplier();

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
    public void Delete(Supplier p) {
        String req = "delete from supplier where id_supplier=" + p.getId_supplier();
        //Supplier s1 = displayById(p);

        if (p != null) {
            try {
                statement = cnx.prepareStatement(req);
                statement.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("n'existe pas");
        }
    }

    @Override
    public List ViewAll() {
        String req = "select * from supplier";
        List<Supplier> list = new ArrayList<>();

        try {
            statement = cnx.prepareStatement(req);
            rs = statement.executeQuery(req);
            while (rs.next()) {
                Supplier p = new Supplier();

                p.setId_supplier(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setStart_date(rs.getString("start_date"));
                p.setLeave_date(rs.getString("leave_date"));
                p.setNbr_units_sold(rs.getInt(5));
              

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Supplier displayById(Supplier p) {
        String req = "select * from supplier where id_supplier =" + p.getId_supplier();
        Supplier p1 = new Supplier();
        try {
            statement = cnx.prepareStatement(req);
            rs = statement.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p1.setId_supplier(rs.getInt("id_supplier"));
            p1.setName(rs.getString("name"));
            p1.setStart_date(rs.getString("start_date"));
            p1.setLeave_date(rs.getString("leave_date"));
            p1.setNbr_units_sold(rs.getInt("nbr_units_sold"));
            System.out.println(p1);
//}  
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}
