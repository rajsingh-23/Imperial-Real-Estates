package application;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CompareController implements Initializable{

	@FXML
    private Label bhk1;

    @FXML
    private Label bhk11;

    @FXML
    private Label c1;

    @FXML
    private Label c11;

    @FXML
    private Label n1;

    @FXML
    private Label n11;

    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private Label pc1;

    @FXML
    private Label pc11;

    @FXML
    private Label pp1;

    @FXML
    private Label pp11;

    @FXML
    private Label r1;

    @FXML
    private Label r11;

    @FXML
    private Label s1;

    @FXML
    private Label s11;

//    = new Label();

    private Stage stage;
   	private Scene scene;
   	private Parent root;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		compare c = compare.getInstance();
		// TODO Auto-generated method stub
		Connection connection = DB.connect();
		String query = Query.showDetails;

		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			String u = holder.getUserID();
			statement.setString(1, c.getP1());
			ResultSet resultSet;
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
			p1.setImage(i);
			n1.setText(resultSet.getString(3));
			s1.setText(resultSet.getString(7));
			r1.setText(resultSet.getString(19)+"⭐");
			bhk1.setText(resultSet.getString(18));
			pp1.setText(resultSet.getString(8));
			c1.setText(resultSet.getString(11)+" "+resultSet.getString(12));
			pc1.setText(resultSet.getString(16));
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		connection = DB.connect();
		query = Query.showDetails;


		try {
			statement = connection.prepareStatement(query);
			data holder = data.getInstance();
			String u = holder.getUserID();
			statement.setString(1, c.getP2());
			ResultSet resultSet;
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Property n = new Property();
				InputStream is =  resultSet.getBinaryStream(2);
				Image i = new Image(is);
			p2.setImage(i);
			n11.setText(resultSet.getString(3));
			s11.setText(resultSet.getString(7));
			r11.setText(resultSet.getString(19)+"⭐");
			bhk11.setText(resultSet.getString(18));
			pp11.setText(resultSet.getString(8));	
			c11.setText(resultSet.getString(11)+" "+resultSet.getString(12));
			pc11.setText(resultSet.getString(16));
				
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
    @FXML
    void openMenu(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//    	root = load.load();
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//    	PropertyController pc = load.getController();
    	
    	scene = new Scene(root);
    	stage.setScene(scene);
//    	stage.setMaximized(true);
    	stage.show();
    }

}
