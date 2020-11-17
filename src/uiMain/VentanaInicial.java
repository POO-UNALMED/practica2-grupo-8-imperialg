package uiMain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
        //Agregar a p0:
        p0.add(p1, 0, 0);
        p0.add(p2, 1, 0);
        //agregar el fondo a p0
        p0.setStyle("-fx-background-image: url(\"file:src/img/fondo.png\"); " + "-fx-background-size: cover;");

        myStage.setTitle("IMPERIAL-GAMING");

        //Creacion de p3 como un label:
        Label p3 = new Label("Bienvenido a IMPERIAL GAMING, la mejor tienda virtual");
        p3.setFont(new Font("Arial Black",23));
        
        p3.setPrefWidth(400);
        p3.setWrapText(true);

        //Creacion de p4:
        VBox p4 = new VBox();
        
        //Boton de acceso en p4:
        Button botonp4 = new Button("Ingresar al sistema");
        botonp4.setMaxHeight(1500);
        botonp4.setMaxWidth(1000);
        botonp4HandlerClass BotonVentanaU = new botonp4HandlerClass();
		botonp4.setOnAction(BotonVentanaU);

        //Espaciado en subpaneles:
        p1.setPadding(new Insets(10, 10, 10, 10));
        p1.setHgap(8);
        p1.setVgap(8);
        p0.setHgap(10);
        p0.setVgap(10);
        
        //Importar Imagenes:
        Image image1 = new Image("file:src/img/image1.jpg");
        Image image2 = new Image("file:src/img/image2.jpg");
        Image image3 = new Image("file:src/img/image3.jpg");
        Image image4 = new Image("file:src/img/image4.jpg");
        Image image5 = new Image("file:src/img/image5.jpg");
        Image imagens1= new Image("file:src/img/santiagov1.jpg");
        Image imagens2= new Image("file:src/img/santiagov2.jpg");
        Image imagens3= new Image("file:src/img/santiagov3.jpg");
        Image imagens4= new Image("file:src/img/santiagov4.jpg");
        		

        ImageView imageView = new ImageView(image1);
        ImageView imagens11 = new ImageView(imagens1);
        ImageView imagens22 = new ImageView(imagens2);
        ImageView imagens33 = new ImageView(imagens3);
        ImageView imagens44 = new ImageView(imagens4);
        

        imagens11.setFitWidth(270);
        imagens11.setPreserveRatio(true);
        
        imagens22.setFitWidth(280);
        imagens22.setPreserveRatio(true);
        
        imagens33.setFitWidth(270);
        imagens33.setPreserveRatio(true);
        
        
        imagens44.setFitWidth(288);
        imagens44.setPreserveRatio(true);
        

        //Anadir imagen a p4:
        p4.getChildren().add(0,imageView);

        //Anadir boton a p4
        p4.getChildren().add(1,botonp4);

        //Anadir p4 y p3 a p1:
        p1.add(p3, 0, 0);
        p1.add(p4, 0, 1);

        // Crear el label p5
       
       String p5 = new String("HOJA DE VIDA DE ANDERSON GUTIERREZ BUENO:\n\nSoy estudiante de Ingenieria De Sistemas e Informatica de la UNAL, tengo 20 anios, me encuentro cursando el quinto semestre y actualmente estoy viendo el curso de Programacion orientada a objetos, dictado por el Docente Jaime Alberto Guman Luna.\n\n\n");
       String p5_1 = new String("HOJA DE VIDA DE SANTIAGO VALENCIA MEJIA:\n\nSoy estudiante de Ingenieria de Sistemas e Informatica en la UNAL, tengo 20 anios, me encuentro actualmente cursando el quinto semestre, estoy viendo el curso de Programacion Orientada a Objetos y soy uno de los Autores del presente proyecto.\n\n\n");
       String p5_2 = new String("HOJA DE VIDA DE SANTIAGO FRANCO VALENCIA:\n\nSoy estudiante de Ingenieria de Sistemas e Informatica en la UNAL, tengo 20 anios, me encuentro actualmente cursando el quinto semestre, estoy viendo el curso de Programacion Orientada a Objetos y soy uno de los Autores del presente proyecto.\n\n\n");
 
       GridPane p6 = new GridPane();
       p6.add(imagens11,0,0);
       p6.add(imagens22,1,1);
       p6.add(imagens33,0,1);
       p6.add(imagens44,1,0);
       
       
        //Anadir p5 a p2:
       Label p05 = new Label(p5);
       p05.setMaxWidth(600);
       p05.setWrapText(true);
       
        p2.add(p05,0,0);
        p2.add(p6,0,1);

        //Interactividad a imagen:
        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				if (event.getSource() instanceof ImageView) {
					if (imageView.getImage().equals(image1)) {
						imageView.setImage(image2);
					} else if (imageView.getImage().equals(image2)) {
						imageView.setImage(image3);
					} else if (imageView.getImage().equals(image3)) {
						imageView.setImage(image4);
					} else if (imageView.getImage().equals(image4)) {
						imageView.setImage(image5);
					} else if (imageView.getImage().equals(image5)) {
						imageView.setImage(image1);
					}
				}
			}
		});
          
        
        p05.setOnMouseClicked(new EventHandler<MouseEvent>(){			
			public void handle(MouseEvent event) {
				if(event.getSource().equals(p05)) {
					if(p05.getText().equals(p5)) {
						p05.setText(p5_1);
					}
					else if(p05.getText().equals(p5_1)) {
						p05.setText(p5_2);
					}
					else if(p05.getText().equals(p5_2)) {
						p05.setText(p5);
					}
				}
				
			}
        	
        });
        
        Scene escena = new Scene(p0, 1000, 800);
        myStage.setScene(escena);

        myStage.show();
        
    }
    //cambiar de ventana inico a ventana usuario        
    class botonp4HandlerClass implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event) {
			System.out.println("Se dio clic en el boton, eso es para cambiar de ventana");
		
		}
		
	}
    
	public static void main(String[] args) {
        launch(args);
    }
}
