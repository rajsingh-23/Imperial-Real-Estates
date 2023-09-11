package application;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.text.TextAlignment;

public class MessageController {

    @FXML
    private Label m;
    
    public void setData(String s, int n) {
    	m.setText(s);
    	if(n==1) {
    		
    		m.setAlignment(Pos.CENTER_LEFT);
    	}else {
    		m.setAlignment(Pos.CENTER_RIGHT);
    		
//    		m.setTextAlignment(TextAlignment.RIGHT);
   	}
    }

}