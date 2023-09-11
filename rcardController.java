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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class rcardController {

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
    private Stage stage;
	private Scene scene;
	private Parent root;
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
			pstatus.setTextFill(Color.WHITE);
			pstatus.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		}else {
			pstatus.setTextFill(Color.WHITE);
			pstatus.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
	
	

    @FXML
    void addTenent(ActionEvent event) throws IOException {
//    	FXMLLoader fxmlLoader = new FXMLLoader();
    	root = FXMLLoader.load(getClass().getResource("tenent.fxml"));
//    	root = load.load();
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//    	tController pc = fxmlLoader.getController();
//    	pc.setdata(pid.getText(),pprice.getText());
    	rent r = rent.getInstance();
    	r.setPid(pid.getText());
    	r.setPprice(pprice.getText());
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.setMaximized(true);
    	stage.show();
    }

}
