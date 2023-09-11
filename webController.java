package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class webController  implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private WebView wv;
    
    @FXML
    private WebEngine e;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		e = wv.getEngine();
		loadpage();
	}
	
	   @FXML
	    void openmenu(ActionEvent event) throws IOException {
		   root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//	    	root = load.load();
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//	    	PropertyController pc = load.getController();
	    	
	    	scene = new Scene(root);
	    	stage.setScene(scene);
	    	stage.setMaximized(true);
	    	stage.show();
	    }

	private void loadpage() {
		// TODO Auto-generated method stub
		e.load("https://www.google.com");
	}
	

}
