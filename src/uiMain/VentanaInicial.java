/*1). En las fuentes se incluira la siguiente documentacion:
         Cabecera del archivo: funcionalidad del modulo, autores, componentes del modulo, etc.
         Cabeceras en las clases, explicando su finalidad y describiendo las estructuras de datos definidas cuando
         sean relevantes.
         Cabeceras en los metodos, comentando su proposito y describiendo los parametros de entrada/salida.
         Comentarios en lineas de codigo de relevante interes o importancia.
         Otros aspectos de interes a tener en cuenta por el profesor.*/

/* Autores:   - Santiago Franco Valencia 
*            - Anderson Elian Gutierrez 
*            - Santiago Valencia Mejia
*                                        */

// Este modulo se encarga de presentar al usuario una ventana inicial donde podra ver informacion acerca de la aplicacion, los autores del 
// Software, sus hojas de vida, 4 fotos de cada uno y tener a disposicion un boton para cambiar a la ventana de usuario, donde podra
// hacer uso de todas las funcionalidades con las que cuenta el aplicativo. Adicional a esto, el usuario podra salir de aplicacion mediante 
// el uso del menu ubicado en la parte superior izquierda llamado "inicio" y posteriormente haciendo uso de la opcion "salir".

package uiMain;
import BaseDatos.Datos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;


public class VentanaInicial extends Application {
	
	public static Stage window = new Stage(); 
	public static Scene escena;
	public void start(Stage myStage) throws Exception { 
		window = myStage;		
		MenuBar barramenu = new MenuBar();
		Menu inicio = new Menu("Inicio");
		barramenu.getMenus().add(inicio);
		MenuItem salir = new MenuItem("Salir");
		SalirHandlerClass handler = new SalirHandlerClass();
		salir.setOnAction(handler);
		MenuItem descripcion = new MenuItem("Descripcion");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		DescripcionHandlerClas handler1 = new DescripcionHandlerClas();
		descripcion.setOnAction(handler1);
		inicio.getItems().addAll(descripcion,separator,salir);
		
    	
        //Creacion de ventana inicial
        GridPane p0 = new GridPane();
        p0.getChildren().add(barramenu);
        //Particion en dos partes:.
        GridPane p1 = new GridPane();
        GridPane p2 = new GridPane();
        //Agregar a p0:
        p0.add(p1, 0, 1);
        p0.add(p2, 1, 1);
        //agregar el fondo a p0
        p0.setStyle("-fx-background-image: url(\"file:src/img/fondo.png\"); " + "-fx-background-size: cover;");

        window.setTitle("IMPERIAL-GAMING");

        //Creacion de p3 como un label:
        Label p3 = new Label("Bienvenido a IMPERIAL GAMING, la mejor tienda virtual");
        p3.setTextFill(Color.web("#000000"));
        p3.setFont(Font.font ("Unispace", 35));
        
        p3.setPrefWidth(500);
        p3.setWrapText(true);

        //Creacion de p4:
        VBox p4 = new VBox(100);
        
        //Boton de acceso en p4:
        Button botonp4 = new Button("INGRESAR AL SISTEMA");
        botonp4.setScaleX(2);
        botonp4.setScaleY(2);

        //Espaciado en subpaneles:
        p1.setPadding(new Insets(10, 10, 10, 10));
        p2.setPadding(new Insets(15, 15, 15, 15));
        p1.setHgap(8);
        p1.setVgap(50);
        p0.setHgap(10);
        p0.setVgap(10);
        
        //Importar Imagenes:
        Image image1 = new Image("file:src/img/image3.jpg");
        Image image2 = new Image("file:src/img/image1.jpg");
        Image image3 = new Image("file:src/img/image2.jpg");
        Image image4 = new Image("file:src/img/image4.jpg");
        Image image5 = new Image("file:src/img/image5.jpg");

        //fotos Santiago Valencia
        Image imagens1= new Image("file:src/img/santiagov1.jpg");
        Image imagens2= new Image("file:src/img/santiagov2.jpg");
        Image imagens3= new Image("file:src/img/santiagov3.jpg");
        Image imagens4= new Image("file:src/img/santiagov4.jpg");
        //fotos Anderson 
        Image imagena1 = new Image("file:src/img/andersong1.jpg");
        Image imagena2 = new Image("file:src/img/andersong2.jpg");
        Image imagena3 = new Image("file:src/img/andersong3.jpg");
        Image imagena4 = new Image("file:src/img/andersong4.jpg");
        //fotos Santiago Franco
        Image imagensf1= new Image("file:src/img/sf1.jpg");
        Image imagensf2= new Image("file:src/img/sf2.jpg");
        Image imagensf3= new Image("file:src/img/sf3.jpg");
        Image imagensf4= new Image("file:src/img/sf4.jpg");
    
        ImageView imageView = new ImageView(image1);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true); 
        ImageView imagens11 = new ImageView(imagens1);
        ImageView imagens22 = new ImageView(imagens2);
        ImageView imagens33 = new ImageView(imagens3);
        ImageView imagens44 = new ImageView(imagens4);

