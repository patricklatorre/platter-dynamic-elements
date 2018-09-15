package app.service.platter.sectionManager;

import app.service.platter.model.GenericController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Section
{
	private Scene internalScreen;
	private Parent layout;
	private GenericController controller;

	public Section() {
		this.layout = null;
		this.controller = null;
		this.internalScreen = null;
	}

	public static Section create() {
		return new Section();
	}

	public Section fromFXML(String URL) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(URL));
		this.layout = null;
		try {
			this.layout = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		controller = loader.getController();
		return this;
	}

	public Section withInternalScreen(double width, double height) {
		internalScreen = new Scene(layout, width, height);
		return this;
	}

	public Scene getInternalScreen() {
		return internalScreen;
	}

	public Parent getLayout() {
		return layout;
	}

	public GenericController getController() {
		return controller;
	}
}
