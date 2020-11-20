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
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Factura;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;

class VentanaImperial{
	
	private Scene escenaimperial;
	VBox vusuario = new VBox(15);
	
	VBox ingresarcliente;
	TextField nombrec = new TextField();
	TextField cedulac = new TextField();
	TextField celularc = new TextField();
	TextField emailc = new TextField();
	
	VBox ingresarconsola;
	TextField nombrecons = new TextField();
	TextField usocons = new TextField();
	TextField preciocons = new TextField();
	TextField colorcons = new TextField();
	TextField versioncons = new TextField();
	TextField capacidadcons = new TextField();
	
	VBox ingresarjuego;
	TextField nombrejueg = new TextField();
	TextField usojueg = new TextField();
	TextField preciojueg = new TextField();
	TextField pegijueg = new TextField();
	TextField plataformajueg = new TextField();
	TextField generojueg = new TextField();

////////////////////////// Ventana Imperial ////////////////////////////////
	
    public VentanaImperial(){
    	
/////////////////// Inicio Formulario Ingresar Cliente ////////////////////////////
    	ingresarcliente = new VBox(50);
    	ingresarcliente.setAlignment(Pos.CENTER);
    	TextField proceso = new TextField("Ingresar un Cliente a la Base De Datos");
    	proceso.setMaxWidth(500);
    	proceso.setEditable(false);
    	proceso.setAlignment(Pos.CENTER);
    	TextField detalleproceso = new TextField("Debe llenar todos los campos correspondientes para ingresar un Cliente");
    	detalleproceso.setAlignment(Pos.CENTER);
    	detalleproceso.setMaxWidth(800);
    	detalleproceso.setEditable(false);
    	GridPane formularioingresoc1 = new GridPane();
    	Label nombre = new Label("Nombre:");
    	nombre.setScaleX(1.2);
    	nombre.setScaleY(1.2);
    	Label cedula = new Label("Cedula:");
    	cedula.setScaleX(1.2);
    	cedula.setScaleY(1.2);
    	Label celular = new Label("Nro Celular:");
    	celular.setScaleX(1.2);
    	celular.setScaleY(1.2);
    	Label email = new Label("e-mail:");
    	email.setScaleX(1.2);
    	email.setScaleY(1.2);
    	Button ingresar = new Button("Ingresar");    	
    	BotonIngresarUsuarioHandlerClass ingresarUsuario = new BotonIngresarUsuarioHandlerClass();
        ingresar.setOnAction(ingresarUsuario);
    	Button cancelar = new Button("Cancelar");
    	formularioingresoc1.setPadding(new Insets(10,10,10,10));
    	formularioingresoc1.setVgap(20);
    	formularioingresoc1.setHgap(20);
    	formularioingresoc1.setAlignment(Pos.CENTER);
    	formularioingresoc1.add(nombre, 0, 0);
    	formularioingresoc1.add(nombrec,1 ,0);
    	formularioingresoc1.add(cedula, 0, 1);
    	formularioingresoc1.add(cedulac,1 ,1);
    	formularioingresoc1.add(celular, 0, 2);
    	formularioingresoc1.add(celularc,1 ,2);
    	formularioingresoc1.add(email, 0, 3);
    	formularioingresoc1.add(emailc,1 ,3);
    	formularioingresoc1.add(ingresar, 0, 4);
    	formularioingresoc1.add(cancelar,1 ,4);	
    	ingresarcliente.getChildren().addAll(proceso,detalleproceso,formularioingresoc1);
/////////////////// Fin Formulario Ingresar Cliente //////////////////////////// 
    	
    	
/////////////////// Inicio Formulario Ingresar Consola ////////////////////////////
    	ingresarconsola = new VBox(40);
    	ingresarconsola.setAlignment(Pos.CENTER);
    	TextField proceso1 = new TextField("Ingresar una Consola a la Base De Datos");
    	proceso1.setMaxWidth(500);
    	proceso1.setEditable(false);
    	proceso1.setAlignment(Pos.CENTER);
    	TextField detalleproceso1 = new TextField("Debe llenar todos los campos correspondientes para ingresar una Consola");
    	detalleproceso1.setAlignment(Pos.CENTER);
    	detalleproceso1.setEditable(false);
    	detalleproceso1.setMaxWidth(800);
    	GridPane formularioingresocons1 = new GridPane();
    	Label nombrecon = new Label("Nombre:");
    	nombrecon.setScaleX(1.1);
    	nombrecon.setScaleY(1.1);
    	Label usocon = new Label("Uso de la Consola:");
    	usocon.setScaleX(1.1);
    	usocon.setScaleY(1.1);
    	Label preciocon = new Label("Precio:");
    	preciocon.setScaleX(1.1);
    	preciocon.setScaleY(1.1);
    	Label colorcon = new Label("Color:");
    	colorcon.setScaleX(1.1);
    	colorcon.setScaleY(1.1);
    	Label versioncon = new Label("Version:");
    	versioncon.setScaleX(1.1);
    	versioncon.setScaleY(1.1);
    	Label capacidadcon = new Label("Almacenamiento (Gb):");
    	capacidadcon.setScaleX(1.1);
    	capacidadcon.setScaleY(1.1);
    	Button ingresarcon = new Button("Ingresar");

    	BotonIngresarConsolaHandlerClass ingresarConsola = new BotonIngresarConsolaHandlerClass();
        ingresarcon.setOnAction(ingresarConsola); 
        Button cancelarcon = new Button("Cancelar");
    	formularioingresocons1.setPadding(new Insets(10,10,10,10));
    	formularioingresocons1.setVgap(20);
    	formularioingresocons1.setHgap(20);
    	formularioingresocons1.setAlignment(Pos.CENTER);
    	formularioingresocons1.add(nombrecon, 0, 0);
    	formularioingresocons1.add(nombrecons,1 ,0);
    	formularioingresocons1.add(usocon, 0, 1);
    	formularioingresocons1.add(usocons,1 ,1);
    	formularioingresocons1.add(preciocon, 0, 2);
    	formularioingresocons1.add(preciocons,1 ,2);
    	formularioingresocons1.add(colorcon, 0, 3);
    	formularioingresocons1.add(colorcons,1 ,3);
    	formularioingresocons1.add(versioncon, 0, 4);
    	formularioingresocons1.add(versioncons,1 ,4);
    	formularioingresocons1.add(capacidadcon, 0, 5);
    	formularioingresocons1.add(capacidadcons, 1, 5);
    	formularioingresocons1.add(ingresarcon, 0, 6);
    	formularioingresocons1.add(cancelarcon,1 ,6);	
    	ingresarconsola.getChildren().addAll(proceso1,detalleproceso1,formularioingresocons1);
/////////////////// Fin Formulario Ingresar Consola //////////////////////////// 
    	
/////////////////// Inicio Formulario Ingresar Juego ////////////////////////////
		ingresarjuego = new VBox(40);
		ingresarjuego.setAlignment(Pos.CENTER);
		TextField procesoj = new TextField("Ingresar un Juego a la Base De Datos");
		procesoj.setMaxWidth(500);
		procesoj.setEditable(false);
		procesoj.setAlignment(Pos.CENTER);
		TextField detalleprocesoj = new TextField("Debe llenar todos los campos correspondientes para ingresar un Juego");
		detalleprocesoj.setAlignment(Pos.CENTER);
		detalleprocesoj.setEditable(false);
		detalleprocesoj.setMaxWidth(800);
		GridPane formularioingresojuego = new GridPane();
		Label nombrejuego = new Label("Nombre:");
		nombrecon.setScaleX(1.1);
		nombrecon.setScaleY(1.1);
		Label usojuego = new Label("Uso del Juego:");
		usocon.setScaleX(1.1);
		usocon.setScaleY(1.1);
		Label preciojuego = new Label("Precio:");
		preciocon.setScaleX(1.1);
		preciocon.setScaleY(1.1);
		Label pegijuego = new Label("Pegi:");
		colorcon.setScaleX(1.1);
		colorcon.setScaleY(1.1);
		Label plataformajuego = new Label("Plataforma Asociada:");
		versioncon.setScaleX(1.1);
		versioncon.setScaleY(1.1);
		Label generojuego = new Label("Genero:");
		capacidadcon.setScaleX(1.1);
		capacidadcon.setScaleY(1.1);
		Button ingresarjueg = new Button("Ingresar");
		BotonIngresarJuegoHandlerClass ingresarJuego = new BotonIngresarJuegoHandlerClass();
		ingresarjueg.setOnAction(ingresarJuego);
		Button cancelarjueg = new Button("Cancelar");
		formularioingresojuego.setPadding(new Insets(10, 10, 10, 10));
		formularioingresojuego.setVgap(20);
		formularioingresojuego.setHgap(20);
		formularioingresojuego.setAlignment(Pos.CENTER);
		formularioingresojuego.add(nombrejuego, 0, 0);
		formularioingresojuego.add(nombrejueg, 1, 0);
		formularioingresojuego.add(usojuego, 0, 1);
		formularioingresojuego.add(usojueg, 1, 1);
		formularioingresojuego.add(preciojuego, 0, 2);
		formularioingresojuego.add(preciojueg, 1, 2);
		formularioingresojuego.add(pegijuego, 0, 3);
		formularioingresojuego.add(pegijueg, 1, 3);
		formularioingresojuego.add(plataformajuego, 0, 4);
		formularioingresojuego.add(plataformajueg, 1, 4);
		formularioingresojuego.add(generojuego, 0, 5);
		formularioingresojuego.add(generojueg, 1, 5);
		formularioingresojuego.add(ingresarjueg, 0, 6);
		formularioingresojuego.add(cancelarjueg, 1, 6);
		ingresarjuego.getChildren().addAll(procesoj, detalleprocesoj, formularioingresojuego);
/////////////////// Fin Formulario Ingresar Juego //////////////////////////// 
    	
    	
    	
    	
    	
    	
    	
        //Creacion de barra de menus:
        MenuBar barramenu = new MenuBar();

        //Creacion de menus:
        Menu archivo = new Menu("Archivo");
        Menu procon = new Menu("Procesos y consultas");
        Menu aiuda = new Menu("Ayuda");

        //Items de archivo:
        MenuItem usuario = new MenuItem("Usuario");
        MenuItem salir = new MenuItem("Salir");
        SalirHandlerClass handler = new SalirHandlerClass();
        salir.setOnAction(handler);

        //Items de procesos y consultas:
        MenuItem vender = new MenuItem("Vender");
        MenuItem sertec = new MenuItem("Servicio tecnico");
        Menu usuarios = new Menu("Agregar o eliminar usuarios");
        Menu stock = new Menu("Agregar o eliminar Stock");
        MenuItem consultas = new MenuItem("Consultas");

        //Items de ayuda:
        MenuItem acerca = new MenuItem("Acerca de");
        AcercaDeHandlerClass handler1= new AcercaDeHandlerClass();
        acerca.setOnAction(handler1);        

        //Agregar items a menus:
        archivo.getItems().addAll(usuario, salir);
        procon.getItems().addAll(vender,sertec,usuarios,stock, consultas);
        aiuda.getItems().addAll(acerca);
        //Agregar items a item usuarios:
        MenuItem agregarUsuario = new MenuItem("Ingresar nuevo Usuario"); 
        agregarUsuarioHandlerClass handlerUsuario = new agregarUsuarioHandlerClass();
        agregarUsuario.setOnAction(handlerUsuario);
        MenuItem eliminarUsuario = new MenuItem("Eliminar un Usuario Registrado");
        usuarios.getItems().addAll(agregarUsuario,eliminarUsuario);
        
        //Agregar items a item stock:
        Menu agregarStock = new Menu("Ingresar nuevo Stock");
        MenuItem agregarConsola= new MenuItem("Agregar Consola");
        agregarConsolaHandlerClass handlerConsola = new agregarConsolaHandlerClass();
        agregarConsola.setOnAction(handlerConsola);
        MenuItem agregarJuego= new MenuItem("Agregar Juego");
        agregarJuegoHandlerClass handlerJuego = new agregarJuegoHandlerClass();
        agregarJuego.setOnAction(handlerJuego);
        MenuItem agregarPeriferico= new MenuItem("Agregar Periferico");
        MenuItem eliminarStock = new MenuItem("Eliminar un Stock Registrado");
        stock.getItems().addAll(agregarStock,eliminarStock);
        agregarStock.getItems().addAll(agregarConsola,agregarJuego,agregarPeriferico);
        //Agregar menus:
        barramenu.getMenus().addAll(archivo, procon, aiuda);        
        vusuario.getChildren().add(barramenu);
        TextField txt = new TextField("Hola");
        vusuario.getChildren().add(txt);


        ListView<String> visorConsolas = new ListView<String>();
        ArrayList<String> listaPrueba = new ArrayList<String>();
        for (Consola consola: Datos.listaConsolas){
            listaPrueba.add(consola.getNombre());
        }
        ObservableList<String> listica = FXCollections.observableArrayList(listaPrueba);
        visorConsolas.setItems(listica);

        
        escenaimperial = new Scene(vusuario, 1100, 900);    

	}
    
