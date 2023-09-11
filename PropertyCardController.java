package application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PropertyCardController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView pimage;
    
    @FXML
    private Label pid;

    @FXML
    private Label plocation;

    @FXML
    private Label pname;

    @FXML
    private Label pprice;

    @FXML
    private Label psize;

    @FXML
    private Label ptype;
    
    @FXML
    private Label pstatus;
    
    @FXML
    private Label uid;
    
    @FXML
    private ImageView wlimage;


    @FXML
    void knowMore(ActionEvent event) throws IOException, SQLException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("KM.fxml"));
    	Parent root = loader.load();
    	KMController c = loader.getController();
    	
    	Connection connection = DB.connect();
		String query= Query.showDetails;
		
		PreparedStatement statement;
		
		Property n = new Property();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, pid.getText());
			ResultSet resultSet;
			resultSet = statement.executeQuery();
//			System.out.println("query done");
			while(resultSet.next()) {
				n.pid = resultSet.getInt(1);
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
				n.pImage = i;
				n.pName = resultSet.getString(3);
				n.uid = resultSet.getInt(4);
				
				n.pType = resultSet.getString(5);
				n.status = resultSet.getString(6);
				n.pSize = resultSet.getString(7);
				n.pPrice = resultSet.getString(8);
				n.country = resultSet.getString(9);
				n.state = resultSet.getString(10);
				n.city = resultSet.getString(11);
				n.pincode = resultSet.getString(12);				
				n.location = resultSet.getString(20);
			}

			statement.close();
			connection.close();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	c.setData(n);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    @FXML
    void addtowishlist(ActionEvent event) throws SQLException {
    	File file = new File("C:\\Users\\rajsingh.s.PRODAPT\\Downloads\\heart (3).png");
    	Image i = new Image(file.toURI().toString());
    	wlimage.setImage(i);
    	Connection connection = DB.connect();
		String query= Query.addwish;
		
		PreparedStatement statement;
		data d = data.getInstance();
		
		
			statement = connection.prepareStatement(query);
			statement.setString(1, pid.getText());
			statement.setString(2, d.getUserID());
			statement.executeUpdate();
    }
    
	public void setData(Property p) throws IOException {

		pimage.setImage(p.pImage);
		pname.setText(p.pName);
		ptype.setText(p.pType);
		plocation.setText(p.city);
		pprice.setText(p.pPrice);
		psize.setText(p.pSize);
		pstatus.setText(p.status);
		pid.setText(Integer.toString(p.pid));
//		uid.setText(Integer.toString(p.uid));
		if(pstatus.getText().equals("SALE")) {
			
			pstatus.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		}else if(pstatus.getText().equals("OWNED")){
//			pstatus.setTextFill(Color.WHITE);
			pstatus.setBackground(new Background(new BackgroundFill(Color.LIME, CornerRadii.EMPTY, Insets.EMPTY)));
		}else {
			pstatus.setTextFill(Color.WHITE);
			pstatus.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}


