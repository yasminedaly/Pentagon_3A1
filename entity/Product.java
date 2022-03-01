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
public class Product {

    static Product valueOf(String productName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //ATTRIBUTES - GETTERS - SETTERS - TOSTRING - CONSTRUCTORS
    
    private int id_product;
    private String ref;
    private String name;
    private String description;
    private int price;
    private int review;
    private String state;
    private int id_supplier;
    private String imagesrc;

    
    public Product (){};
    
    public Product(int id_product,String ref, String name, String description, int price, int review,String state, int id_supplier){
        this.id_product = id_product;
        this.ref = ref;
        this.name = name;
        this.description = description;
        this.price = price;
        this.review = review;
        this.state = state;
        this.id_supplier = id_supplier;
    }
    
    public Product(String ref,String name, String description, int price, int review, String state, int id_supplier){
        this.ref = ref;
        this.name = name;
        this.description = description;
        this.price = price;
        this.review = review;
        this.state = state;
        this.id_supplier = id_supplier;
    }

    public int getId_product() {
        return id_product;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getReview() {
        return review;
    }
    
    public String getState() {
        return state;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public String getRef() {
        return ref;
    }

    public String getImagesrc() {
        return imagesrc;
    }
    
    
    
    
    

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }
    
    

    @Override
    public String toString() {
        return "Product{" + "id_product=" + id_product + ", ref=" + ref + ", name=" + name + ", description=" + description + ", price=" + price + ", review=" + review + ", state=" + state + ", id_supplier=" + id_supplier + '}';
    }
    

    
    
    
    
    
    
}
