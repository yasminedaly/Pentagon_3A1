/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexgame.v2;

import hexgame.dao.ProductDAO;
import hexgame.entity.Product;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Dr.Green
 */
public class ProductController implements Initializable {

    @FXML
    private Label name;

    @FXML
    private Label price;

    @FXML
    private GridPane productGrid;

    //ADMIN-PRODUCTS
    @FXML
    private TextField tdName;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tdPrice;

    @FXML
    private TextField tdReview;

    @FXML
    private TextField tdid;

    @FXML
    private TableView<Product> tvProducts;

    @FXML
    private TableColumn<Product, Integer> colID;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, String> colDescription;

    @FXML
    private TableColumn<Product, Integer> colPrice;

    @FXML
    private TableColumn<Product, Integer> colReview;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnCart;
    

    private List<Product> PList;
    ProductDAO p1 = new ProductDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        PList = new ArrayList(p1.ViewAll());


        //triggerItems.setVisible(false);
        //System.out.println("children : " + productGrid.getChildren());
        //showBooks();
        
    
    }

    public ProductController() {

    }

    public void Fill() {
        int columns = 0;
        int rows = 1;
        System.out.println(PList.get(1));

        try {
            for (int i = 0; i < PList.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Product.fxml"));
                VBox productBox = fxmlLoader.load();
                PList.get(i);
                System.out.println(PList.get(i).getName());
                //setData(PList.get(i));


                ProductController pController = fxmlLoader.getController();
                pController.setData(PList.get(i));

                if (columns == 3) {
                    columns = 0;
                    ++rows;
                }

                productGrid.add(productBox, columns++, rows);
                GridPane.setMargin(productBox, new Insets(3));

            }
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setData(Product p) {
        //Image image = new Image(getClass().getResourceAsStream(p.getImagesrc()));
        //productImage.setImage(image);

        name.setText(p.getName());
        price.setText(Integer.toString(p.getPrice()) + " DT");

        //productPrice.setText(p.getPrice());
    }

    private List<Product> data() {
        List<Product> lp = new ArrayList<>();
        Product p = new Product();

        p.setName("Amine selmi");

        lp.add(p);

        return lp;
    }

    public void showBooks() {

        //ComboBox<Product> topMenu = new ComboBox<Product>(FXCollections.observableList(p1.ViewAll()));
        ObservableList<Product> list = p1.ViewAll();

        colID.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id_product"));
        colName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        colReview.setCellValueFactory(new PropertyValueFactory<Product, Integer>("review"));

        tvProducts.setItems(list);
        System.out.println(list);

    }

    public Product ReplaceObj() {
        Product prod1 = new Product();
        prod1.setName(tdName.getText());
        prod1.setDescription(tfDescription.getText());
        prod1.setPrice(Integer.parseInt(tdPrice.getText()));
        prod1.setReview(Integer.parseInt(tdReview.getText()));
        prod1.setRef("aa");

        return prod1;
    }

    public Product ReplaceObj2() {
        Product prod1 = new Product();
        prod1.setId_product(Integer.parseInt(tdid.getText()));
        prod1.setName(tdName.getText());
        prod1.setDescription(tfDescription.getText());
        prod1.setPrice(Integer.parseInt(tdPrice.getText()));
        prod1.setReview(Integer.parseInt(tdReview.getText()));
        prod1.setRef("aa");

        return prod1;
    }
    
    public Product ReplaceObj3() {
        Product prod1 = new Product();
        prod1.setId_product(Integer.parseInt(tdid.getText()));
        prod1.setName("aa");
        prod1.setDescription("aa");
        prod1.setPrice(Integer.parseInt("44"));
        prod1.setReview(Integer.parseInt("5"));
        prod1.setRef("aa");

        return prod1;
    }

    public void insertObj() {
        p1.Add(ReplaceObj());
        showBooks();
    }

    public void updateobj() {
        p1.Update(ReplaceObj2());
        showBooks();
    }
    
    public void deleteobj() {
        System.out.println(ReplaceObj3());
        p1.Delete(ReplaceObj3());
        showBooks();
    }
    

    /*
    public ObservableList<Product> getProductList(){
        ObservableList<Product> ProductsList = FXCollections.observableArrayList();
        
        
        String req = "select * from product";
        List<Product> list = new ArrayList<>();

        try {
            statement = cnx.prepareStatement(req);
            rs = statement.executeQuery(req);
            while (rs.next()) {
                Product p = new Product();

                p.setId_product(rs.getInt(1));
                p.setRef(rs.getString("ref"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getInt(5));
                p.setReview(rs.getInt(6));
                p.setState(rs.getString("state"));
                p.setId_supplier(rs.getInt(8));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
        
        
    }*/
    @FXML
    void getPRoductNameclicked(MouseEvent event) {
        Button btn = (Button) event.getSource();
        //System.out.println(btn.getId());
        String productName = (String) btn.getUserData();
        System.out.println(productName);
    }

}
