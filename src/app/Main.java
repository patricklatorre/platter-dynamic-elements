package app;

import app.platter.DynamicExample;
import app.service.platter.model.Platter;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
		new DynamicExample().serve();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
