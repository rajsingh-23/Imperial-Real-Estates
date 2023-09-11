package application;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class NotiController {

	    @FXML
	    private Label cid;
	    @FXML
	    private Label pid;

	    @FXML
	    void openChat(ActionEvent event) throws NumberFormatException, SQLException, IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
	    	Parent root = loader.load();
//	    	ChatController c = loader.getController();
	    	
//	    	User user = UserDao.details(Integer.parseInt(cid.getText()));
//	    	Property property = new Property();
//	    	property.pid = Integer.parseInt(pid.getText());
////	    	property.pImage = pimage.getImage();
////	    	property.pName = pname.getText();
////	    	c.setDatan(cid.getText(),pid.getText());
//	    	c.setDatap(cid.getText());
	    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	Scene scene = new Scene(root);
	    	stage.setScene(scene);
	    	stage.show();
	    }

	

	public void setData(int int1, int int2) {
		// TODO Auto-generated method stub
		cid.setText(Integer.toString(int2));
		pid.setText(Integer.toString(int1));
	}


}
