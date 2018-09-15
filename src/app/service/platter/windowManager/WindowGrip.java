package app.service.platter.windowManager;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowGrip
{
	public static void rubberize(Stage window, Scene screen) {
		final double[] x = new double[1];
		final double[] y = new double[1];

		screen.getRoot().setOnMousePressed(event -> {
			// record a delta distance for the drag and drop operation.
			x[0] = window.getX() - event.getScreenX();
			y[0] = window.getY() - event.getScreenY();
		});
		screen.getRoot().setOnMouseDragged(event -> {
			window.setX(event.getScreenX() + x[0]);
			window.setY(event.getScreenY() + y[0]);
		});
	}
}
