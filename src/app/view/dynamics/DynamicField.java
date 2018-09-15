package app.view.dynamics;

import java.net.URL;
import java.util.ResourceBundle;

import app.service.platter.model.GenericController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DynamicField extends GenericController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private GridPane row;

	@FXML
	private TextField textField;

	@FXML
	void initialize() {
		assert row != null : "fx:id=\"row\" was not injected: check your FXML file 'dynamicField.fxml'.";
		assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'dynamicField.fxml'.";
	}

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

	public TextField getTextField() {
		return textField;
	}

	public void setTextField(TextField textField) {
		this.textField = textField;
	}
}
