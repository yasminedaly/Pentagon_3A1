/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexgame.entity;

/**
 *
 * @author Dr.Green
 */
public class Supplier {
    
    private int id_supplier;
    private String name;
    private String start_date;
    private String leave_date;
    private int nbr_units_sold;
    
    public Supplier(){
        
    }
    
    //Constructor including ID
    public Supplier(int id_supplier, String name, String start_date, String leave_date,int nbr_units_sold){
        this.id_supplier = id_supplier;
        this.name = name;
        this.start_date = start_date;
        this.leave_date = leave_date;
        this.nbr_units_sold = nbr_units_sold;
    
    }
    
    //Constructor not including ID
    public Supplier(String name, String start_date, String leave_date,int nbr_units_sold){
        this.name = name;
        this.start_date = start_date;
        this.leave_date = leave_date;
        this.nbr_units_sold = nbr_units_sold;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public String getName() {
        return name;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getLeave_date() {
        return leave_date;
    }

    public int getNbr_units_sold() {
        return nbr_units_sold;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setLeave_date(String leave_date) {
        this.leave_date = leave_date;
    }

    public void setNbr_units_sold(int nbr_units_sold) {
        this.nbr_units_sold = nbr_units_sold;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id_supplier=" + id_supplier + ", name=" + name + ", start_date=" + start_date + ", leave_date=" + leave_date + ", nbr_units_sold=" + nbr_units_sold + '}';
    }
    
    
}
