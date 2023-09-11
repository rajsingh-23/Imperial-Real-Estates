package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SignUpController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	 @FXML
	private ImageView simage = new ImageView();

    @FXML
    private Button singUP;

    @FXML
    private TextArea uaddress;

    @FXML
    private TextField ucity;

    @FXML
    private TextField ucountry;

    @FXML
    private DatePicker udob;

    @FXML
    private TextField uemail;

    @FXML
    private TextField ugender;

    @FXML
    private TextField uid;

    @FXML
    private TextField uname;

    @FXML
    private PasswordField upassword;

    @FXML
    private TextField uphoneno;

    @FXML
    private TextField upincode;

    @FXML
    private TextField ustate;
    
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
    void chooseProfilePicture(ActionEvent event) throws FileNotFoundException {
    	FileChooser fileChooser = new FileChooser();
    	File selectedFile = fileChooser.showOpenDialog(stage);
    	fin = new FileInputStream(selectedFile);
    	Image i = new Image(fin);
    	simage.setImage(i);
    }

    @FXML
    void singUp(ActionEvent event) throws SQLException, IOException {
    	UserDao.addNewUser(sendUserData());
		openLogin(event);
    }
    
    private User sendUserData(){
    	User newUser = new User();
    	
    	newUser.dob = udob.getValue();
    	newUser.uAddress = uaddress.getText();
    	newUser.ucity = ucity.getText();
    	newUser.ucountry = ucountry.getText();
    	newUser.uEmail = uemail.getText();
    	newUser.uGender = ugender.getText();
    	newUser.uName = uname.getText();
    	newUser.uPassword = upassword.getText();
    	newUser.uPhoneNo = uphoneno.getText();
    	newUser.upincode = upincode.getText();
    	newUser.ustate = ustate.getText();
    	newUser.uProfilePic = fin;
    	

    	return newUser;
    }
  
    
    public void openLogin(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("login.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
//    	stage.setFullScreen(true);
    	stage.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		country.getItems().addAll(countries);
		state.getItems().addAll(indianStates);
		city.getItems().addAll(citiesInIndia);
	}

}