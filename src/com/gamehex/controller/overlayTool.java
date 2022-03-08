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
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.common.Tier;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import entity.Session;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.summonerInfo;

/**
 * FXML Controller class
 *
 * @author Moudhaffer
 */
public class overlayTool implements Initializable {

    @FXML
    private JFXComboBox<String> jfxcb_region;
    @FXML
    public static JFXTextField txt_summoner;
    @FXML
    private TableView<summonerInfo> tv_Summoner;
    @FXML
    private TableColumn<summonerInfo, String> col_Summoner;
    @FXML
    private TableColumn<summonerInfo, Integer> col_Level;
    @FXML
    private TableColumn<summonerInfo, String> col_Rank;
    @FXML
    private TableColumn<summonerInfo, String> col_Champ;
    @FXML
    private Button btn_search;
    @FXML
    private TableColumn<summonerInfo, String> col_Icon;
    @FXML
    private JFXTextField keywordTextField;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillJFXComboBox();
        showSummoner();

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
        
        if (jfxcb_region.getValue() == "NORTH_AMERICA"){
                Orianna.setDefaultRegion(Region.NORTH_AMERICA);
        }else if(jfxcb_region.getValue() == "BRAZIL"){
                Orianna.setDefaultRegion(Region.BRAZIL);
        }else if(jfxcb_region.getValue() == "EUROPE_NORTH_EAST"){
                Orianna.setDefaultRegion(Region.EUROPE_NORTH_EAST);
        }else if(jfxcb_region.getValue() == "JAPAN"){
                Orianna.setDefaultRegion(Region.JAPAN);
        }else if(jfxcb_region.getValue() == "EUROPE_WEST"){
                Orianna.setDefaultRegion(Region.EUROPE_WEST);
        }else if(jfxcb_region.getValue() == "KOREA"){
                Orianna.setDefaultRegion(Region.KOREA);
        }else if(jfxcb_region.getValue() == "LATIN_AMERICA_NORTH"){
                Orianna.setDefaultRegion(Region.LATIN_AMERICA_NORTH);
        }else if(jfxcb_region.getValue() == "LATIN_AMERICA_SOUTH"){
                Orianna.setDefaultRegion(Region.LATIN_AMERICA_SOUTH);
        }else if(jfxcb_region.getValue() == "OCEANIA"){
                Orianna.setDefaultRegion(Region.OCEANIA);
        }else if(jfxcb_region.getValue() == "RUSSIA"){
                Orianna.setDefaultRegion(Region.RUSSIA);
        }else if(jfxcb_region.getValue() == "TURKEY"){
                Orianna.setDefaultRegion(Region.TURKEY);
        }
        
        Summoner summ = Orianna.summonerNamed(txt_summoner.getText()).get();
        
        return summ; 
    }
    
    public void showSummoner(){
        ObservableList<summonerInfo> list = getSummonerList();
        
        //Setting sumoner name column
        getCol_Summoner().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSummonerName()));
        //col_Summoner.setCellValueFactory(new PropertyValueFactory<>("Summoner name"));
        //Setting summoner level column
        getCol_Level().setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getLevel()));
        //col_Level.setCellValueFactory(new PropertyValueFactory<>("Level"));
        //Setting summoner's most played champion column
        getCol_Champ().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMostPlayedChamp()));
        //col_Champ.setCellValueFactory(new PropertyValueFactory<>("Most Played Champion"));
        //Setting summoner's rank column
        getCol_Rank().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRank()));
        //col_Rank.setCellValueFactory(new PropertyValueFactory<>("Ranked Tier"));
        //Setting summoner's icon column
        getCol_Icon().setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfileIcon()));
        //col_Icon.setCellValueFactory(new PropertyValueFactory<>("Summoner Icon"));
        
        tv_Summoner.setItems(list);
        
        
        FilteredList<summonerInfo> filteredData = new FilteredList<>(list, b -> true);
        keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((summonerInfo sum) -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (sum.getSummonerName().contains(searchKeyword)) {
                    return true;
                } else if (String.valueOf(sum.getMostPlayedChamp()).contains(searchKeyword)) {
                    return true;
                } else if (String.valueOf(sum.getRank()).contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<summonerInfo> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tv_Summoner.comparatorProperty());
        tv_Summoner.setItems(sortedData);
    }
    
    private String mostPlayedChampion(){
            Summoner fatalElement = Summoner.named(overlayTool.txt_summoner.getText()).get();
            ChampionMasteries masteries = fatalElement.getChampionMasteries();
            List<ChampionMastery> goodWith = masteries.filter((ChampionMastery mastery) -> mastery.getLevel() >= 6);

            List<String> names = goodWith.stream().map((ChampionMastery mastery) -> mastery.getChampion().getName()).collect(Collectors.toList());
            System.out.println("[" + String.join(", ", names) + "]");            
            return names.get(0);
    }
    
    
    public ObservableList<summonerInfo> getSummonerList(){
        ObservableList<summonerInfo> summonerInfoList = FXCollections.observableArrayList();        
        summonerInfo sumInfo = new summonerInfo(txt_summoner.getText(),
                mostPlayedChampion(), getSummoner().getLevel(), getTier(),
                            getSummoner().getProfileIcon().getImage().getURL());
        summonerInfoList.add(sumInfo);
        return summonerInfoList;
    }
    
    public String getTier(){
        String tier = getSummoner().getLeague(Queue.RANKED_SOLO).getTier().toString();
        return tier;
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

    public void setTv_Summoner(TableView<summonerInfo> tv_Summoner) {
        this.tv_Summoner = tv_Summoner;
    }

    public TableColumn<summonerInfo, String> getCol_Summoner() {
        return col_Summoner;
    }

    public void setCol_Summoner(TableColumn<summonerInfo, String> col_Summoner) {
        this.col_Summoner = col_Summoner;
    }

    public TableColumn<summonerInfo, Integer> getCol_Level() {
        return col_Level;
    }

    public void setCol_Level(TableColumn<summonerInfo, Integer> col_Level) {
        this.col_Level = col_Level;
    }

    public TableColumn<summonerInfo, String> getCol_Rank() {
        return col_Rank;
    }

    public void setCol_Rank(TableColumn<summonerInfo, String> col_Rank) {
        this.col_Rank = col_Rank;
    }

    public TableColumn<summonerInfo, String> getCol_Champ() {
        return col_Champ;
    }

    public void setCol_Champ(TableColumn<summonerInfo, String> col_Champ) {
        this.col_Champ = col_Champ;
    }

    public TableColumn<summonerInfo, String> getCol_Icon() {
        return col_Icon;
    }

    public void setCol_Icon(TableColumn<summonerInfo, String> col_Icon) {
        this.col_Icon = col_Icon;
    }


    private void search_summoner(ActionEvent event) {
        Orianna.setRiotAPIKey("RGAPI-44b95c6e-a19d-4679-a178-e3df35301a7d");
        switch (jfxcb_region.getValue()){
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
                break;
        }

        Summoner summoner = Orianna.summonerNamed(txt_summoner.getText()).get();
        //System.out.println(summoner.getCurrentMatch().getParticipants());
        
        
    }

    @FXML
    private void handleButton(ActionEvent event) {
        showSummoner();
    }
    
}
