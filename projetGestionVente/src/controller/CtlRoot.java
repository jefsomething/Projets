package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class CtlRoot implements Initializable {
	
	@FXML
	private AnchorPane PRoot;
	
	@FXML
	private void product(MouseEvent event) {
		
	}
	
	
	private void loadUI(String ui) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((AnchorPane) PRoot).setCenter(root);
	}

	
	
	
	
	/*
	public void b_prod() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/PaneProduct.fxml"));
		VRoot.getChildren().set
		setAll(pane);
	}

*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}
