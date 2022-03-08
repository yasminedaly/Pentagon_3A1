/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentagon3a1.controller;

import entity.Coaches;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import utils.MyConnection;

/**
 *
 * @passwd Moudhaffer
 */
public class Coach_UIController implements Initializable {


    @FXML
    private Button btn_insert;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    
    //Singleton connection
    Connection cnx;
    @FXML
    private Label label;
    @FXML
    private TextField txt_coachId;
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_passwd;
    @FXML
    private TextField txt_profileInfo;
    @FXML
    private TextField txt_sessionList;
    @FXML
    private TextField txt_type;
    @FXML
    private TextField txt_rating;
    @FXML
    private TableColumn<Coaches, String> col_username;
    @FXML
    private TableColumn<Coaches, String> col_email;
    @FXML
    private TableColumn<Coaches, String> col_profileInfo;
    @FXML
    private TableColumn<Coaches, String> col_sessionList;
    @FXML
    private TableColumn<Coaches, String> col_type;
    @FXML
    private TableColumn<Coaches, Integer> col_rating;
    @FXML
    private TextField txt_email;
    @FXML
    private TableView<Coaches> tv_coaches;
    @FXML
    private TableColumn<Coaches, SimpleIntegerProperty> col_id;
    @FXML
    private TextField keywordTextField;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
        if(event.getSource() == btn_insert){
            insertCoach();
        }
        else if(event.getSource() == btn_update){
            updateCoach();
        }
        else if(event.getSource() == btn_delete){
            deleteCoach();
        }
    }
    
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Coaches coach = tv_coaches.getSelectionModel().getSelectedItem();
        txt_coachId.setText(Integer.toString(coach.getId()));
        txt_username.setText(coach.getUsername());
        txt_profileInfo.setText(coach.getProfileInfo());
        txt_email.setText(coach.getEmail());
        txt_sessionList.setText(coach.getSessionList().get());
        txt_type.setText(coach.getType());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooks();
    }
    
    //Getters & Setters

    public TextField getTxt_id() {
        return txt_coachId;
    }

    public void setTxt_id(TextField txt_coachId) {
        this.txt_coachId = txt_coachId;
    }

    public Button getBtn_insert() {
        return btn_insert;
    }

    public void setBtn_insert(Button btn_insert) {
        this.btn_insert = btn_insert;
    }

    public Button getBtn_update() {
        return btn_update;
    }

    public void setBtn_update(Button btn_update) {
        this.btn_update = btn_update;
    }

    public Button getBtn_delete() {
        return btn_delete;
    }

    public void setBtn_delete(Button btn_delete) {
        this.btn_delete = btn_delete;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TextField getTxt_coachId() {
        return txt_coachId;
    }

    public void setTxt_coachId(TextField txt_coachId) {
        this.txt_coachId = txt_coachId;
    }

    public TextField getTxt_username() {
        return txt_username;
    }

    public void setTxt_username(TextField txt_username) {
        this.txt_username = txt_username;
    }

    public TextField getTxt_passwd() {
        return txt_passwd;
    }

    public void setTxt_passwd(TextField txt_passwd) {
        this.txt_passwd = txt_passwd;
    }

    public TextField getTxt_profileInfo() {
        return txt_profileInfo;
    }

    public void setTxt_profileInfo(TextField txt_profileInfo) {
        this.txt_profileInfo = txt_profileInfo;
    }

    public TextField getTxt_sessionList() {
        return txt_sessionList;
    }

    public void setTxt_sessionList(TextField txt_sessionList) {
        this.txt_sessionList = txt_sessionList;
    }

    public TextField getTxt_type() {
        return txt_type;
    }

    public void setTxt_type(TextField txt_type) {
        this.txt_type = txt_type;
    }

    public TextField getTxt_rating() {
        return txt_rating;
    }

    public TableView<Coaches> getTv_coaches() {
        return tv_coaches;
    }

    public void setTv_coaches(TableView<Coaches> tv_coaches) {
        this.tv_coaches = tv_coaches;
    }

    public TableColumn<Coaches, SimpleIntegerProperty> getCol_id() {
        return col_id;
    }

    public void setCol_id(TableColumn<Coaches, SimpleIntegerProperty> col_id) {
        this.col_id = col_id;
    }

    public void setTxt_rating(TextField txt_rating) {
        this.txt_rating = txt_rating;
    }

    public TableColumn<Coaches, String> getCol_username() {
        return col_username;
    }

    public void setCol_username(TableColumn<Coaches, String> col_username) {
        this.col_username = col_username;
    }

    public TableColumn<Coaches, String> getCol_email() {
        return col_email;
    }

    public void setCol_email(TableColumn<Coaches, String> col_email) {
        this.col_email = col_email;
    }

    public TableColumn<Coaches, String> getCol_profileInfo() {
        return col_profileInfo;
    }

    public void setCol_profileInfo(TableColumn<Coaches, String> col_profileInfo) {
        this.col_profileInfo = col_profileInfo;
    }

    public TableColumn<Coaches, String> getCol_sessionList() {
        return col_sessionList;
    }

    public void setCol_sessionList(TableColumn<Coaches, String> col_sessionList) {
        this.col_sessionList = col_sessionList;
    }

    public TableColumn<Coaches, String> getCol_type() {
        return col_type;
    }

    public void setCol_type(TableColumn<Coaches, String> col_type) {
        this.col_type = col_type;
    }

    public TableColumn<Coaches, Integer> getCol_rating() {
        return col_rating;
    }

    public void setCol_rating(TableColumn<Coaches, Integer> col_rating) {
        this.col_rating = col_rating;
    }

    public TextField getTxt_email() {
        return txt_email;
    }

    public void setTxt_email(TextField txt_email) {
        this.txt_email = txt_email;
    }


    public Coach_UIController() {
        cnx = MyConnection.getInstance().getCnx();
    }
    
    public ObservableList<Coaches> getCoachList(){
        ObservableList<Coaches> coachList = FXCollections.observableArrayList();
        String query = "SELECT * FROM coach";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            Coaches coach;
            while(rs.next()){
                coach = new Coaches(rs.getInt("coachId"), rs.getString("username"),
                        rs.getString("passwd"), rs.getString("email"),
                            rs.getString("profileInfo"),
                                rs.getString("sessionList"),
                                    rs.getString("type"), rs.getInt("rating"));
                coachList.add(coach);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return coachList;
    }
    
    public void showBooks(){
        
        ObservableList<Coaches> list = getCoachList();
        
        //Setting ID field value
        getCol_id().setCellValueFactory(cellData -> new SimpleObjectProperty(Integer.toString(cellData.getValue().getId())));
        //Setting Username field value
        getCol_username().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
        //Setting Email field value
        getCol_email().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEmail()));
        //Setting profileInfo field
        getCol_profileInfo().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getProfileInfo()));
        //Setting sessionList field
        getCol_sessionList().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getSessionList()));
        //Setting type field
        getCol_type().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getType()));
        //Setting Rating field
        getCol_rating().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getRating()));
        
        tv_coaches.setItems(list);
        
        
        FilteredList<Coaches> filteredData = new FilteredList<>(list, b -> true);
        keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Coaches -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (String.valueOf(Coaches.getId()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Coaches.getUsername()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Coaches.getEmail()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Coaches.getProfileInfo()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Coaches.getSessionList()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Coaches.getType()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (Coaches.getRating().toString().indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Coaches> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tv_coaches.comparatorProperty());
        tv_coaches.setItems(sortedData);
    }
    
    public void insertCoach(){
        String query = "INSERT INTO coach(coachId, username, passwd, email, profileInfo, sessionList, type, rating)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(txt_coachId.getText()));
            pst.setString(2, txt_username.getText());
            pst.setString(3, txt_passwd.getText());
            pst.setString(4, txt_email.getText());
            pst.setString(5, txt_profileInfo.getText());
            pst.setString(6, txt_sessionList.getText());
            pst.setString(7, txt_type.getText());
            pst.setInt(8, Integer.parseInt(txt_rating.getText()));
            pst.executeUpdate();
            System.out.println("User Added sucessfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showBooks();
    }
    
    public void updateCoach(){
        String query = "UPDATE coach SET coachId=?, username=?, passwd=?, email=?,"
                + " profileInfo=?, sessionList=?, type=?, rating=? WHERE coachId=?;";
        try {
            PreparedStatement pst = cnx.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(txt_coachId.getText()));
            pst.setString(2, txt_username.getText());
            pst.setString(3, txt_passwd.getText());
            pst.setString(4, txt_email.getText());
            pst.setString(5, txt_profileInfo.getText());
            pst.setString(6, txt_sessionList.getText());
            pst.setString(7, txt_type.getText());
            pst.setInt(8, Integer.parseInt(txt_rating.getText()));
            pst.setInt(9, Integer.parseInt(txt_coachId.getText()));
            pst.executeUpdate();
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
        showBooks();
    }
    
    public void deleteCoach(){
        String query = "DELETE FROM coach WHERE coachId=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(txt_coachId.getText()));
            pst.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showBooks();
    }

    
}
