/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pkgfinal.entity.User;
import pkgfinal.service.UsersService;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import pkgfinal.entity.Session;
import pkgfinal.entity.enumRole;
import pkgfinal.entity.enumRole.role;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private Hyperlink forget;
    @FXML
    private Button signin;
    @FXML
    private Button signup;
    @FXML
    private TextField tfLogEmail;
    @FXML
    private TextField tfLogPwd;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    }   
    
    
     @FXML
    void signin(MouseEvent event) {
        User u = new User();
        UsersService us = new UsersService();
           if( (!tfLogEmail.getText().isEmpty()&& !tfLogPwd.getText().isEmpty()) ){
               if(us.checklogin(tfLogEmail.getText(), tfLogPwd.getText())==true){
                   //u.setEmail(tfLogEmail.getText());
                   u.setName(us.findName(tfLogEmail.getText()).getName());
                   u.setLastName(us.findName(tfLogEmail.getText()).getLastName());
                   u.setRole(us.findName(tfLogEmail.getText()).getRole());
                   //System.out.println(u);
                   /*if((("admin1@esprit.tn".equals(tfLogEmail.getText()))&&("admin1".equals(tfLogPwd.getText())))
                           ||(("admin2@esprit.tn".equals(tfLogEmail.getText()))&&("admin2".equals(tfLogPwd.getText()))))*/
                   if(u.getRole().equals(role.ADMIN.toString()))
                   {
                      try {
                           Session.StartSession().setSessionUser(us.existByEmail(tfLogEmail.getText()));
                           FXMLLoader fxmlLoader = new FXMLLoader();
                           Parent parent = FXMLLoader.load(getClass().getResource("/pkgfinal/view/UserFXML.fxml"));
                           Scene scene = new Scene(parent);
                           Stage stage = new Stage();
                           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                           stage.setScene(scene);
                           stage.show();
                            } catch (IOException ex) {
                            System.out.println("error in displaying User Interface");
                           }
                   }
                   else{
                       try {
                            Session.StartSession().setSessionUser(us.existByEmail(tfLogEmail.getText()));
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            Parent parent = FXMLLoader.load(getClass().getResource("/pkgfinal/view/ArticleFXML.fxml"));
                            Scene scene = new Scene(parent);
                            Stage stage = new Stage();
                            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                            } catch (IOException ex) {
                            System.out.println("error in displaying Article Interface");
                            }
                           }
                } 
               else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("User not found !!!  ");
                    alert.setContentText("Please verify your password or mail !!! ");
                    alert.show();
                   }
               
           }
           else{
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("User not found !!! ");
               alert.setContentText("Please fill in the filds !!! ");
               alert.show();
           }
              
    }

    
    @FXML
    private void signup(MouseEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent parent = FXMLLoader.load(getClass().getResource("/pkgfinal/view/signupFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            } catch (IOException ex) {
                System.out.println("error in displaying Article");
            }
    }

    @FXML
    private void forget(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent parent = FXMLLoader.load(getClass().getResource("/pkgfinal/view/pwdFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            } catch (IOException ex) {
                System.out.println("error in displaying Article");
            }
        
    }
    
   
    
    }
  
    
    

