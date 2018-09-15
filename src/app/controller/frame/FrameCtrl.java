package app.controller.frame;

import app.service.platter.model.GenericController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FrameCtrl extends GenericController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BorderPane frame;

	@FXML
	private TextField inputField;

	@FXML
	private Button listNav;

	@FXML
	private Button movingTargetNav;

	@FXML
	private ScrollPane footer;

	@FXML
	void initialize() {
		assert frame != null : "fx:id=\"frame\" was not injected: check your FXML file 'frame.fxml'.";
		assert inputField != null : "fx:id=\"inputField\" was not injected: check your FXML file 'frame.fxml'.";

	}

	public void show(Parent layout) {
		frame.setCenter(layout);
	}


	// Getters and Setters

	public ResourceBundle getResources() {
		return resources;
	}

	public void setResources(ResourceBundle resources) {
		this.resources = resources;
	}

	public URL getLocation() {
		return location;
	}

	public void setLocation(URL location) {
		this.location = location;
	}

	public BorderPane getFrame() {
		return frame;
	}

	public void setFrame(BorderPane frame) {
		this.frame = frame;
	}

	public TextField getInputField() {
		return inputField;
	}

	public void setInputField(TextField inputField) {
		this.inputField = inputField;
	}

	public Button getListNav() {
		return listNav;
	}

	public void setListNav(Button listNav) {
		this.listNav = listNav;
	}

	public Button getMovingTargetNav() {
		return movingTargetNav;
	}

	public void setMovingTargetNav(Button movingTargetNav) {
		this.movingTargetNav = movingTargetNav;
	}

	public ScrollPane getFooter() {
		return footer;
	}

	public void setFooter(ScrollPane footer) {
		this.footer = footer;
	}
}
