package view;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import dao.DistinctDAO;
import dao.RestaurantDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Address;
import model.Restaurant;
import model._id;

public class RestaurantController implements Initializable{

    @FXML
    private TableView<Restaurant> tblRestaurant;

    @FXML
    private TableColumn<Restaurant, String> colID;

    @FXML
    private TableColumn<Restaurant, String> colName;

    @FXML
    private TableColumn<Restaurant, String> colCuisine;

    @FXML
    private TableColumn<Restaurant, Address> colAddress;
    
    @FXML
    private TableColumn<Restaurant, String> colBorough;
    
    @FXML
    private ComboBox<String> cbBorough;
    
    @FXML
    private ComboBox<String> cbCuisine;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtLimit;

    @FXML
    void executeSearch(ActionEvent event) {
    	
    	String borough = cbBorough.getValue();
    	String cuisine = cbCuisine.getValue();
    	String limit = txtLimit.getText();
    	
    	
    	Map<String,Object> mapQuery = new HashMap<>();
		mapQuery.put("cuisine", cuisine);
		mapQuery.put("borough", borough);
		mapQuery.put("limit",limit);
    	
		RestaurantDAO dao = new RestaurantDAO();
    	List<Restaurant> list = dao.findBy(mapQuery);
    	

    	ObservableList<Restaurant> data = FXCollections.observableArrayList(list);
    	tblRestaurant.setItems(data);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Map<String, String> mapDB = new HashMap<>();
		mapDB.put("uri", "mongodb://eqian17:password1029@cluster0-shard-00-00.1jdg9.mongodb.net:27017,cluster0-shard-00-01.1jdg9.mongodb.net:27017,cluster0-shard-00-02.1jdg9.mongodb.net:27017/sample_restaurants?ssl=true&replicaSet=atlas-9ozhs4-shard-0&authSource=admin&retryWrites=true&w=majority");
		mapDB.put("db", "sample_restaurants");
		mapDB.put("col", "restaurants");
		
		cbBorough.getItems().add("All");
		cbCuisine.getItems().add("All");
		DistinctDAO.distinct(mapDB, "borough", String.class)
		.forEach(cbBorough.getItems()::addAll);
		DistinctDAO.distinct(mapDB, "cuisine", String.class)
		.forEach(cbCuisine.getItems()::addAll);
		cbBorough.setValue("Choose a Borough");
		cbCuisine.setValue("Choose a Cuisine");
		
	}

}
