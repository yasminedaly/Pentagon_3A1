/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pkgfinal.entity.Session;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class DashboardFXMLController implements Initializable {

    @FXML
    private Button pickUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pickUser(MouseEvent event) {
        try {
                           
                           FXMLLoader fxmlLoader = new FXMLLoader();
                           Parent parent = FXMLLoader.load(getClass().getResource("/pkgfinal/view/dashboardSecondFXML.fxml"));
                           Scene scene = new Scene(parent);
                           Stage stage = new Stage();
                           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                           stage.setScene(scene);
                           stage.show();
                            } catch (IOException ex) {
                            System.out.println("error in displaying User Interface");
                           }
    }
    
}
