package uiMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaImperial extends Application {

    public void start(Stage primaryStage) throws Exception {
    	MenuBar barramenu = new MenuBar();
		Menu inicio = new Menu("Inicio");
		barramenu.getMenus().add(inicio);
		
    	VBox p0 = new VBox();
    	p0.getChildren().add(new Button("Esta es la ventana de usuario"));
    	
    	Scene escena = new Scene(p0, 1000, 800);
        primaryStage.setScene(escena);
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