        imagens11.setFitWidth(250);
        imagens11.setPreserveRatio(true);        
        imagens22.setFitWidth(250);
        imagens22.setPreserveRatio(true);        
        imagens33.setFitWidth(250);
        imagens33.setPreserveRatio(true);        
        imagens44.setFitWidth(250);
        imagens44.setPreserveRatio(true);

        //Anadir imagen a p4:
        p4.getChildren().add(0,imageView);
        p4.setAlignment(Pos.BOTTOM_CENTER);

        //Anadir boton a p4
        p4.getChildren().add(1,botonp4);
        
        //Anadir p4 y p3 a p1:
        p1.add(p3, 0, 0);
        p1.add(p4, 0, 1);

        // Crear el label p5
       String p5 = new String("HOJA DE VIDA DE SANTIAGO VALENCIA MEJIA:\n\nMi nombre es Santiago Valencia Mejia, soy Tecnico en Diseno Grafico, actualmente estudio de Ingenieria de Sistemas e Informatica en la UNAL, tengo 20 anios, me encuentro cursando el quinto semestre, estoy viendo el curso de Programacion Orientada a Objetos y soy uno de los Autores del presente proyecto. Me gustaria dedicarme a futuro en el campo de Redes y Telecomunicaciones.\n\n\n");
       String p5_1 = new String("HOJA DE VIDA DE ANDERSON GUTIERREZ BUENO:\n\nMi nombre es Anderson Elian Gutierrez Bueno, soy Tecnico en Sistemas, tengo 20 anios y actualmente estudio Ingenieria de Sistemas e Informatica en la UNAL, estoy cursando el quinto semestre y soy uno de los autores del presente proyecto. Quisiera dedicarme en un futuro como desarrollador de Software.\n\n\n");
       String p5_2 = new String("HOJA DE VIDA DE SANTIAGO FRANCO VALENCIA:\n\nMi nombre es Santiago Franco Valencia, soy tecnico en Diseno e Integracion de Multimedia, actualmente estoy culminando el 5to semestre de estadistica, me gustan mucho los juegos de cartas y la literatura, quisiera dedicarme a la consultoria o ser un analista financiero.\n\n\n");
 
       GridPane p6 = new GridPane();
       p6.add(imagens11,0,0);
       p6.add(imagens22,1,1);
       p6.add(imagens33,0,1);
       p6.add(imagens44,1,0);
       
       
        //Anadir p5 a p2:
       Label p05 = new Label(p5);
       p05.setTextFill(Color.web("#000000"));
       p05.setMaxWidth(600);
       p05.setWrapText(true);       
        p2.add(p05,0,0);
        p2.add(p6,0,1);


        //Interactividad a imagenes:
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
        
        // Evento para cambiar de color el texto de las hojas de vida cuando se pasa el mouse sobre ellas.
        p05.setOnMouseEntered(new EventHandler<MouseEvent>() {
        	@Override
			public void handle(MouseEvent event) {
        		p05.setTextFill(Color.web("#00008B"));       	
        		
        	}
        });
        
        p05.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
        		p05.setTextFill(Color.web("#000000"));       	
        		
        	}
        });
        
        
        // Evento para pasar las fotos de los autores segun la hoja de vida que se clickee.
        p05.setOnMouseClicked(new EventHandler<MouseEvent>(){			
			public void handle(MouseEvent event) {
				if(event.getSource().equals(p05)) {
					if(p05.getText().equals(p5)) {
						p05.setText(p5_1);
						imagens11.setImage(imagena1);
						imagens22.setImage(imagena2);
						imagens33.setImage(imagena3);
						imagens44.setImage(imagena4);
					}
					
					else if(p05.getText().equals(p5_1)) {
						p05.setText(p5_2);
                        imagens11.setImage(imagensf1);
                        imagens22.setImage(imagensf2);
                        imagens33.setImage(imagensf3);
                        imagens44.setImage(imagensf4);
					}
					
					else if(p05.getText().equals(p5_2)) {
						p05.setText(p5);
						imagens11.setImage(imagens1);
						imagens22.setImage(imagens2);
						imagens33.setImage(imagens3);
						imagens44.setImage(imagens4);
						
					}
				}
				
			}
        	
        });

        //Evento para cambiar de escenas:
        botonp4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setTitle("Ventana Imperial");
                window.setScene(new VentanaImperial().getEscena());
            }
        });
 
        escena = new Scene(p0, 1100, 900);
        window.setScene(escena);
        window.show();
        
        
    }
	
    ///////////////Manejadores de eventos://////////////////
    class DescripcionHandlerClas implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle("IMPERIAL GAMING");
    		dialogoDescripcion.setHeaderText("Descripcion de la Aplicacion");
    		dialogoDescripcion.setContentText("IMPERIAL GAMING es un Software que permite al administrador de una tienda de videojuegos poder llevar un control detallado de las transacciones que se lleven a cabo, asi como tener la posibilidad de consultar historiales de clientes registrados, facturas detalladas y ademas, acceder a 5 funcionalidades espciales que le dan un valor agregado al aplicativo");
    		dialogoDescripcion.showAndWait();	
    	}
    }
    
    class SalirHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
		System.exit(0);
			
		}
    	
    }
    
    
	public static void main(String[] args) {
	    Datos datos = new Datos();
	    datos.leerDatos1();
	    datos.leerDatos();
        launch(args);
    }
}
