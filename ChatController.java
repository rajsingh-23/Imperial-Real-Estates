package application;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.GroupLayout.Alignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatController implements Initializable{

    @FXML
    private Label cid;

    @FXML
    private ImageView cimage;

    @FXML
    private Label cname;

    @FXML
    private TextField message;

    @FXML
    private Label pid;

    @FXML
    private ImageView pimage;

    @FXML
    private Label pname;


    @FXML
    private Label uid;

    @FXML
    private ImageView uimage;

    @FXML
    private Label uname;
    
    private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private VBox vbox;
    static int i=0;
    int messID=0;

    @FXML
    void sendMessage(ActionEvent event) throws SQLException, IOException {
    	
    	
    	FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("Message.fxml"));
		HBox hbox = fxmlLoader.load();
		
		MessageController p = fxmlLoader.getController();
		if(i%2==0) {
			p.setData(message.getText(),1);
//			hbox.setBackground(new Background(new BackgroundFill(Color.GREY,null,null)));
			hbox.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, null , null)));
		}else {
			p.setData(message.getText(), 0);
//			hbox.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN,null,null)));
			hbox.setBorder(new Border(new BorderStroke(Color.LIMEGREEN, BorderStrokeStyle.SOLID, null , null)));
		}
		i++;
		
		vbox.getChildren().add(hbox);
		
//		if(cid.getText() == "Label") {
//			sendm();
//		}
		
		Connection con = DB.connect();
//		String query = Query.createTable;
		PreparedStatement ps ;
//		= con.prepareStatement(query);
//		ps.setString(1, uid.getText());
//		ps.executeUpdate();
		String query = Query.insertmessage;
		ps = con.prepareStatement(query);
//		ps.setString(, cid.getText());
//		System.out.println(cid.getText());
		ps.setString(1, message.getText());
//		ps.setString(2, cid.getText());
		ps.executeUpdate();
//		query = Query.insertn;
//		ps=con.prepareStatement(query);
//		ps.setString(1, message.getText());
//		ps.setString(2, uid.getText());
//		ps.executeUpdate();
    	
    }

//    private void sendm() throws SQLException {
//		// TODO Auto-generated method stub
//    	Connection con = DB.connect();
////		String query = Query.createTable;
//		PreparedStatement ps ;
////		= con.prepareStatement(query);
////		ps.setString(1, uid.getText());
////		ps.executeUpdate();
//		String query = Query.insertmessage;
//		ps = con.prepareStatement(query);
////		ps.setString(, cid.getText());
////		System.out.println(cid.getText());
//		ps.setString(1, message.getText());
////		ps.setString(2, cid.getText());
//		ps.executeUpdate();
////		query = Query.insertn;
////		ps=con.prepareStatement(query);
////		ps.setString(1, message.getText());
////		ps.setString(2, uid.getText());
////		ps.executeUpdate();
//	}

	void setData(User u, Property p) {
    	uid.setText(Integer.toString(u.uId));
    	Image image = new Image(u.uProfilePic);
    	uimage.setImage(image);
    	uname.setText(u.uName);
//    	pid.setText(Integer.toString(p.pid));
//    	image = p.pImage;
//    	pimage.setImage(image);
//    	pname.setText(p.pName);
    	data c = data.getInstance();
    	cid.setText(c.getUserID());
    	Image i = new Image(c.getProfilePicture());
    	cimage.setImage(i);
    	cname.setText(c.getUser());
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
////		System.out.println("in here da..........dhdhvbnjsk");
		Connection conn = DB.connect();
    	String query = Query.getmessage;
    	PreparedStatement statement;
    	try {
			statement = conn.prepareStatement(query);
//			statement.setString(1, Integer.toString(messID));
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("Message.fxml"));
				HBox hbox = fxmlLoader.load();
				MessageController p = fxmlLoader.getController();
				if(i%2==0) {
					p.setData(resultSet.getString(2),1);
//					hbox.setBackground(new Background(new BackgroundFill(Color.GREY,null,null)));
					hbox.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, null , null)));
				}else {
					p.setData(resultSet.getString(2),0);
//					hbox.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN,null,null)));
					hbox.setBorder(new Border(new BorderStroke(Color.LIMEGREEN, BorderStrokeStyle.SOLID, null , null)));
				}
				i++;
//				hbox.setAlignment(Alignment.TRAILING);
				vbox.getChildren().add(hbox);
//				System.out.println("in here da..........dhdhvbnjsk");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
    void openmenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//    	root = load.load();
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//    	PropertyController pc = load.getController();
    	
    	scene = new Scene(root);
    	stage.setScene(scene);
//    	stage.setMaximized(true);
    	stage.show();
    }

	public void setDatap(String text) {
		uid.setText(text);
		
	}


}
