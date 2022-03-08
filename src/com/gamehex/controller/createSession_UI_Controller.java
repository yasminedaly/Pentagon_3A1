/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentagon3a1.controller;

import com.jfoenix.controls.JFXTimePicker;
import entity.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Moudhaffer
 */
public class createSession_UI_Controller implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableColumn<Session, SimpleIntegerProperty> col_id;
    @FXML
    private TableColumn<Session, String> col_Date;
    @FXML
    private TableColumn<Session, String> col_Start;
    private TableColumn<Session, String> col_Duration;
    @FXML
    private TableColumn<Session, String> col_Coach;
    @FXML
    private TableColumn<Session, String> col_Player;
    @FXML
    private Button btn_insert;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    @FXML
    private TextField keywordTextField;
    
    private Connection cnx;
    @FXML
    private TextField txt_sessionId;
    @FXML
    private TextField txt_coach;
    @FXML
    private TextField txt_player;
    @FXML
    private DatePicker dp_session;
    @FXML
    private TableView<Session> tv_sessions;
    @FXML
    private JFXTimePicker tp_session;


    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TableColumn<Session, SimpleIntegerProperty> getCol_id() {
        return col_id;
    }

    public void setCol_id(TableColumn<Session, SimpleIntegerProperty> col_id) {
        this.col_id = col_id;
    }

    public TableColumn<Session, String> getCol_Date() {
        return col_Date;
    }

    public void setCol_Date(TableColumn<Session, String> col_Date) {
        this.col_Date = col_Date;
    }

    public TableColumn<Session, String> getCol_Start() {
        return col_Start;
    }

    public void setCol_Start(TableColumn<Session, String> col_Start) {
        this.col_Start = col_Start;
    }

    public TableColumn<Session, String> getCol_Duration() {
        return col_Duration;
    }

    public void setCol_Duration(TableColumn<Session, String> col_Duration) {
        this.col_Duration = col_Duration;
    }

    public TableColumn<Session, String> getCol_Coach() {
        return col_Coach;
    }

    public void setCol_Coach(TableColumn<Session, String> col_Coach) {
        this.col_Coach = col_Coach;
    }

    public TableColumn<Session, String> getCol_Player() {
        return col_Player;
    }

    public void setCol_Player(TableColumn<Session, String> col_Player) {
        this.col_Player = col_Player;
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

    public TextField getKeywordTextField() {
        return keywordTextField;
    }

    public void setKeywordTextField(TextField keywordTextField) {
        this.keywordTextField = keywordTextField;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public TextField getTxt_sessionId() {
        return txt_sessionId;
    }

    public void setTxt_sessionId(TextField txt_sessionId) {
        this.txt_sessionId = txt_sessionId;
    }

    public TextField getTxt_coach() {
        return txt_coach;
    }

    public void setTxt_coach(TextField txt_coach) {
        this.txt_coach = txt_coach;
    }

    public TextField getTxt_player() {
        return txt_player;
    }

    public void setTxt_player(TextField txt_player) {
        this.txt_player = txt_player;
    }

    public DatePicker getDp_session() {
        return dp_session;
    }

    public void setDp_session(DatePicker dp_session) {
        this.dp_session = dp_session;
    }

    public TableView<Session> getTv_sessions() {
        return tv_sessions;
    }

    public void setTv_sessions(TableView<Session> tv_sessions) {
        this.tv_sessions = tv_sessions;
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showSessions();
    }    

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if (event.getSource() == btn_insert){
            try {
                insertSession();
            } catch (IOException ex) {
                Logger.getLogger(createSession_UI_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(event.getSource() == btn_update){
            updateSession();
        }else if(event.getSource() == btn_delete){
            deleteSession();
        }
        
    }
    
    public createSession_UI_Controller() {
        cnx = MyConnection.getInstance().getCnx();
    }
    
    public ObservableList<Session> getSessionList(){
        ObservableList<Session> sessionList = FXCollections.observableArrayList();
        String query = "SELECT * FROM session";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            Session session;
            while(rs.next()){
                
                session = new Session(rs.getInt("sessionId"), rs.getTime("startTime"), rs.getDate("Date").toLocalDate(), rs.getString("coachAttendee"),
                            rs.getString("playerAttendee"));
                sessionList.add(session);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sessionList;
    }
    
    public void showSessions(){
        
        ObservableList<Session> list = getSessionList();
        
        //Setting ID field value
        getCol_id().setCellValueFactory(cellData -> new SimpleObjectProperty(Integer.toString(cellData.getValue().getSessionId())));
        //Setting Username field value
        getCol_Start().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartTime().toString()));
        //Setting Email field value
        getCol_Date().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
  
        getCol_Coach().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCoachAttendee()));
        //Setting type field
        getCol_Player().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getPlayerAttendee()));
        
        tv_sessions.setItems(list);
        
        
        FilteredList<Session> filteredData = new FilteredList<>(list, b -> true);
        keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(session -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (String.valueOf(session.getSessionId()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(session.getCoachAttendee()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(session.getPlayerAttendee()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(session.getDate()).indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Session> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tv_sessions.comparatorProperty());
        tv_sessions.setItems(sortedData);
    }
    
    //Helpers
    public String returnDate(){
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        return date;
    }
    
    public String returnStartTime(){
        Format f = new SimpleDateFormat("HH-mm-ss");
        String strDate = f.format(new java.util.Date());
        return strDate;
    }
    
   
    private void executeQuery(String query) {
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
public void insertSession() throws IOException{
//        String query = "INSERT INTO session(id, startTime, Date, coachAttendee, playerAttendee, rating)"
//                + " VALUES (?, ?, ?, ?, ?, ?)";
//        try {
//            PreparedStatement pst = cnx.prepareStatement(query);
//            pst.setInt(1, Integer.parseInt(txt_sessionId.getText()));
//            pst.setString(2, returnStartTime());
//            pst.setString(3, returnDate());
//            pst.setString(4, txt_coach.getText());
//            pst.setString(5, txt_player.getText());
//            pst.setString(6, "3");
//            pst.executeUpdate();
//            System.out.println("Session Added sucessfully");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        java.sql.Date sessionDate = java.sql.Date.valueOf(dp_session.getValue());
        String query = "INSERT INTO session(sessionId, startTime, Date, coachAttendee, playerAttendee) values ('" + txt_sessionId.getText() + "','" + tp_session.getValue().toString() +"','" + dp_session.getValue().toString() + "','" + txt_coach.getText() + "','" + txt_player.getText() + "')";
        executeQuery(query);
        showSessions();
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/pentagon3a1/view/rateMyApp.fxml"));
        //stage.getIcons().add(new Image("com/gamehex/assets/NotePad.png"));
        Scene scene = new Scene(root);
        stage.setTitle("Rating");
        stage.setScene(scene);
        stage.show();
    }
    
    private void updateSession() {
        String query = "UPDATE session SET coachAttendee = '" + txt_coach.getText() + "' , playerAttendee = '" + txt_player.getText() + "' ,startTime = '" + tp_session.getValue() + "' ,Date = '" + dp_session.getValue() + "' WHERE sessionId = " + txt_sessionId.getText() + "";
        executeQuery(query);
        showSessions();
    }

//    public void updateSession(){
//        String query = "UPDATE session SET coachAttendee= ?, playerAttendee= ?, startTime= ?, Date= ?,"
//                + " WHERE sessionId= ?;";
//        try {
//            PreparedStatement pst = cnx.prepareStatement(query);
//            pst.setString(1, txt_coach.getText());
//            pst.setString(2, txt_player.getText());
//            pst.setString(3, tp_session.getValue().toString());
//            pst.setString(4, dp_session.getValue().toString());
//            pst.setInt(5, Integer.parseInt(txt_sessionId.getText()));
//            pst.executeUpdate();
//        } catch (NumberFormatException | SQLException ex) {
//            ex.printStackTrace();
//        }
//        showSessions();
//    }
    
    @FXML
    private LocalDate getDate(ActionEvent event) {
        LocalDate myDate = dp_session.getValue();
        return myDate;
    }
    
    @FXML
    public LocalTime getTime(ActionEvent event){
        LocalTime myTime = tp_session.getValue();
        return myTime;
    }
    
    private void deleteSession() {
        String query = "DELETE FROM session WHERE sessionId=" + txt_sessionId.getText() + "";
        executeQuery(query);
        showSessions();
    }
    
    
}

