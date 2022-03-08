/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pkgfinal.entity.Session;
import pkgfinal.entity.User;
import pkgfinal.service.UsersService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class DashboardUserFXMLController implements Initializable {

    @FXML
    private TableView<User> tvUsers;
    @FXML
    private TableColumn<User, Integer> tvID;
    @FXML
    private TableColumn<User, String> tvName;
    @FXML
    private TableColumn<User, String> tvLastName;
    @FXML
    private TableColumn<User, Integer> tvCIN;
    @FXML
    private TableColumn<User, Integer> tvPhone;
    @FXML
    private TableColumn<User, String> tvDate;
    @FXML
    private TableColumn<User, String> tvEmail;
    @FXML
    private TableColumn<User, String> tvPWD;
    @FXML
    private Button back;
    @FXML
    private Label labelName;

    /**
     * Initializes the controller class.
     */
      

    private void dispayutils(ObservableList<User> listUser) {
        tvID.setCellValueFactory(new PropertyValueFactory<User, Integer>("userID"));
        tvName.setCellValueFactory(new PropertyValueFactory<User , String>("name"));
        tvLastName.setCellValueFactory(new PropertyValueFactory<User , String>("lastName"));
        tvCIN.setCellValueFactory(new PropertyValueFactory<User , Integer>("CIN"));
        tvPhone.setCellValueFactory(new PropertyValueFactory<User , Integer>("phone"));
        tvDate.setCellValueFactory(new PropertyValueFactory<User , String>("date"));
        tvEmail.setCellValueFactory(new PropertyValueFactory<User , String>("email"));
        tvPWD.setCellValueFactory(new PropertyValueFactory<User , String>("pwd"));
        tvUsers.setItems(listUser);
    }
    
    public void showUser(){
        UsersService us = new UsersService();
        ObservableList<User> listUser = us.displayUser() ;
        dispayutils(listUser);
        System.out.println(listUser);
    }
    
    
    //********* session **********
    User u=Session.StartSession().getSessionUser();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelName.setText("WELCOME   "+u.getName().toUpperCase()+" "+u.getLastName().toUpperCase());
            showUser();
    }  
    @FXML
    private void back(MouseEvent event) {
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
