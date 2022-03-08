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
import pkgfinal.entity.Article;
import pkgfinal.entity.Session;
import pkgfinal.entity.User;
import pkgfinal.service.ArticlesService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class DashboardArticleFXMLController implements Initializable {

    @FXML
    private TableView<Article> tvArticles;
    @FXML
    private TableColumn<Article, Integer> tvID;
    @FXML
    private TableColumn<Article, String> tvContent;
    @FXML
    private Button back;
    @FXML
    private Label labelName;

    /**
     * Initializes the controller class.
     */
    
    
    private void dispayutils(ObservableList<Article> listArticle) {
        tvID.setCellValueFactory(new PropertyValueFactory<Article, Integer>("articleID"));
        tvContent.setCellValueFactory(new PropertyValueFactory<Article , String>("content"));
        
        tvArticles.setItems(listArticle);
    }
    
    public void showArticle(){
        ArticlesService as = new ArticlesService();
        ObservableList<Article> listArticle = as.displayArticle();
        dispayutils(listArticle);
        System.out.println(listArticle);
    }
    
    
    //********* session **********
    User u=Session.StartSession().getSessionUser();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelName.setText("WELCOME   "+u.getName().toUpperCase()+" "+u.getLastName().toUpperCase());
        showArticle();
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
