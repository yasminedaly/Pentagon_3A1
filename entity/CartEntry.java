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
public class CartEntry {

    private Product product;
    private int quantity;

    public CartEntry(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public void increaseQtn(){
        this.quantity++;
    }
    
    public void decreaseQtn(){
        
        if(this.quantity > 0) {
        this.quantity--;    
        }
        
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    
    

}