    class AcercaDeHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle("IMPERIAL GAMING");
    		dialogoDescripcion.setHeaderText("Version 1.0 Todos Los Derechos Reservados.");
    		dialogoDescripcion.setContentText("Desarrolladores Software IMPERIAL GAMING:\n\n-Anderson Elian Gutierrez Bueno.\n-Santiago Valencia Mejia.\n-Santiago Franco Valencia.");
    		dialogoDescripcion.showAndWait();
    	}
    }

	class SalirHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			VentanaInicial.window.setScene(VentanaInicial.escena);
		}
	}
	class agregarUsuarioHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1,ingresarcliente);
			
		}
	}
	class BotonIngresarUsuarioHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			String nombre = nombrec.getText();
			int cedula = Integer.parseInt(cedulac.getText());
			Long celular = Long.parseLong(cedulac.getText());
			String correo = emailc.getText();
			Cliente.ingresarCliente(nombre, cedula, celular, correo);
		}
	}
	class agregarConsolaHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1,ingresarconsola);
		}
	}	
	class BotonIngresarConsolaHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			String nombre = nombrecons.getText();
			Boolean uso = Boolean.parseBoolean(usocons.getText());
			Float precio = Float.parseFloat(preciocons.getText());
			String color = colorcons.getText();
			String version = versioncons.getText();
			int almacenamiento = Integer.parseInt(capacidadcons.getText());
			Consola.ingresarConsola(nombre,uso,precio,color,version,almacenamiento);
		}
	}
	class agregarJuegoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1,ingresarjuego);
		}
	}
	class BotonIngresarJuegoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			String nombre = nombrejueg.getText();
			Boolean uso = Boolean.parseBoolean(usojueg.getText());
			Float precio = Float.parseFloat(preciojueg.getText());
			int pegi = Integer.parseInt(pegijueg.getText());
			String plataforma = plataformajueg.getText();
			String genero = generojueg.getText();
			Juego.ingresarJuego(nombre, uso, precio, pegi, plataforma, genero);
			
		}
	}
	
	
	
	public Scene getEscena() {
		return escenaimperial;
	}

}
