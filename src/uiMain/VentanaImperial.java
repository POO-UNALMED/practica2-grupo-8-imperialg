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
import javafx.stage.Stage;

import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;

class VentanaImperial{
	
	private Scene escenaimperial;
	VBox vusuario = new VBox();
	VBox ingresarcliente;
	TextField nombrec = new TextField();
	TextField cedulac = new TextField();
	TextField celularc = new TextField();
	TextField emailc = new TextField();
	
	
	
////////////////////////// Ventana Imperial ////////////////////////////////
    public VentanaImperial(){
/////////////////// Inicio Formulario Ingresar Cliente ////////////////////////////
    	ingresarcliente = new VBox(50);
    	ingresarcliente.setAlignment(Pos.CENTER);
    	TextField proceso = new TextField("Ingresar un cliente a la base de datos");
    	proceso.setEditable(false);
    	proceso.setAlignment(Pos.CENTER);
    	proceso.setPrefWidth(500);
    	TextArea detalleproceso = new TextArea("Debe llenar todos los campos correspondientes para ingresar satisfactoriamente un cliente");
    	GridPane formularioingresocl = new GridPane();
    	Label nombre = new Label("Nombre:");
    	Label cedula = new Label("Cedula:");
    	Label celular = new Label("Nro Celular:");
    	Label email = new Label("e-mail:");
    	Button ingresar = new Button("Ingresar");
    	BotonIngresarUsuarioHandlerClass ingresarUsuario = new BotonIngresarUsuarioHandlerClass();
        ingresar.setOnAction(ingresarUsuario);
    	Button cancelar = new Button("Cancelar");
    	formularioingresocl.setPadding(new Insets(10,10,10,10));
    	formularioingresocl.setVgap(10);
    	formularioingresocl.setHgap(10);
    	formularioingresocl.setAlignment(Pos.CENTER);
    	formularioingresocl.add(nombre, 0, 0);
    	formularioingresocl.add(nombrec,1 ,0);
    	formularioingresocl.add(cedula, 0, 1);
    	formularioingresocl.add(cedulac,1 ,1);
    	formularioingresocl.add(celular, 0, 2);
    	formularioingresocl.add(celularc,1 ,2);
    	formularioingresocl.add(email, 0, 3);
    	formularioingresocl.add(emailc,1 ,3);
    	formularioingresocl.add(ingresar, 0, 4);
    	formularioingresocl.add(cancelar,1 ,4);	
    	ingresarcliente.getChildren().addAll(proceso,detalleproceso,formularioingresocl);
/////////////////// Fin Formulario Ingresar Cliente ////////////////////////////    	
    	
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
        MenuItem agregarStock = new MenuItem("Ingresar nuevo Stock"); 
        MenuItem eliminarStock = new MenuItem("Eliminar un Stock Registrado");
        stock.getItems().addAll(agregarStock,eliminarStock);
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

       // vusuario.getChildren().add(visorConsolas);
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
	


	public Scene getEscena() {
		return escenaimperial;
	}

}
