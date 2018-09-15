package app.view.dynamics;

import java.net.URL;
import java.util.ResourceBundle;

import app.service.platter.model.GenericController;
import app.service.platter.sectionManager.Section;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DynamicFieldList extends GenericController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private GridPane container;

	@FXML
	private ScrollPane scroll;

	@FXML
	private VBox feedBox;

	@FXML
	void initialize() {
		assert container != null : "fx:id=\"container\" was not injected: check your FXML file 'dynamicFieldList.fxml'.";
		assert scroll != null : "fx:id=\"scroll\" was not injected: check your FXML file 'dynamicFieldList.fxml'.";
		assert feedBox != null : "fx:id=\"feedBox\" was not injected: check your FXML file 'dynamicFieldList.fxml'.";

		insertField();
	}

	public void insert(String str) {
		DynamicText dynamicText = (DynamicText)
				Section.create().fromFXML("/app/view/dynamics/dynamicText.fxml").getController();

		dynamicText.getRow().getStyleClass().add("row");

		dynamicText.getRowStr().setText(str);

		dynamicText.getRow().setOnMouseClicked(e -> {
			if (dynamicText.getRow().getStyleClass().contains("row")) {
				dynamicText.getRowStr().setText("deleted \"" + dynamicText.getRowStr().getText() + "\"");
				dynamicText.getRow().getStyleClass().remove("row");
				dynamicText.getRow().getStyleClass().add("prompt");
				dynamicText.getRowStr().setTooltip(new Tooltip("click to permanently delete"));
			}
			else if (dynamicText.getRow().getStyleClass().contains("prompt")) {
				feedBox.getChildren().remove(dynamicText.getRow());
			}
		});

		feedBox.getChildren().add(dynamicText.getRow());
	}

	public void insertField() {
		DynamicField dynamicField = (DynamicField)
				Section.create().fromFXML("/app/view/dynamics/dynamicField.fxml").getController();

		dynamicField.getRow().getStyleClass().add("inputRow");

		// Enter key as submit
		dynamicField.getTextField().setOnKeyPressed((keyEvent) -> {
			if (keyEvent.getCode().equals(KeyCode.ENTER)) {
				insert(dynamicField.getTextField().getText());
				feedBox.getChildren().remove(dynamicField.getRow());
				insertField();
			}
		});

		feedBox.getChildren().add(dynamicField.getRow());
		dynamicField.getTextField().requestFocus();
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

	public GridPane getContainer() {
		return container;
	}

	public void setContainer(GridPane container) {
		this.container = container;
	}

	public ScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(ScrollPane scroll) {
		this.scroll = scroll;
	}

	public VBox getFeedBox() {
		return feedBox;
	}

	public void setFeedBox(VBox feedBox) {
		this.feedBox = feedBox;
	}
}
