/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamehex.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.gamehex.entity.Matches;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Yasmine Daly
 */
public class AddMatchController implements Initializable{

    @FXML
    private TextField tfMatchId;
    @FXML
    private TextField tfTeam1;
    @FXML
    private TextField tfTeam2;
    @FXML
    private TextField tfMatchRes;
    @FXML
    private TextField tfMatchCom;
    @FXML
    private TableView<Matches> tvMatches;
    @FXML
    //private TableColumn<Matches, SimpleIntegerProperty> colMatchId;
    private TableColumn<Matches, Integer> colMatchId;
    @FXML
    private TableColumn<Matches, SimpleIntegerProperty> colTeam1;
    @FXML
    private TableColumn<Matches, SimpleIntegerProperty> colTeam2;
    @FXML
    private TableColumn<Matches, SimpleIntegerProperty> colMatchRes;
    @FXML
    private TableColumn<Matches, SimpleStringProperty> colMatchCom;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField keywordTextField;

    public TableColumn<Matches, Integer> getColMatchId() {
        return colMatchId;
    }

    public TableColumn<Matches, SimpleIntegerProperty> getColTeam1() {
        return colTeam1;
    }

    public TableColumn<Matches, SimpleIntegerProperty> getColTeam2() {
        return colTeam2;
    }

    public TableColumn<Matches, SimpleIntegerProperty> getColMatchRes() {
        return colMatchRes;
    }

    public TableColumn<Matches, SimpleStringProperty> getColMatchCom() {
        return colMatchCom;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnInsert) {
            insertMatch();
        } else if (event.getSource() == btnUpdate) {
            updateMatch();
        } else if (event.getSource() == btnDelete) {
            deleteMatch();
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showMatches();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamehex", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Matches> getMatchesList() {
        Connection conn = getConnection();
        String query = "SELECT * FROM matches ";
        ObservableList<Matches> list = FXCollections.observableArrayList();
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Matches matches;
            while (rs.next()) {
                matches = new Matches(rs.getInt("matchid"), rs.getInt("team1"), rs.getInt("team2"), rs.getInt("matchres"), rs.getString("matchcom"));
                list.add(matches);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void showMatches() {
        ObservableList<Matches> matchList = getMatchesList();

        getColMatchId().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getMatchId()));

        getColTeam1().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getTeam1()));

        getColTeam2().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getTeam2()));

        getColMatchRes().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getMatchRes()));

        getColMatchCom().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getMatchCom()));

        tvMatches.setItems(matchList);

        FilteredList<Matches> filteredData;
        filteredData = new FilteredList<>(matchList, b -> true);
        keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Matches -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (String.valueOf(Matches.getMatchId()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Matches.getTeam1()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Matches.getTeam2()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(Matches.getMatchRes()).indexOf(searchKeyword) > -1) {
                    return true;
                } else if (Matches.getMatchCom().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Matches> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvMatches.comparatorProperty());
        tvMatches.setItems(sortedData);

    }

    private void insertMatch() {
        String query = "insert into matches (matchid,team1,team2,matchres,matchcom) values ('" + tfMatchId.getText() + "','" + tfTeam1.getText() + "','" + tfTeam2.getText() + "','" + tfMatchRes.getText() + "','" + tfMatchCom.getText() + "')";
        executeQuery(query);
        showMatches();
    }

    private void updateMatch() {
        String query = "UPDATE matches SET team1 = '" + tfTeam1.getText() + "' , team2 = '" + tfTeam2.getText() + "' ,matchres = '" + tfMatchRes.getText() + "' ,matchcom = '" + tfMatchCom.getText() + "' WHERE matchid = " + tfMatchId.getText() + "";
        executeQuery(query);
        showMatches();
    }

    private void deleteMatch() {
        String query = "DELETE FROM matches WHERE matchid=" + tfMatchId.getText() + "";
        executeQuery(query);
        showMatches();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Matches match = tvMatches.getSelectionModel().getSelectedItem();
        System.out.println("Id" + match.getMatchId());
        System.out.println("team1" + match.getTeam1());
        System.out.println("team2" + match.getTeam2());
        System.out.println("Result" + match.getMatchRes());
        System.out.println("Comment" + match.getMatchCom());

        tfMatchId.setText("" + match.getMatchId());
        tfTeam1.setText("" + match.getTeam1());
        tfTeam2.setText("" + match.getTeam2());
        tfMatchRes.setText("" + match.getMatchRes());
        tfMatchCom.setText("" + match.getMatchCom());
    }

}
