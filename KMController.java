package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KMController implements Initializable {
	
	private Stage stage;

    @FXML
    private Label pcity;

    @FXML
    private Label pcountry;

    @FXML
    private Label pid;

    @FXML
    private ImageView pimage;

    @FXML
    private Label pname;

    @FXML
    private Label ppincode;

    @FXML
    private Label pprice;

    @FXML
    private Label psize;

    @FXML
    private Label pstate;

    @FXML
    private Label pstatus;

    @FXML
    private Label ptype;

    @FXML
    private Label uemail;

    @FXML
    private Label uid;

    @FXML
    private ImageView uimage;

    @FXML
    private Label uname;

    @FXML
    private Label uphoneNo;
    
    @FXML
    private Button rb;
    @FXML
    private Button plb;
    @FXML
    private Button pab;
    @FXML
    private MediaView video;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    
    @FXML
    private WebView wv;
    
    @FXML
    private WebEngine e;
    
//    private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private ImageView pimage1;

    @FXML
    private ImageView pimage2;
    
    int show=0;
//    public void ta(double d,Node n,double w) {
//    	TranslateTransition tt = new TranslateTransition(Duration.seconds(d), n);
//    	tt.setByX(w);
//    	tt.play();
//    }
    @FXML
    void back(ActionEvent event) {
    	if(show==1) {
    		pimage.toFront();
//    		ta(0.5,pimage,150);
    		show--;
    	}else if(show==2) {
    		pimage1.toFront();
//    		ta(0.5,pimage1,150);
    		show--;
    	}
    }


    @FXML
    void next(ActionEvent event) {
    	if(show==0) {
    		pimage1.toFront();
//    		ta(0.5,pimage1,-150);
    		show++;
    	}else if(show==1) {
    		pimage2.toFront();
//    		ta(0.5,pimage2,-150);
    		show++;
    	}
    }


	public void setData(Property n) throws SQLException {
		User user = UserDao.details(n.uid);
		pimage.setImage(n.pImage);
		pname.setText(n.pName);
		pcity.setText(n.city);
		pcountry.setText(n.country);
		pid.setText(Integer.toString(n.pid));
		ppincode.setText(n.pincode);
		pprice.setText(n.pPrice);
		psize.setText(n.pSize);
		pstate.setText(n.state);
		ptype.setText(n.pType);
		pstatus.setText(n.status);
		Image image = new Image(user.uProfilePic);
		uimage.setImage(image);
		uname.setText(user.uName);
		uid.setText(Integer.toString(user.uId));
		uemail.setText(user.uEmail);
		uphoneNo.setText(user.uPhoneNo);
		
//		Connection connection = DB.connect();
//		String query= Query.showDetails;
//		
//		PreparedStatement statement;
//		data d = data.getInstance();
//		
//		
//			try {
//				statement = connection.prepareStatement(query);
//				statement.setString(1, pid.getText());
////				statement.setString(2, d.getUserID());
//				ResultSet rs = statement.executeQuery();
//				while(rs.next()) {
//					Image i = new Image(rs.getBinaryStream(21));
//					pimage1.setImage(i);
//					Image ii = new Image(rs.getBinaryStream(22));
//					pimage2.setImage(ii);
//				}
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		
		wv = new WebView();
		   
        WebEngine e = wv.getEngine();
//        e.load(n.location);
        loadpage(n.location);
      
	}
	
	public void chat(ActionEvent event) throws IOException, NumberFormatException, SQLException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
    	Parent root = loader.load();
    	ChatController c = loader.getController();
    	
    	User user = UserDao.details(Integer.parseInt(uid.getText()));
    	Property property = new Property();
//    	System.out.println(pid.getText());
//    	property.pid = Integer.valueOf(pid.getText());
//    	property.pImage = pimage.getImage();
//    	property.pName = pname.getText();
    	c.setData(user,property);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
	}

	@FXML
    void openweb(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("web.fxml"));
    	Parent root = loader.load();        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setMaximized(true);
    	stage.show();
    }
	
	 @FXML
	    void openMenu(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//	    	root = load.load();
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//	    	PropertyController pc = load.getController();
	    	
	    	scene = new Scene(root);
	    	stage.setScene(scene);
//	    	stage.setMaximized(true);
	    	stage.show();
	    }
	    
	
	    

	    @FXML
	    void pause(ActionEvent event) {
	    	mediaPlayer.pause();
	    }

	    @FXML
	    void play(ActionEvent event) {
	    	mediaPlayer.play();
	    }

	    @FXML
	    void reset(ActionEvent event) {
	    	if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
	    		
	    		mediaPlayer.seek(Duration.seconds(0.0));
	    	}
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		e = wv.getEngine();
		wv.setZoom(0.5);
		file = new File("C:\\Users\\rajsingh.s.PRODAPT\\Downloads\\66434068_381740832695705_4774911186745425920_n.mp4");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		video.setMediaPlayer(mediaPlayer);
		
//		Connection connection = DB.connect();
//		String query= Query.showDetails;
//		
//		PreparedStatement statement;
//		data d = data.getInstance();
//		
//		
//			try {
//				statement = connection.prepareStatement(query);
//				statement.setString(1, pid.getText());
////				statement.setString(2, d.getUserID());
//				ResultSet rs = statement.executeQuery();
//				while(rs.next()) {
//					Image i = new Image(rs.getBinaryStream(21));
//					pimage1.setImage(i);
//					Image ii = new Image(rs.getBinaryStream(22));
//					pimage2.setImage(ii);
//				}
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		loadpage();
	}

	private void loadpage(String s) {
		// TODO Auto-generated method stub
		wv.setZoom(0.5);
		e.load(s);
//		wv.setZoom(0.3);
	}



}
