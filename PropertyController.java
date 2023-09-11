package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;

public class PropertyController implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private VBox vbox = new VBox();
	
//	@FXML
//	private VBox vbox2 = new VBox();
	
    @FXML
    private Pane pane1 = new Pane();

    @FXML
    private Pane pane2 = new Pane();

    @FXML
    private Pane pane3 = new Pane();
    @FXML
    private Pane pane4 = new Pane();
    
    
    FileInputStream fin;
   

    @FXML
    private TextField pcity;
    
    @FXML
    private Button cb;

    @FXML
    private Label pcity1;

    @FXML
    private TextField pcountry;

    @FXML
    private Label pcountry1;

    @FXML
    private Label pid;

    @FXML
    private ImageView pimage;

    @FXML
    private TextField pname;

    @FXML
    private Label pname1;

    @FXML
    private TextField ppincode;

    @FXML
    private Label ppincode1;

    @FXML
    private TextField pprice;

    @FXML
    private Label pprice1;

    @FXML
    private ImageView profilePic;

    @FXML
    private TextField psize;

    @FXML
    private Label psize1;

    @FXML
    private TextField pstate;

    @FXML
    private Label pstate1;

    @FXML
    private TextField pstatus;

    @FXML
    private TextField ptype;

    @FXML
    private Label ptype1;

    @FXML
    private Label topLabel;

    @FXML
    private Label uemail;

    @FXML
    private Label uid;

    @FXML
    private ImageView uimage;

    @FXML
    private Label uname;

    @FXML
    private Label uphoneNo;

    @FXML
    private Label userName;
    
    @FXML
    private TextField PC;
    
    @FXML
    private Button add = new Button();
    
    @FXML
    private Button check = new Button();

    @FXML
    private Button logout= new Button();

    @FXML
    private Button owned= new Button();
    
    @FXML
    private Button search= new Button();

    @FXML
    private Button sell= new Button();
    
    @FXML
    private Button p2c;

    @FXML
    private Button p2s;
    
    @FXML
    private Button at;
    
    @FXML
    private ImageView iimage;

    @FXML
    private Label iname;

    @FXML
    private Label ipid;

    @FXML
    private Label ipprice;
    
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
    

    @FXML
    private ImageView pimage1 = new ImageView();
    

    @FXML
    private ChoiceBox<String> type = new ChoiceBox<String>();
    @FXML
    private Slider range = new Slider();
    
    @FXML
    private Label Range = new Label();
    @FXML
    private ChoiceBox<String> bhk = new ChoiceBox<String>();
    
    String[] types = {"All","Villa","Flat","Plot"}; 
    
    String[] bhks = {"Any","1BHK","2BHK","3BHK","4BHK"};
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private Slider slider = new Slider();
    
    @FXML
    private VBox vbox1;
    
    @FXML
    private Label iemail;
    @FXML
    private Label iphone;
    
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #FFF; -fx-border-color:   #010829; -fx-border-radius:  0%;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;-fx-background-color: #03254c; -fx-border-color:   #010829; -fx-border-width: 3px;-fx-text-fill: white;";;
    @FXML
    void chooseAnImage(ActionEvent event) throws FileNotFoundException {
    	FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(stage);
		fin = new FileInputStream(selectedFile);
		Image i = new Image(fin);
		pimage1.setImage(i);
    }

    @FXML
    void saveToDatabase(ActionEvent event) throws SQLException {
    	if(check()) {
    		
    	}else {
    		
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
    	}
    }

    private boolean check() throws SQLException {
		Connection connection = DB.connect();
		String query = Query.getPC;

		PreparedStatement statement;
		statement = connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			if(rs.getString(1).equals(PC.getText())) {
				Alert a = new Alert(AlertType.WARNING);
				a.setTitle("property already exists");
				a.showAndWait();
				return true;
			}
		}
		return false;
	}
 
    
	@FXML
	void addNewProperty(ActionEvent event) throws IOException {
		pane2.toFront();
	}
	
	
	@FXML
	void searchProperty(ActionEvent event) throws IOException {
		pane1.toFront();
		scroll.setPrefWidth(800);
		search(event);
	}
	
    @FXML
    void searchbof(ActionEvent event) throws IOException {
    	
    	vbox.getChildren().clear();
    	Connection connection = DB.connect();
		String query= Query.searchType;
		
		PreparedStatement statement;
		
		
		
		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			statement.setString(1, holder.getUserID());
			statement.setString(2, type.getValue());
//			statement.setString(3, bhk.getValue());
//			statement.setString(4, Double.toString(value/100));
			
			ResultSet resultSet;
			resultSet = statement.executeQuery();	
			while(resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
				n.pImage = i;
				n.pName = resultSet.getString(3);
				n.pType = resultSet.getString(5);
				n.city = resultSet.getString(11);
				n.pPrice = resultSet.getString(8);
				n.pSize = resultSet.getString(7);
				n.status = resultSet.getString(6);
				n.pid = resultSet.getInt(1);
				n.uid = resultSet.getInt(4);
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("pcard.fxml"));
				HBox hbox = fxmlLoader.load();
				PropertyCardController p = fxmlLoader.getController();
				p.setData(n);
				
				vbox.getChildren().add(hbox);	
			}

			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    @FXML
    void openCompare(ActionEvent event) throws IOException {
    	pane1.toFront();
    	openc();
    }
    

   
    private void openc() throws IOException {
    	vbox.getChildren().clear();
    	Connection connection = DB.connect();
		String query= Query.searchProperty;
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			statement.setString(1, holder.getUserID());
			ResultSet resultSet;
			resultSet = statement.executeQuery();	
			while(resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
				n.pImage = i;
				n.pName = resultSet.getString(3);
				n.pType = resultSet.getString(5);
				n.city = resultSet.getString(11);
				n.pPrice = resultSet.getString(8);
				n.pSize = resultSet.getString(7);
				n.status = resultSet.getString(6);
				n.pid = resultSet.getInt(1);
				n.uid = resultSet.getInt(4);
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("pcard2.fxml"));
				HBox hbox = fxmlLoader.load();
				PropertyCardController2 p = fxmlLoader.getController();
				p.setData(n);
				vbox.getChildren().add(hbox);	
			}

			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	void search(ActionEvent event) throws IOException {
    	
    	
    	
    	vbox.getChildren().clear();
    	Connection connection = DB.connect();
		String query= Query.searchProperty;
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			statement.setString(1, holder.getUserID());
			ResultSet resultSet;
			resultSet = statement.executeQuery();	
			while(resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
				n.pImage = i;
				n.pName = resultSet.getString(3);
				n.pType = resultSet.getString(5);
				n.city = resultSet.getString(11);
				n.pPrice = resultSet.getString(8);
				n.pSize = resultSet.getString(7);
				n.status = resultSet.getString(6);
				n.pid = resultSet.getInt(1);
				n.uid = resultSet.getInt(4);
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("pcard.fxml"));
				HBox hbox = fxmlLoader.load();
				PropertyCardController p = fxmlLoader.getController();
				p.setData(n);
				vbox.getChildren().add(hbox);	
			}

			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    @FXML
    void showOwnerProperty(ActionEvent event) throws IOException {
    	pane1.toFront();
//    	range.setVisible(true);
    	
    	scroll.setPrefWidth(800);
    	show(event);
    }
    
    void show(ActionEvent event) throws IOException {
    	
//    	pane1.toFront();
    	
    	vbox.getChildren().clear();
		Connection connection = DB.connect();
		String query = Query.ownedProperty;

		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			String u = holder.getUserID();
			statement.setString(1, u);
			ResultSet resultSet;
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
				n.pImage = i;
				n.pName = resultSet.getString(3);
				n.pType = resultSet.getString(5);
				n.city = resultSet.getString(11);
				n.pPrice = resultSet.getString(8);
				n.pSize = resultSet.getString(7);
				n.status = resultSet.getString(6);
				n.pid = resultSet.getInt(1);
				n.uid = resultSet.getInt(4);
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("pcard.fxml"));
				HBox hbox = fxmlLoader.load();
				PropertyCardController p = fxmlLoader.getController();
				p.setData(n);
				vbox.getChildren().add(hbox);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

    }    
    
    @FXML
    void addPropertyToSale(ActionEvent event) throws IOException {
    	pane1.toFront();
    	PropertyToSale(event);
    }


    @FXML
    void PropertyToSale(ActionEvent event) throws IOException {
    	
    	vbox.getChildren().clear();
		Connection connection = DB.connect();
		String query = Query.ownedProperty;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			String u = holder.getUserID();
			statement.setString(1, u);
			ResultSet resultSet;
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
				n.pImage = i;
				n.pName = resultSet.getString(3);
				n.pType = resultSet.getString(5);
				n.city = resultSet.getString(11);
				n.pPrice = resultSet.getString(8);
				n.pSize = resultSet.getString(7);
				n.pid = resultSet.getInt(1);
				n.status = resultSet.getString(6);
				n.uid = resultSet.getInt(4);
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("SaleCard.fxml"));
				HBox hbox = fxmlLoader.load();
				SaleCardController p = fxmlLoader.getController();
				p.setData(n);
				
				vbox.getChildren().add(hbox);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

    }

	@FXML
	void checkInterestedPeople(ActionEvent event) throws IOException, SQLException {
		pane1.toFront();
		notification(event);
	}
	
	private void notification(ActionEvent event) throws IOException, SQLException {		
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("noti.fxml"));
		HBox hbox = fxmlLoader.load();
		NotiController p = fxmlLoader.getController();
		p.setData(90537,60311);
		vbox.getChildren().add(hbox);
		
	}

	@FXML
    void logout(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("home.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
	
	@FXML
    void soRentedProperties(ActionEvent event) throws IOException {
		pane1.toFront();
		showrent();
    }
	void showrent() throws IOException {
		vbox.getChildren().clear();
		Connection connection = DB.connect();
		String query = Query.ownedPropertyR;

		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			String u = holder.getUserID();
			statement.setString(1, u);
			ResultSet resultSet;
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
				n.pImage = i;
				n.pName = resultSet.getString(3);
				n.pType = resultSet.getString(5);
				n.city = resultSet.getString(11);
				n.pPrice = resultSet.getString(8);
				n.pSize = resultSet.getString(7);
				n.status = resultSet.getString(6);
				n.pid = resultSet.getInt(1);
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("rcard2.fxml"));
				HBox hbox = fxmlLoader.load();
				rcardController p = fxmlLoader.getController();
				p.setData(n);
				vbox.getChildren().add(hbox);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
    @FXML
    void openProfile(ActionEvent event) throws IOException {
    	pane4.toFront();
    	open();
    }
    void open() throws IOException {
    	data uu = data.getInstance();
    	Image ii = new Image(uu.getProfilePicture());
    	iimage.setImage(profilePic.getImage());
    	iname.setText(uu.getUser());
    	ipid.setText(uu.getUserID());
    	rent r = rent.getInstance();
    	ipprice.setText(r.getPprice());
    	
    	vbox1.getChildren().clear();
		Connection connection = DB.connect();
		String query = Query.wishlist;

		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			String u = holder.getUserID();
			statement.setString(1, u);
			ResultSet resultSet;
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				query  = Query.showDetails;
				statement = connection.prepareStatement(query);
				statement.setString(1, Integer.toString(resultSet.getInt(1)));
				ResultSet resultSet1;
				resultSet1 = statement.executeQuery();
				while(resultSet1.next()) {
					
					Property n = new Property();
					InputStream is =  resultSet1.getBinaryStream(2);
					Image i = new Image(is);
					n.pImage = i;
					n.pName = resultSet1.getString(3);
					n.pType = resultSet1.getString(5);
					n.city = resultSet1.getString(11);
					n.pPrice = resultSet1.getString(8);
					n.pSize = resultSet1.getString(7);
					n.status = resultSet1.getString(6);
					n.pid = resultSet1.getInt(1);
//					n.uid = resultSet1.getInt(4);
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("pcard.fxml"));
					HBox hbox = fxmlLoader.load();
					PropertyCardController p = fxmlLoader.getController();
					p.setData(n);
					vbox1.getChildren().add(hbox);
				}
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

    }
	int value;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		country.getItems().addAll(countries);
		state.getItems().addAll(indianStates);
		city.getItems().addAll(citiesInIndia);
		type.getItems().addAll(types);
		bhk.getItems().addAll(bhks);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				float v = ((float)slider.getValue()) * 100;
				value = (int)v;
				Range.setText((Integer.toString(value)));
			}
		});
		
		data user = data.getInstance();
		Image i = new Image(user.getProfilePicture());
		profilePic.setImage(i);
		topLabel.setText("Welcome back !");
		userName.setText(user.getUser());
		String c = user.getUserID();
