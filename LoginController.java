package application;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private PasswordField fpassword;

    @FXML
    private TextField fuserid;

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
    	   	
    	int count = UserDao.AuthenticateUser(fpassword.getText(),fuserid.getText());
    	if(count==1) {
			openMenu(event);
		}else {
			System.out.println("error in result set count");
		}	
    	
    }
    
    public void openMenu(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//    	root = load.load();
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//    	PropertyController pc = load.getController();
    	
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.setMaximized(true);
    	stage.show();
    }

}