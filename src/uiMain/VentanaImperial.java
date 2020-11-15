package uiMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VentanaImperial extends Application {

    public void start(Stage primaryStage) throws Exception {
    	
    	GridPane p0 = new GridPane();
    	p0.add(new Button("Esta es la ventana de usuario"), 0, 0);
    	
    	Scene escena = new Scene(p0, 1000, 800);
        primaryStage.setScene(escena);
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
