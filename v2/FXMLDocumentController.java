/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexgame.v2;

import hexgame.dao.ProductDAO;
import hexgame.entity.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;



/**
 * FXML Controller class
 *
 * @author Dr.Green
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button button;
    @FXML
    private AnchorPane ap;

    
     @FXML
    private Text textWe;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        textWe.setText("Amine Selmi");
    }

    private void handleButtonAction(ActionEvent event) {

        ProductDAO p1 = new ProductDAO();
        //System.out.println(product1);

        //PRODUCT CRUD -- 
        Product product1 = new Product(8, "Rb748", "Feriel", "Echri terbah", 3000, 9, "Availble", 1);
        p1.Add(product1);
        System.out.println("You clicked me!");

    }

    @FXML
    private void home(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    private void viewProducts(MouseEvent event) {
        loadPage("ViewProducts");
        
        /*FXMLLoader fxmlLoader = new FXMLLoader();
        ProductController pController = fxmlLoader.getController();
        pController.Fill();
        */
        
        //ProductController p1 = new ProductController();
        //p1.Fill();
    }

    @FXML
    private void AddProduct(MouseEvent event) {
        loadPage("AddProduct");
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);

    }

}
