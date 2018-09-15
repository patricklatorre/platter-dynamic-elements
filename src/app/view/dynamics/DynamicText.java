package app.view.dynamics;

import java.net.URL;
import java.util.ResourceBundle;

import app.service.platter.model.GenericController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DynamicText extends GenericController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private GridPane row;

	@FXML
	private Label rowStr;

	@FXML
	void initialize() {
		assert row != null : "fx:id=\"row\" was not injected: check your FXML file 'dynamicText.fxml'.";
		assert rowStr != null : "fx:id=\"rowStr\" was not injected: check your FXML file 'dynamicText.fxml'.";

	}

	// Setters and Getters
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

	public GridPane getRow() {
		return row;
	}

	public void setRow(GridPane row) {
		this.row = row;
	}

	public Label getRowStr() {
		return rowStr;
	}

	public void setRowStr(Label rowStr) {
		this.rowStr = rowStr;
	}
}
