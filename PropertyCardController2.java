package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PropertyCardController2 {
	private Stage stage;
	private Scene scene;
	private Parent root;
	static int i=0;

    @FXML
    private CheckBox c1;

    @FXML
    private HBox hbox;

    @FXML
    private Button km;

    @FXML
    private Label pid;

    @FXML
    private ImageView pimage;

    @FXML
    private Label plocation;

    @FXML
    private Label pname;

    @FXML
    private Label pprice;

    @FXML
    private Label psize;

    @FXML
    private Label pstatus;

    @FXML
    private Label ptype;

    @FXML
    void changed(ActionEvent event) {
    	if(c1.isSelected()) {
    		if(i%2==0) {
    			compare c = compare.getInstance();
    			c.setP1(pid.getText());
    			i++;
    		}else {
    			compare c = compare.getInstance();
    			c.setP2(pid.getText());
    			i++;
    		}
    	}else {
    		
    	}
    }

    @FXML
    void knowMore(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader();
//		fxmlLoader.setLocation(getClass().getResource("compare.fxml"));
////		HBox hbox = fxmlLoader.load();
////		vbox.getChildren().add(hbox);
		root = FXMLLoader.load(getClass().getResource("compare.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		CompareController p = fxmlLoader.getController();
//		compare c = compare.getInstance();
//		p.setData(c.getP1(),c.getP2());
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.setFullScreen(true);
    	stage.show();
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
	
	

}