//		if(c.equals("60314")){
//			add.setVisible(true);
//    	}else {
//    		add.setVisible(false);
//    	}
		add.setStyle(IDLE_BUTTON_STYLE);
        add.setOnMouseEntered(e -> add.setStyle(HOVERED_BUTTON_STYLE));
        add.setOnMouseExited(e -> add.setStyle(IDLE_BUTTON_STYLE));
        sell.setStyle(IDLE_BUTTON_STYLE);
        sell.setOnMouseEntered(e -> sell.setStyle(HOVERED_BUTTON_STYLE));
        sell.setOnMouseExited(e -> sell.setStyle(IDLE_BUTTON_STYLE));
        search.setStyle(IDLE_BUTTON_STYLE);
        search.setOnMouseEntered(e -> search.setStyle(HOVERED_BUTTON_STYLE));
        search.setOnMouseExited(e -> search.setStyle(IDLE_BUTTON_STYLE));
        check.setStyle(IDLE_BUTTON_STYLE);
        check.setOnMouseEntered(e -> check.setStyle(HOVERED_BUTTON_STYLE));
        check.setOnMouseExited(e -> check.setStyle(IDLE_BUTTON_STYLE));
        logout.setStyle(IDLE_BUTTON_STYLE);
        logout.setOnMouseEntered(e -> logout.setStyle(HOVERED_BUTTON_STYLE));
        logout.setOnMouseExited(e -> logout.setStyle(IDLE_BUTTON_STYLE));
        owned.setStyle(IDLE_BUTTON_STYLE);
        owned.setOnMouseEntered(e -> owned.setStyle(HOVERED_BUTTON_STYLE));
        owned.setOnMouseExited(e -> owned.setStyle(IDLE_BUTTON_STYLE));
        p2s.setStyle(IDLE_BUTTON_STYLE);
        p2s.setOnMouseEntered(e -> p2s.setStyle(HOVERED_BUTTON_STYLE));
        p2s.setOnMouseExited(e -> p2s.setStyle(IDLE_BUTTON_STYLE));
        p2c.setStyle(IDLE_BUTTON_STYLE);
        p2c.setOnMouseEntered(e -> p2c.setStyle(HOVERED_BUTTON_STYLE));
        p2c.setOnMouseExited(e -> p2c.setStyle(IDLE_BUTTON_STYLE));
        at.setStyle(IDLE_BUTTON_STYLE);
        at.setOnMouseEntered(e -> at.setStyle(HOVERED_BUTTON_STYLE));
        at.setOnMouseExited(e -> at.setStyle(IDLE_BUTTON_STYLE));
        cb.setStyle(IDLE_BUTTON_STYLE);
        cb.setOnMouseEntered(e -> cb.setStyle(HOVERED_BUTTON_STYLE));
        cb.setOnMouseExited(e -> cb.setStyle(IDLE_BUTTON_STYLE));
	}

}
