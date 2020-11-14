package uiMain;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class VentanaInicial extends Application {
    public void start(Stage myStage) throws Exception {
    	
    	
        //Creacion de ventana inicial
        GridPane p0 = new GridPane();
        //Particion en dos partes:
        GridPane p1 = new GridPane();
        GridPane p2 = new GridPane();
        p0.setStyle("-fx-background-color:LIGHTSTEELBLUE;");
        //Agregar a p0:
        p0.add(p1, 0, 0);
        p0.add(p2, 1, 0);

        myStage.setTitle("IMPERIAL-GAMING");

        //Creacion de p3 como un label:
        Label p3 = new Label("Bienvenido a IMPERIAL GAMING, la mejor tienda virtual");
        p3.setFont(new Font("Arial Black",23));
        
        p3.setPrefWidth(200);
        p3.setWrapText(true);

        //Creacion de p4:
        VBox p4 = new VBox();
        //Boton de acceso en p4:

        Button botonp4 = new Button("Ingresar al sistema");
        botonp4.setMaxHeight(1500);
        botonp4.setMaxWidth(1000);


        //Espaciado en subpaneles:

        p1.setPadding(new Insets(10, 10, 10, 10));
        p1.setHgap(8);
        p1.setVgap(8);
        p0.setHgap(10);
        p0.setVgap(10);

        //Creacion de botones
        Button boton1 = new Button("Hola");
        Button boton2 = new Button("Hola1");
        boton1.setMaxHeight(Double.MAX_VALUE);
        boton1.setMaxWidth(Double.MAX_VALUE);

        //Importar Imagenes:

        Image image1 = new Image("file:src/img/image1.jpg");
        Image image2 = new Image("file:src/img/image2.jpg");
        Image image3 = new Image("file:src/img/image3.jpg");
        Image image4 = new Image("file:src/img/image4.jpg");
        Image image5 = new Image("file:src/img/image5.jpg");

        //Creacion de imageView:

        ImageView imageView = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        //Anadir imagen a p4:

        p4.getChildren().add(0,imageView);

        //Anadir boton a p4
        p4.getChildren().add(1,botonp4);


        //Anadir p4 y p3 a p1:

        p1.add(p3, 0, 0);
        p1.add(p4, 0, 1);

        // Crear el label p5

       Label p5 = new Label("HOJA DE VIDA DE ANDERSON GUTIERREZ BUENO:\n\nSoy estudiante de Ingenieria De Sistemas e "
       		+ "Informática de la UNAL, tengo 20 anios, me encuentro\ncursando el quinto semestre y actualmente estoy viendo el curso de Programacion orientada"
       		+ " a objetos,\ndictado por el Docente Jaime Alberto Guman Luna.\n\n");
       Label p5_1 = new Label("HOJA DE VIDA DE SANTIAGO VALENCIA MEJIA:\n\nSoy estudiante de Ingenieria de Sistemas e Informatica en la UNAL, tengo 20 anios, "
       		+ "me encuentro\nactualmente cursando el quinto semestre, estoy viendo el curso de Programacion Orientada a Objetos\ny soy uno de "
       		+ "los Autores del presente proyecto.\n\n\n");
       Label p5_2 = new Label("HOJA DE VIDA DE SANTIAGO FRANCO VALENCIA:\n\nSoy estudiante del programa de Estadistica de la UNAL");

        //Anadir p5 a p2:
        p2.add(p5,0,0);
        p2.add(p5_1,0,1);
        p2.add(p5_2,0,2);


        //Interactividad a imagen:
        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            int contador = 0;
            @Override
            public void handle(MouseEvent event) {
                contador +=1;
                if (contador % 5 == 0) {
                    imageView.setImage(image1);
                } else if (contador % 5 == 1) {
                    imageView.setImage(image2);
                } else if (contador % 5 == 2) {
                    imageView.setImage(image3);
                } else if (contador % 5 == 3) {
                    imageView.setImage(image4);
                } else if (contador % 5 == 4) {
                    imageView.setImage(image5);
                }
            }
        });
        
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				
			}
        	
        });
        
        Scene escena = new Scene(p0, 1000, 800);
        myStage.setScene(escena);

        myStage.show();
        
    }
    
	public static void main(String[] args) {
        launch(args);
    }
}
