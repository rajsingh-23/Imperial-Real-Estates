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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SaleCardController implements Initializable{
	private Stage stage;

    @FXML
    private ImageView pimage;

    @FXML
    private Label plocation;

    @FXML
    private Label pname;

    @FXML
    private Label pprice;

    @FXML
    private TextField priceTag;

    @FXML
    private Label psize;

    @FXML
    private Label ptype;
    
    @FXML
    private Label pid;

    @FXML
    private Label pstatus;
    
    @FXML
    private ChoiceBox<String> choice =new ChoiceBox<String>();
    
    String[] choices = {"Sale","Rent"}; 
    
    @FXML
    void removeFromSale(ActionEvent event) throws SQLException {
    	Connection conn = DB.connect();
    	String query = Query.removeFromSale;
    	PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, pid.getText());
			statement.executeUpdate();
    }

    @FXML
    void addForSale(ActionEvent event) throws SQLException {
    	
    	String query;
    	Connection conn = DB.connect();
    	if(choice.getValue().equals("Sale")) {
    		query = Query.changeStatuss;
    	}else {
    		query = Query.changeStatusr;
    	}
    
    	PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, priceTag.getText());
			statement.setString(2, pid.getText());
			statement.executeUpdate();
			
    }

	public void setData(Property p) {
		
		pimage.setImage(p.pImage);
		pname.setText(p.pName);
		ptype.setText(p.pType);
		plocation.setText(p.city);
		pprice.setText(p.pPrice);
		psize.setText(p.pSize);
		pid.setText(Integer.toString(p.pid));
		pstatus.setText(p.status);
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
	choice.getItems().addAll(choices);
	}


}
