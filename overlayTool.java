/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentagon3a1.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.common.Season;
import com.merakianalytics.orianna.types.common.Tier;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import entity.Session;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Moudhaffer
 */
public class overlayTool implements Initializable {

    @FXML
    private JFXComboBox<String> jfxcb_region;
    @FXML
    private JFXTextField txt_summoner;
    @FXML
    private TableView<Summoner> tv_Summoner;
    @FXML
    private TableColumn<Summoner, String> col_Summoner;
    @FXML
    private TableColumn<Summoner, String> col_Level;
    @FXML
    private TableColumn<Summoner, Tier> col_Rank;
    @FXML
    private TableColumn<Summoner, String> col_Champ;
    @FXML
    private TableColumn<Summoner, String> col_Ratio;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillJFXComboBox();
    }
    
    private void fillJFXComboBox(){
        List<String> listRegions = new ArrayList();
        listRegions.add("NORTH_AMERICA");
        listRegions.add("BRAZIL");        
        listRegions.add("EUROPE_NORTH_EAST");
        listRegions.add("EUROPE_WEST");
        listRegions.add("JAPAN");
        listRegions.add("KOREA");
        listRegions.add("LATIN_AMERICA_NORTH");
        listRegions.add("LATIN_AMERICA_SOUTH");
        listRegions.add("NORTH_AMERICA");
        listRegions.add("OCEANIA");
        listRegions.add("RUSSIA");
        listRegions.add("TURKEY");
        ObservableList<String> items = FXCollections.observableArrayList(listRegions);
        jfxcb_region.setItems(items);
    }
    
    private Summoner getSummoner(){
        Orianna.setRiotAPIKey("RGAPI-44b95c6e-a19d-4679-a178-e3df35301a7d");
        switch (txt_summoner.getText()){
            case "NORTH_AMERICA":
                Orianna.setDefaultRegion(Region.NORTH_AMERICA);
                break;
            case "BRAZIL":
                Orianna.setDefaultRegion(Region.BRAZIL);
                break;
            case "EUROPE_NORTH_EAST":
                Orianna.setDefaultRegion(Region.EUROPE_NORTH_EAST);
                break;
            case "JAPAN":
                Orianna.setDefaultRegion(Region.JAPAN);
                break;
            case "EUROPE_WEST":
                Orianna.setDefaultRegion(Region.EUROPE_WEST);
                break;
            case "KOREA":
                Orianna.setDefaultRegion(Region.KOREA);
                break;
            case "LATIN_AMERICA_NORTH":
                Orianna.setDefaultRegion(Region.LATIN_AMERICA_NORTH);
                break;
            case "LATIN_AMERICA_SOUTH":
                Orianna.setDefaultRegion(Region.LATIN_AMERICA_SOUTH);
                break;
            case "OCEANIA":
                Orianna.setDefaultRegion(Region.OCEANIA);
                break;
            case "RUSSIA":
                Orianna.setDefaultRegion(Region.RUSSIA);
                break;
            case "TURKEY":
                Orianna.setDefaultRegion(Region.TURKEY);
        }
        
        Summoner summ = Orianna.summonerNamed(txt_summoner.getText()).get();
        
        return summ;
        
    }
    
    private Champion mostPlayedChamp(){
        Orianna.setRiotAPIKey("RGAPI-44b95c6e-a19d-4679-a178-e3df35301a7d");
        switch (txt_summoner.getText()){
            case "NORTH_AMERICA":
                Orianna.setDefaultRegion(Region.NORTH_AMERICA);
                break;
            case "BRAZIL":
                Orianna.setDefaultRegion(Region.BRAZIL);
                break;
            case "EUROPE_NORTH_EAST":
                Orianna.setDefaultRegion(Region.EUROPE_NORTH_EAST);
                break;
            case "JAPAN":
                Orianna.setDefaultRegion(Region.JAPAN);
                break;
            case "EUROPE_WEST":
                Orianna.setDefaultRegion(Region.EUROPE_WEST);
                break;
            case "KOREA":
                Orianna.setDefaultRegion(Region.KOREA);
                break;
            case "LATIN_AMERICA_NORTH":
                Orianna.setDefaultRegion(Region.LATIN_AMERICA_NORTH);
                break;
            case "LATIN_AMERICA_SOUTH":
                Orianna.setDefaultRegion(Region.LATIN_AMERICA_SOUTH);
                break;
            case "OCEANIA":
                Orianna.setDefaultRegion(Region.OCEANIA);
                break;
            case "RUSSIA":
                Orianna.setDefaultRegion(Region.RUSSIA);
                break;
            case "TURKEY":
                Orianna.setDefaultRegion(Region.TURKEY);
        }
        
        Champions champions = Orianna.getChampions();
        Champion randomChampion = champions.get((int)(Math.random() * champions.size()));
        return randomChampion;
        
    }
    
    public void showSummoner(){
        String summonerName = getSummoner().getName();
        String champ = mostPlayedChamp().getName();
        Integer level = getSummoner().getLevel();
        
        //Setting summoner name column
        getCol_Summoner().setCellValueFactory(cellData -> new SimpleStringProperty(summonerName));
        //Setting summoner level column
        getCol_Level().setCellValueFactory(cellData -> new SimpleStringProperty(level.toString()));
        //Setting Email field value
        getCol_Champ().setCellValueFactory(cellData -> new SimpleStringProperty(champ));
        
        
        
        tv_Summoner.getColumns().addAll(getCol_Summoner(), getCol_Level(), getCol_Champ());
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
    


    public JFXComboBox<String> getJfxcb_region() {
        return jfxcb_region;
    }

    public void setJfxcb_region(JFXComboBox<String> jfxcb_region) {
        this.jfxcb_region = jfxcb_region;
    }

    public JFXTextField getTxt_summoner() {
        return txt_summoner;
    }

    public void setTxt_summoner(JFXTextField txt_summoner) {
        this.txt_summoner = txt_summoner;
    }

    public TableView<?> getTv_Summoner() {
        return tv_Summoner;
    }

    public void setTv_Summoner(TableView<Summoner> tv_Summoner) {
        this.tv_Summoner = tv_Summoner;
    }

    public TableColumn<Summoner, String> getCol_Summoner() {
        return col_Summoner;
    }

    public void setCol_Summoner(TableColumn<Summoner, String> col_Summoner) {
        this.col_Summoner = col_Summoner;
    }

    public TableColumn<Summoner, String> getCol_Level() {
        return col_Level;
    }

    public void setCol_Level(TableColumn<Summoner, String> col_Level) {
        this.col_Level = col_Level;
    }

    public TableColumn<Summoner, Tier> getCol_Rank() {
        return col_Rank;
    }

    public void setCol_Rank(TableColumn<Summoner, Tier> col_Rank) {
        this.col_Rank = col_Rank;
    }

    public TableColumn<Summoner, String> getCol_Champ() {
        return col_Champ;
    }

    public void setCol_Champ(TableColumn<Summoner, String> col_Champ) {
        this.col_Champ = col_Champ;
    }

    public TableColumn<?, ?> getCol_Ratio() {
        return col_Ratio;
    }

    public void setCol_Ratio(TableColumn<Summoner, String> col_Ratio) {
        this.col_Ratio = col_Ratio;
    }
    
}
