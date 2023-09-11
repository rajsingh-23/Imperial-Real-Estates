package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PRegisteryController  implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	

    @FXML
    private TextField PC;

	@FXML
	private TextField pcity;

	@FXML
	private TextField pcountry;

	@FXML
	private TextField pname;

	@FXML
	private TextField ppincode;

	@FXML
	private TextField pprice;

	@FXML
	private TextField psize;

	@FXML
	private TextField pstate;

	@FXML
	private TextField pstatus;

	@FXML
	private TextField ptype;
	
	@FXML
    private ImageView pimage = new ImageView();
	
	   @FXML
	    private ChoiceBox<String> country;
	    
	    @FXML
	    private ChoiceBox<String> state;
	    
	    @FXML
	    private ChoiceBox<String> city;
	    
	    String[] countries = {"India", "United States", "Canada", "United Kingdom", "Australia", "Germany", "France", "Japan", "Brazil", "China"};
	    
	    String[] indianStates = {

	    	    "Andhra Pradesh",

	    	    "Arunachal Pradesh",

	    	    "Assam",

	    	    "Bihar",

	    	    "Chhattisgarh",

	    	    "Goa",

	    	    "Gujarat",

	    	    "Haryana",

	    	    "Himachal Pradesh",

	    	    "Jharkhand",

	    	    "Karnataka",

	    	    "Kerala",

	    	    "Madhya Pradesh",

	    	    "Maharashtra",

	    	    "Manipur",

	    	    "Meghalaya",

	    	    "Mizoram",

	    	    "Nagaland",

	    	    "Odisha",

	    	    "Punjab",

	    	    "Rajasthan",

	    	    "Sikkim",

	    	    "Tamil Nadu",

	    	    "Telangana",

	    	    "Tripura",

	    	    "Uttar Pradesh",

	    	    "Uttarakhand",

	    	    "West Bengal"

	    	};
	    

	    String[] citiesInIndia = {

	        "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Chennai", // Maharashtra, Delhi, Karnataka, Telangana, Tamil Nadu

	        "Kolkata", "Jaipur", "Lucknow", "Patna", "Bhubaneswar", // West Bengal, Rajasthan, Uttar Pradesh, Bihar, Odisha

	        "Ahmedabad", "Pune", "Surat", "Vadodara", "Rajkot", // Gujarat, Maharashtra

	        "Chandigarh", "Amritsar", "Ludhiana", "Jalandhar", "Mohali", // Punjab

	        "Thiruvananthapuram", "Kochi", "Kozhikode", "Kollam", "Palakkad", // Kerala

	        "Srinagar", "Jammu", "Anantnag", "Baramulla", "Udhampur", // Jammu and Kashmir

	        "Guwahati", "Dispur", "Jorhat", "Silchar", "Dibrugarh", // Assam

	        "Bhopal", "Indore", "Gwalior", "Jabalpur", "Ujjain" // Madhya Pradesh

	        // Add more cities and states as needed

	    };

	FileInputStream fin;

	@FXML
	void chooseAnImage(ActionEvent event) throws FileNotFoundException {
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(stage);
		fin = new FileInputStream(selectedFile);
		Image i = new Image(fin);
		pimage.setImage(i);
	}

	@FXML
	void saveToDatabase(ActionEvent event) throws IOException, SQLException {
		check();
		Connection connection = DB.connect();
		String query = Query.insertProperty;

		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(query);
			data user = data.getInstance();

			statement.setBinaryStream(1, fin);
			statement.setString(2, pname.getText());
			statement.setString(3, user.getUserID());
			statement.setString(4, ptype.getText());
			statement.setString(5, pstatus.getText());
			statement.setString(6, psize.getText());
			statement.setString(7, pprice.getText());
			statement.setString(8, pcountry.getText());
			statement.setString(9, pstate.getText());
			statement.setString(10, pcity.getText());
			statement.setString(11, ppincode.getText());
			statement.setString(12, PC.getText());
			
			statement.executeUpdate();
			statement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
	}

	private void check() throws SQLException {
		Connection connection = DB.connect();
		String query = Query.getPC;

		PreparedStatement statement;
		statement = connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			if(rs.getString(1) == PC.getText()) {
				Alert a = new Alert(AlertType.WARNING);
				a.showAndWait();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		country.getItems().addAll(countries);
		state.getItems().addAll(indianStates);
		city.getItems().addAll(citiesInIndia);
		
	}


}
