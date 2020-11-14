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

import java.util.Random;

public class VentanaInicial extends Application {
    public void start(Stage myStage) throws Exception {
        //Creación de ventana inicial
        GridPane p0 = new GridPane();
        //Partición en dos partes:
        GridPane p1 = new GridPane();
        GridPane p2 = new GridPane();
        //Agregar a p0:
        p0.add(p1, 0, 0);
        p0.add(p2, 0, 1);

        myStage.setTitle("IMPERIAL-GAMING");

        //Creación de p3 como un label:
        Labeled p3 = new Label("Bienvenido a IMPERIAL GAMING, la mejor tienda virtual");
        p3.setPrefWidth(200);
        p3.setWrapText(true);

        //Creación de p4:
        VBox p4 = new VBox();

        //Botón de acceso en p4:

        Button botonp4 = new Button("Ingresar al sistema");
        botonp4.setMaxHeight(1500);
        botonp4.setMaxWidth(1000);


        //Espaciado en subpaneles:

        p1.setPadding(new Insets(10, 10, 10, 10));
        p1.setHgap(8);
        p1.setVgap(8);
        p0.setHgap(10);
        p0.setVgap(10);

        //Creación de botones
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

        //Creación de imageView:

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

        Label p5 = new Label("Aquí puedo colocar cualquier cosa, en este caso usaremos un chanchullo");

        //Anadir p5 a p2:
        p2.add(p5,0,0);


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


        Scene escena = new Scene(p0, 800, 600);
        myStage.setScene(escena);

        myStage.show();
    }

}
