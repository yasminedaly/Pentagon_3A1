/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import pkgfinal.entity.User;
import pkgfinal.service.UsersService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SignupFXMLController implements Initializable {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfCIN;
    @FXML
    private TextField tfPhone;
    @FXML
    private DatePicker tfDate;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button submit;
    @FXML
    private TextField tfPWD;
    @FXML
    private Button back;
    @FXML
    private ImageView photoAnime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        submit.setOnAction(event->{
             if( (tfName.getText().isEmpty() || tfLastName.getText().isEmpty() || tfCIN.getText().isEmpty()
                   ||tfPhone.getText().isEmpty() || tfDate.getValue()==null
                   || tfEmail.getText().isEmpty() || tfPWD.getText().isEmpty()) ){
               
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("User can not be created !!! ");
                  alert.setContentText("Please fill in the filds !!! ");
                  alert.show();  
              }
             else if((!Pattern.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", tfCIN.getText()))
                   || (!Pattern.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", tfPhone.getText()))){
                
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("User can not be updated !!! ");
                   alert.setContentText("CIN and Phone must be formed with numbers only ( 8 numbers to be specific) !!! ");
                   alert.show(); 
               }
             else if(!Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", tfEmail.getText())){
                
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("User can not be updated !!! ");
                   alert.setContentText("Email format is not correct !!! ");
                   alert.show(); 
               }
               else{       
                    int CIN = Integer.parseInt(tfCIN.getText());
                    int phone = Integer.parseInt(tfPhone.getText());
                    User u = new User(tfName.getText(),
                                      tfLastName.getText(),
                                      CIN,
                                      phone,
                                      tfDate.getValue().toString(),
                                      tfEmail.getText(),
                                      tfPWD.getText());
            
                    UsersService us = new UsersService();
                    us.addUser(u);
                    tfName.setText("");
                    tfLastName.setText("");
                    tfCIN.setText("");
                    tfPhone.setText("");
                    //tfDate.setValue("");
                    tfEmail.setText("");
                    tfPWD.setText("");
            
                    try {
                         FXMLLoader fxmlLoader = new FXMLLoader();
                         Parent parent = FXMLLoader.load(getClass().getResource("/pkgfinal/view/loginFXML.fxml"));
                         Scene scene = new Scene(parent);
                         Stage stage = new Stage();
                         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                         stage.setScene(scene);
                         stage.show();
                         } catch (IOException ex) {
                         System.out.println("error in displaying the interface");
                         }  
                   }
        });
        
         // Animation
  TranslateTransition translate = new TranslateTransition();
  translate.setNode(photoAnime);
  translate.setDuration(Duration.millis(1000));
  translate.setCycleCount(TranslateTransition.INDEFINITE);
  translate.setByX(10);
  translate.setByY(200);
  translate.setAutoReverse(true);
  translate.play();
  
    
    }    


    @FXML
    private void back(MouseEvent event) {
        try {
             FXMLLoader fxmlLoader = new FXMLLoader();
             Parent parent = FXMLLoader.load(getClass().getResource("/pkgfinal/view/loginFXML.fxml"));
             Scene scene = new Scene(parent);
             Stage stage = new Stage();
             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.setScene(scene);
             stage.show();
             } catch (IOException ex) {
                System.out.println("error in displaying the interface");
             }  
    }
    
}
