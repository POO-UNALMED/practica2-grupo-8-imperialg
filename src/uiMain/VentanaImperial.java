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

// Este modulo se encarga de la interacciqn que tendra el usuario con el programa, aqui es donde se veran reflejadas todas las funcionalidades
// la aplicacion.

package uiMain;
import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;
import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;

class VentanaImperial{

	// Creacion de la escena principal de esta ventana.
	private Scene escenaimperial;
	VBox vusuario = new VBox(15);
	VBox defecto = new VBox();
	VBox modificarCliente = new ModificarCliente();
	VBox modificarPeriferico = new ModificarPeriferico();
	VBox modificarConsola = new ModificarConsola();
	VBox modificarJuego = new ModificarJuego();
	static boolean iniciar = false;

	public VentanaImperial(){		
		modificarConsola.setPadding(new Insets(10,10,10,10));
	
        //Creacion de barra de menus de la ventana imperial:
        MenuBar barramenu = new MenuBar();

        
        //Creacion de menus que posteriormente se agregaran a la barra de menus.
        Menu archivo = new Menu("Archivo");
        Menu procon = new Menu("Procesos y consultas");
        Menu aiuda = new Menu("Ayuda");

        
        //Items del submenu archivo:
        MenuItem usuario = new MenuItem("Usuario");
        MensajeUsuarioHandlerClass msj = new MensajeUsuarioHandlerClass();
        usuario.setOnAction(msj);
        MenuItem salir = new MenuItem("Salir");
        SalirHandlerClass handler = new SalirHandlerClass();
        salir.setOnAction(handler);

        //Items del submenu procesos y consultas:
        MenuItem vender = new MenuItem("Vender");
        DevolverDefectoUHandlerClass venderr = new DevolverDefectoUHandlerClass();
        vender.setOnAction(venderr);
        MenuItem usuarios = new MenuItem("Agregar, Eliminar o Modificar Usuarios");
        agregarUsuarioHandlerClass handlerUsuario = new agregarUsuarioHandlerClass();
        usuarios.setOnAction(handlerUsuario);
        Menu stock = new Menu("Agregar, Eliminar o Modificar Stock");
        MenuItem consultas = new MenuItem("Consultas");
        ConsultasHandlerClass handlerConsultas = new ConsultasHandlerClass();
        consultas.setOnAction(handlerConsultas);

        // Menu ayuda ayuda:
        MenuItem acerca = new MenuItem("Acerca de");
        AcercaDeHandlerClass handler1= new AcercaDeHandlerClass();
        acerca.setOnAction(handler1);        

        //Agregar items a menus:
        archivo.getItems().addAll(usuario, salir);
        procon.getItems().addAll(vender,usuarios,stock, consultas);
        aiuda.getItems().addAll(acerca);
       
 
        MenuItem agregarConsola= new MenuItem("Agregar, Eliminar o Modificar Consolas");
        agregarConsolaHandlerClass handlerConsola = new agregarConsolaHandlerClass();
        agregarConsola.setOnAction(handlerConsola);
        MenuItem agregarJuego= new MenuItem("Agregar, Eliminar o Modificar Juegos");
        agregarJuegoHandlerClass handlerJuego = new agregarJuegoHandlerClass();
        agregarJuego.setOnAction(handlerJuego);
        MenuItem agregarPeriferico= new MenuItem("Agregar, Eliminar o Modificar Perifericos");
        agregarPerifericoHandlerClass handlerper = new agregarPerifericoHandlerClass();
        agregarPeriferico.setOnAction(handlerper);
        stock.getItems().addAll(agregarConsola,agregarJuego,agregarPeriferico);
        
        //Agregar menus:
        barramenu.getMenus().addAll(archivo, procon, aiuda);        
        vusuario.getChildren().add(barramenu);
        TextField txt = new TextField("A continuacion seleccione los productos que desea comprar");
		txt.setAlignment(Pos.CENTER);
		txt.setMaxWidth(700);
		txt.setEditable(false);
        
		//Creacion de Array de carrito:
		ArrayList<Detalle> carrito = new ArrayList<Detalle>();


		//Importacion de vbox de ventana ventas:
		defecto = new VentanaVentas(carrito);

		VBox bienvenida = new VBox(10);
		bienvenida.setPadding(new Insets(10,10,10,10));
		bienvenida.setAlignment(Pos.CENTER);
		TextField saludo = new TextField("Usted ha ingresado a la Ventana Imperial");
		TextArea manual = new TextArea("En la barra de Menu ubicada en la parte superior izquierda, encontraras:\n\nArchivo:\n1) Submenu Usuario: que brindara un cuadro de dialogo al usuario "
				+ "\n2) Submenu Salir: Aqui el usuario podra devolverse a la ventana inicial.\n\nMenu Procesos y Consultas, el cual tiene los siguientes submenus:"
				+ "\n1) Vender: Aqui el usuario podra venderle a sus clientes consolas perifericos o juegos, ademas podra realizar servicios tecnicos"
				+ "\n2) Agregar,Eliminar o Modificar Usuarios: Aqui el administrador podra realizar cualquier tipo de modificaciones a los clientes registrados en la tienda"
				+ "\n3) Agregar, Eliminar o Modificar Stock: Aqui el administrador podra realizar todo tipo de modificaciones al stock de su tienda"
				+ "\n4) Consultas: en este apartado se encuentran las funcionalidades especiales que le permiten al usuario acceder a informacion reelevante acerca de su tienda "
				+ "\n\nAyuda:\n1) Submenu Acerca de: Aqui el usuario podra ver la version de la aplicacion y los desarrolladores de la misma.");
		manual.setMinSize(900,300);
		saludo.setMaxSize(300,100);
		saludo.setEditable(false);
		Button ok = new Button("Aceptar");	
		escenaimperial = new Scene(bienvenida,1100, 900);
		 ok.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	            	vusuario.getChildren().set(1, defecto);
	                	                
	            }
	        });
		 
		 if(iniciar == false) {
			 vusuario.getChildren().add(bienvenida);
			 iniciar = true;
			 
		 }else if(iniciar == true){
			 vusuario.getChildren().add(defecto);	
		 }
		 
		
		bienvenida.getChildren().addAll(saludo,manual,ok);
		
		
		//vusuario.getChildren().add(bienvenida);		
		escenaimperial = new Scene(vusuario, 1100, 900);

	}
    
    
    ///////////////Manejadores de eventos:////////////////// 
    
    // Creacion cuadro de dialogo cuando el usuario clickea el boton "Acerca de".
    class AcercaDeHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle("IMPERIAL GAMING");
    		dialogoDescripcion.setHeaderText("Version 1.0 Todos Los Derechos Reservados.");
    		dialogoDescripcion.setContentText("Desarrolladores Software IMPERIAL GAMING:\n\n-Anderson Elian Gutierrez Bueno.\n-Santiago Valencia Mejia.\n-Santiago Franco Valencia.");
    		dialogoDescripcion.showAndWait();
    	}
    }
    
    
    // Evento para devolverse a la ventana por defecto cuando el usuario clickea alguna opcion como por ejemplo "Cancelar". 
    class DevolverDefectoUHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		vusuario.getChildren().setAll(new VentanaImperial().vusuario);
    	
    		
    	}
    }
    
    // Evento para devolverse a la ventana inicial de la aplicacion.
	class SalirHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			VentanaInicial.window.setScene(VentanaInicial.escena);
			 VentanaInicial.window.setTitle("IMPERIAL-GAMING");
		}
	}


	// Evento para aregar un usuario a la base de datos cuando se clickea la opcion "Ingresar nuevo usuario".
	class agregarUsuarioHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1,modificarCliente);
			
		}
	}



	// Evento para aregar una consola a la base de datos cuando se clickea la opcion "Ingresar Consola".
	class agregarConsolaHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1,modificarConsola);
		}
	}

	// Evento para aregar un juego a la base de datos cuando se clickea la opcion "Ingresar Juego".
	class agregarJuegoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1,modificarJuego);
		}
	}



	// Evento para aregar un Periferico a la base de datos cuando se clickea la opcion "Ingresar Periferico".
	class  agregarPerifericoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1, modificarPeriferico);
		}
	}
	
	// Evento para dirigirse a la ventana de consultas del aplicativo.
	class ConsultasHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1, new VentanaConsultas().consultas);
			
		}
	}
	

	// Cuadro de dialogo que se muestra en pantalla cuando el usuario clickea la opcion "Usuario" ubicada en el menu "Archivo" de la parte superior  del programa.
	class MensajeUsuarioHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setTitle("***IMPERIAL-GAMING***");
			dialogoInfo.setHeaderText("El lugar perfecto para los amantes de los Videojuegos");
			dialogoInfo.setContentText("IMPERIAL-GAMING, Tu mejor tienda virtual. Haciendo felices a miles de Clientes desde el 2010.");
			dialogoInfo.showAndWait();
		}
	}
	
	// Metodo get para la escena imperial
	public  Scene getEscena() {
		return escenaimperial;
	}
	
	// Metodo get para el VBox de la ventana de usuario. 
	public VBox getvusuario() {
		return vusuario;
	}

}