package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.crypto.Data;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class tController {
	
	 private Stage stage;
		private Scene scene;
		private Parent root;
	@FXML
	private TextField tid;
	
	   @FXML
	    private Label uemail;

	    @FXML
	    private Label uid;

	    @FXML
	    private ImageView uimage;

	    @FXML
	    private Label uname;

	    @FXML
	    private Label uphone;
	    
	    @FXML
	    private Label pid;
	    @FXML
	    private Label pprice;

	    @FXML
	    void addTenent(ActionEvent event) throws SQLException {
//	    	User user = new User();
			Connection conn = DB.connect();
			String query = Query.addtenent;
			
			rent r = rent.getInstance();
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, r.getPid());
			statement.setString(2,r.getPprice());
			statement.setString(3, tid.getText());
			statement.executeUpdate();
			
			statement = conn.prepareStatement(query);
			statement.setString(1, r.getPid());
			statement.setString(2, r.getPprice());
			data u = data.getInstance();
			statement.setString(3, u.getUserID());
			statement.executeUpdate();
			
//			Connection conn = DB.connect();
	    	query = Query.removeFromSale;
	    	statement = conn.prepareStatement(query);
				statement.setString(1, r.getPid());
				statement.executeUpdate();
	    }

    @FXML
    void fecthdata(ActionEvent event) throws SQLException {
    	User user = new User();
		Connection conn = DB.connect();
		String query = Query.getUser;
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, tid.getText());
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			uid.setText(tid.getText());
			uname.setText(resultSet.getString(2));
//			user.uPassword = resultSet.getString(3);
			uphone.setText(resultSet.getString(4));
			uemail.setText(resultSet.getString(5));
//			Date date = resultSet.getDate(6);
//			user.dob = date.toLocalDate();
//			user.ucountry = resultSet.getString(7);
//			user.ustate = resultSet.getString(8);
//			user.ucity = resultSet.getString(9);
//			user.upincode = resultSet.getString(10);
			Image i = new Image(resultSet.getBinaryStream(12));
			uimage.setImage(i);
			
		}
		statement.close();
		conn.close();
//		return user;
		
    }
    

    @FXML
    void openmenu(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//    	root = load.load();
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//    	PropertyController pc = load.getController();
    	
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.setMaximized(true);
    	stage.show();
    }

	

	public void setdata(String text, String text2) {
		// TODO Auto-generated method stub
		pid.setText(text);
		pprice.setText(text2);
	}
}