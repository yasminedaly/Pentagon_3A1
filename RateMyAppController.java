/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentagon3a1.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.controlsfx.control.Rating;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yasmine Daly
 */
public class RateMyAppController implements Initializable {

    @FXML
    private Rating appRating;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSubmitClicked(ActionEvent event) {
        Stage stage = (Stage) btnSubmit.getScene().getWindow();
        System.out.println("Thank you for your time\n");
        System.out.println("Rating assigned:" +appRating.getRating());
        stage.close();
    }

    @FXML
    private void onCancelClicked(ActionEvent event) {
        Stage stage = (Stage) btnSubmit.getScene().getWindow();
        stage.close();
    }
    
}
