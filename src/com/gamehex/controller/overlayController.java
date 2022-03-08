/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentagon3a1.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static pentagon3a1.controller.overlayTool.txt_summoner;
import utils.summonerInfo;

/**
 * FXML Controller class
 *
 * @author Moudhaffer
 */
public class overlayController implements Initializable {

    @FXML
    private JFXTextField txt_summoner;
    @FXML
    private JFXComboBox<String> jfxcb_region;
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
    private TableColumn<summonerInfo, String> col_Icon;
    @FXML
    private Button btn_search;
    @FXML
    private JFXTextField keywordTextField;

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

    @FXML
    private void handleButton(ActionEvent event) {
        System.out.println("Hello");
        showSummoner();
    }
    
    public void showSummoner(){
        ObservableList<summonerInfo> list = getSummonerList();
        
        //Setting sumoner name column
        col_Summoner.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSummonerName()));
        //col_Summoner.setCellValueFactory(new PropertyValueFactory<>("Summoner name"));
        //Setting summoner level column
        col_Level.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getLevel()));
        //col_Level.setCellValueFactory(new PropertyValueFactory<>("Level"));
        //Setting summoner's most played champion column
        col_Champ.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMostPlayedChamp()));
        //col_Champ.setCellValueFactory(new PropertyValueFactory<>("Most Played Champion"));
        //Setting summoner's rank column
        col_Rank.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRank()));
        //col_Rank.setCellValueFactory(new PropertyValueFactory<>("Ranked Tier"));
        //Setting summoner's icon column
        col_Icon.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfileIcon()));
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
    
    public ObservableList<summonerInfo> getSummonerList(){
        ObservableList<summonerInfo> summonerInfoList = FXCollections.observableArrayList();        
        summonerInfo sumInfo = new summonerInfo(txt_summoner.getText(),
                mostPlayedChampion(), getLvl(), getTier(), getSummonerIcon());
        summonerInfoList.add(sumInfo);
        System.out.println(summonerInfoList);
        return summonerInfoList;
    }
    
    public Integer getLvl(){
        Summoner summ = getSummoner();
        Integer lvl = summ.getLevel();
        return lvl;
    }
    
    public String mostPlayedChampion(){
        //Summoner summ = Orianna.summonerNamed(txt_summoner.getText()).get();
        
        Summoner summ = getSummoner();
        ChampionMasteries masteries = summ.getChampionMasteries();
        List<ChampionMastery> goodWith = masteries.filter((ChampionMastery mastery) -> mastery.getLevel() >= 6);

        List<String> names = goodWith.stream().map((ChampionMastery mastery) -> mastery.getChampion().getName()).collect(Collectors.toList());
        //System.out.println("[" + String.join(", ", names) + "]");         
        return names.get(0);
    }
    
    public String getTier(){
        Summoner summ = getSummoner();
        String tier = summ.getLeague(Queue.RANKED_SOLO).getTier().toString();
        return tier;
    }
    
    public String getSummonerIcon(){
        Summoner summ = Orianna.summonerNamed(txt_summoner.getText()).get();
        String str = summ.getProfileIcon().getImage().getURL();
        return str;
    }
    
    private Summoner getSummoner(){
        Orianna.setRiotAPIKey("RGAPI-73cb2001-349f-4549-81f9-668b1a58151b");
        Orianna.setDefaultRegion(Region.valueOf(jfxcb_region.getValue()));
        Summoner summoner = Summoner.named(txt_summoner.getText()).get();
        return summoner; 
    }
}
