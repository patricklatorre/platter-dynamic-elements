package app.service.platter.windowManager;

import javafx.stage.Stage;

public class WindowResize
{
	public static void resize(Stage window, double width, double height) {
		window.setWidth(width);
		window.setHeight(height);
	}
}
