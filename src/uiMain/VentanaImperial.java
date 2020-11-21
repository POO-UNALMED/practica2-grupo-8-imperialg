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
	
	VBox ingresarpreriferico;
	TextField nombreperif = new TextField();
	TextField usoperif = new TextField();
	TextField precioperif = new TextField();
	TextField plataformaperif = new TextField();

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
    	nombre.setScaleX(1.1);
    	nombre.setScaleY(1.1);
    	Label cedula = new Label("Cedula:");
    	cedula.setScaleX(1.1);
    	cedula.setScaleY(1.1);
    	Label celular = new Label("Nro Celular:");
    	celular.setScaleX(1.1);
    	celular.setScaleY(1.1);
    	Label email = new Label("e-mail:");
    	email.setScaleX(1.1);
    	email.setScaleY(1.1);
    	Button ingresar = new Button("Ingresar");    	
    	BotonIngresarUsuarioHandlerClass ingresarUsuario = new BotonIngresarUsuarioHandlerClass();
        ingresar.setOnAction(ingresarUsuario);
        ConfirmarIngresoUHandlerClass mensajeconfirmacion = new ConfirmarIngresoUHandlerClass();
        ingresar.setOnAction(mensajeconfirmacion);
    	Button cancelar = new Button("Cancelar");
    	DevolverDefectoUHandlerClass devolverdefectou = new DevolverDefectoUHandlerClass();
    	cancelar.setOnAction(devolverdefectou);
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
    	ingresarconsola = new VBox(50);
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
    	ComboBox<String> usoconsola = new ComboBox<String>();
    	usoconsola.getItems().addAll("Nueva","Usada");
    	usoconsola.setPromptText("Seleccione una opcion");
    	usoconsola.valueProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue x,String y,String t) {
    			usocons.setText(t);
    		}
    	});    	
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
        ConfirmarIngresoCHandlerClass mensajeconfirmacionc = new ConfirmarIngresoCHandlerClass();
        ingresarcon.setOnAction(mensajeconfirmacionc);
        Button cancelarcon = new Button("Cancelar");
    	formularioingresocons1.setPadding(new Insets(10,10,10,10));
    	formularioingresocons1.setVgap(20);
    	formularioingresocons1.setHgap(20);
    	formularioingresocons1.setAlignment(Pos.CENTER);
    	formularioingresocons1.add(nombrecon, 0, 0);
    	formularioingresocons1.add(nombrecons,1 ,0);
    	formularioingresocons1.add(usocon, 0, 1);
    	formularioingresocons1.add(usoconsola,1 ,1);
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
		ingresarjuego = new VBox(50);
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
		nombrejuego.setScaleX(1.1);
		nombrejuego.setScaleY(1.1);
		Label usojuego = new Label("Uso del Juego:");
		ComboBox<String> usojue = new ComboBox<String>();
    	usojue.getItems().addAll("Nuevo","Usado");
    	usojue.setPromptText("Seleccione una opcion");
    	usojue.valueProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue x,String y,String t) {
    			usojueg.setText(t);
    		}
    	});    	
		usojuego.setScaleX(1.1);
		usojuego.setScaleY(1.1);
		Label preciojuego = new Label("Precio:");
		preciojuego.setScaleX(1.1);
		preciojuego.setScaleY(1.1);
		Label pegijuego = new Label("Pegi:");
		pegijuego.setScaleX(1.1);
		pegijuego.setScaleY(1.1);
		Label plataformajuego = new Label("Plataforma Asociada:");
		plataformajuego.setScaleX(1.1);
		plataformajuego.setScaleY(1.1);
		Label generojuego = new Label("Genero:");
		generojuego.setScaleX(1.1);
		generojuego.setScaleY(1.1);
		Button ingresarjueg = new Button("Ingresar");
		BotonIngresarJuegoHandlerClass ingresarJuego = new BotonIngresarJuegoHandlerClass();
		ingresarjueg.setOnAction(ingresarJuego);
		ConfirmarIngresoJHandlerClass confirmacionjuegoc = new ConfirmarIngresoJHandlerClass();
		ingresarjueg.setOnAction(confirmacionjuegoc);
		Button cancelarjueg = new Button("Cancelar");
		formularioingresojuego.setPadding(new Insets(10, 10, 10, 10));
		formularioingresojuego.setVgap(20);
		formularioingresojuego.setHgap(20);
		formularioingresojuego.setAlignment(Pos.CENTER);
		formularioingresojuego.add(nombrejuego, 0, 0);
		formularioingresojuego.add(nombrejueg, 1, 0);
		formularioingresojuego.add(usojuego, 0, 1);
		formularioingresojuego.add(usojue, 1, 1);
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
		
		
/////////////////// Inicio Formulario Ingresar Periferico ////////////////////////////
		ingresarpreriferico = new VBox(50);
		ingresarpreriferico.setAlignment(Pos.CENTER);
		TextField procesop = new TextField("Ingresar un Periferico a la Base De Datos");
		procesop.setMaxWidth(500);
		procesop.setEditable(false);
		procesop.setAlignment(Pos.CENTER);
		TextField detalleprocesop = new TextField("Debe llenar todos los campos correspondientes para ingresar un Periferico");
		detalleprocesop.setAlignment(Pos.CENTER);
		detalleprocesop.setMaxWidth(800);
		detalleprocesop.setEditable(false);
		GridPane formularioingresop = new GridPane();
		Label nombreper = new Label("Nombre:");
		nombreper.setScaleX(1.1);
		nombreper.setScaleY(1.1);
		Label usoper = new Label("Uso del Periferico:");
		ComboBox<String> usop = new ComboBox<String>();
    	usop.getItems().addAll("Nuevo","Usado");
    	usop.setPromptText("Seleccione una opcion");
    	usop.valueProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue x,String y,String t) {
    			usoperif.setText(t);
    		}
    	});    	
		usoper.setScaleX(1.1);
		usoper.setScaleY(1.1);
		Label precioper = new Label("Precio:");
		precioper.setScaleX(1.1);
		precioper.setScaleY(1.1);
		Label plataformaper = new Label("Plataforma asociada:");
		plataformaper.setScaleX(1.1);
		plataformaper.setScaleY(1.1);
		Button ingresarper = new Button("Ingresar");
		BotonIngresarPerifericoHandlerClass  ingresarperiferico = new BotonIngresarPerifericoHandlerClass();
		ingresarper.setOnAction(ingresarperiferico);
		ConfirmarIngresoPHandlerClass confirmacionper = new ConfirmarIngresoPHandlerClass();
		ingresarper.setOnAction(confirmacionper);
		Button cancelarper = new Button("Cancelar");
		formularioingresop.setPadding(new Insets(10, 10, 10, 10));
		formularioingresop.setVgap(20);
		formularioingresop.setHgap(20);
		formularioingresop.setAlignment(Pos.CENTER);
		formularioingresop.add(nombreper, 0, 0);
		formularioingresop.add(nombreperif, 1, 0);
		formularioingresop.add(usoper, 0, 1);
		formularioingresop.add(usop, 1, 1);
		formularioingresop.add(precioper, 0, 2);
		formularioingresop.add(precioperif, 1, 2);
		formularioingresop.add(plataformaper, 0, 3);
		formularioingresop.add(plataformaperif, 1, 3);
		formularioingresop.add(ingresarper, 0, 4);
		formularioingresop.add(cancelarper, 1, 4);
		ingresarpreriferico.getChildren().addAll(procesop, detalleprocesop, formularioingresop);
/////////////////// Fin Formulario Ingresar Periferico //////////////////////////////
    	
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
        agregarPerifericoHandlerClass handlerper = new agregarPerifericoHandlerClass();
        agregarPeriferico.setOnAction(handlerper);
        MenuItem eliminarStock = new MenuItem("Eliminar un Stock Registrado");
        stock.getItems().addAll(agregarStock,eliminarStock);
        agregarStock.getItems().addAll(agregarConsola,agregarJuego,agregarPeriferico);
        
        //Agregar menus:
        barramenu.getMenus().addAll(archivo, procon, aiuda);        
        vusuario.getChildren().add(barramenu);
        TextField txt = new TextField("A continuacion seleccione los productos que desea comprar");
		txt.setAlignment(Pos.CENTER);
		txt.setMaxWidth(700);
		txt.setEditable(false);
        //vusuario.getChildren().add(txt);
        //vusuario.setAlignment(Pos.CENTER);


        ListView<String> visorConsolas = new ListView<String>();
        ArrayList<String> listaPrueba = new ArrayList<String>();
        for (Consola consola: Datos.listaConsolas){
            listaPrueba.add(consola.getNombre());
        }
        ObservableList<String> listica = FXCollections.observableArrayList(listaPrueba);
        visorConsolas.setItems(listica);

		//Creacion de combobox para mostrar consolas, perifericos y juegos:

		//Importacion de listas:
		ObservableList<Consola> listaconsolas = FXCollections.observableArrayList(Datos.listaConsolas);
		ObservableList<Periferico> listaperifericos = FXCollections.observableArrayList(Datos.listaPerifericos);
		ObservableList<Juego> listajuegos = FXCollections.observableArrayList(Datos.listaJuegos);



		//Creacion de ComboBoxes:
		ComboBox comboJuegos = new ComboBox(listajuegos);
		ComboBox comboPerifericos = new ComboBox(listaperifericos);
		ComboBox comboConsolas = new ComboBox(listaconsolas);
		comboJuegos.setPromptText("Seleccione Juegos");
		comboJuegos.setPrefWidth(750);
		comboPerifericos.setPromptText("Seleccione Perifericos");
		comboPerifericos.setPrefWidth(750);
		comboConsolas.setPromptText("Seleccione Consolas");
		comboConsolas.setPrefWidth(750);
		
		//Creacion de Array de carrito e implementacion:
		ArrayList<Detalle> carrito = new ArrayList<Detalle>();
		ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
		ListView<Detalle> lista = new ListView<Detalle>(items);
		lista.setItems(items);


		//Textfield con las unidades del carrito:
		TextField cantidad1 = new TextField("Unidades de Consola");
		TextField cantidad2 = new TextField("Unidades de Juego");
		TextField cantidad3 = new TextField("Unidades de Periferico");

		//Botones para añadir productos al carrito:

		Button sendConsolas = new Button("Agregar al carrito");
		Button sendJuegos = new Button("Agregar al carrito");
		Button sendPerifericos = new Button("Agregar al carrito");

		//Creacion de Hbox para los respectivos ingresos del usuario al carrito
		HBox pane1 = new HBox();
		HBox pane2 = new HBox();
		HBox pane3 = new HBox();

		//Anadir elementos a los Hbox:
		
		pane1.getChildren().addAll(comboConsolas, cantidad1, sendConsolas);
		pane2.getChildren().addAll(comboJuegos,cantidad2,sendJuegos);
		pane3.getChildren().addAll(comboPerifericos,cantidad3,sendPerifericos);
	

		//Anadir juegos al carrito:

		sendJuegos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int cantidad = Integer.parseInt(cantidad2.getText());
				Juego producto = (Juego) comboJuegos.getSelectionModel().getSelectedItem();
				Detalle detalle = new Detalle(producto,producto.getPrecio(),"Venta", cantidad);
				carrito.add(detalle);
				ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
				lista.setItems(items);
				lista.refresh();
			}
		});

		//Anadir Consolas al carrito:

		sendConsolas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int cantidad = Integer.parseInt(cantidad1.getText());
				Consola producto = (Consola) comboConsolas.getSelectionModel().getSelectedItem();
				Detalle detalle = new Detalle(producto,producto.getPrecio(),"Venta", cantidad);
				carrito.add(detalle);
				ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
				lista.setItems(items);
				lista.refresh();
			}
		});

		//Anadir perifericos al carrito:

		sendPerifericos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int cantidad = Integer.parseInt(cantidad3.getText());
				Periferico producto = (Periferico) comboPerifericos.getSelectionModel().getSelectedItem();
				Detalle detalle = new Detalle(producto,producto.getPrecio(),"Venta", cantidad);
				carrito.add(detalle);
				ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
				lista.setItems(items);
				lista.refresh();
			}
		});

		//Eliminar elementos del carrito con doble clic:

		lista.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)){
					if(event.getClickCount()==2){
						Detalle detaller = (Detalle) lista.getSelectionModel().getSelectedItem();
						carrito.remove(detaller);
						ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
						lista.setItems(items);
						lista.refresh();
					}
				}
			}
		});

		//Boton para refrescar los detalles:
		Button botonrefresh = new Button("Refrescar");
		botonrefresh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				carrito.clear();
				ObservableList<Detalle> items = FXCollections.observableArrayList(carrito);
				lista.setItems(items);
				lista.refresh();
			}
		});
		
		TextField info = new TextField("A continuacion seleccione el Cliente al cual desea aplicar la transaccion");
		info.setAlignment(Pos.CENTER);
		info.setEditable(false);
		info.setMaxWidth(700);

		//Lista observable de clientes:
		ObservableList<Cliente> listaClientes= FXCollections.observableArrayList(Datos.listaClientes);
		ComboBox comboClientes = new ComboBox(listaClientes);



		//Boton para generar una transaccion:
		Button generarF = new Button("Finalizar transaccion");
		generarF.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Cliente cliente = (Cliente) comboClientes.getSelectionModel().getSelectedItem();
				Factura factura = new Factura(cliente, carrito);
				System.out.println(factura);

			}
		});
		VBox defecto = new VBox(10);
		defecto.setSpacing(10);
		defecto.setAlignment(Pos.CENTER);
		defecto.setPadding(new Insets(10,10,10,10));
		
		defecto.getChildren().add(pane1);
		defecto.getChildren().add(pane2);
		defecto.getChildren().add(pane3);
		defecto.getChildren().add(lista);
		defecto.getChildren().add(info);
		defecto.getChildren().add(comboClientes);
		defecto.getChildren().addAll(botonrefresh, generarF);
		
		vusuario.getChildren().add(defecto);
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
    
    class ConfirmarIngresoUHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
    		dialogoDescripcion.setHeaderText("Usted acaba de agregar un nuevo Cliente a la base de datos de la tienda.");
    		dialogoDescripcion.setContentText("Proceso Exitoso.");
    		dialogoDescripcion.showAndWait();
    		
    	}
    }
    
    class ConfirmarIngresoCHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
    		dialogoDescripcion.setHeaderText("Usted acaba de agregar una nueva Consola a la base de datos de la tienda.");
    		dialogoDescripcion.setContentText("Proceso Exitoso.");
    		dialogoDescripcion.showAndWait();
    		
    	}
    }
    
    class ConfirmarIngresoJHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
    		dialogoDescripcion.setHeaderText("Usted acaba de agregar un nuevo Juego a la base de datos de la tienda.");
    		dialogoDescripcion.setContentText("Proceso Exitoso.");
    		dialogoDescripcion.showAndWait();
    		
    	}
    }
    
    class ConfirmarIngresoPHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
    		dialogoDescripcion.setHeaderText("Usted acaba de agregar un nuevo Periferico a la base de datos de la tienda.");
    		dialogoDescripcion.setContentText("Proceso Exitoso.");
    		dialogoDescripcion.showAndWait();
    		
    	}
    }
    
    class DevolverDefectoUHandlerClass implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		
    	}
    }

	class SalirHandlerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			VentanaInicial.window.setScene(VentanaInicial.escena);
			 VentanaInicial.window.setTitle("IMPERIAL-GAMING");
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
			Boolean uso=false;
			if(usocons.getText().equals("Nueva")) {
				uso  = false;				
			}else if(usocons.getText().equals("Usada")) {
				uso = true;
			}
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
			Boolean uso = false;
			if(usojueg.getText().equals("Nuevo")) {
				uso  = false;				
			}else if(usojueg.getText().equals("Usado")) {
				uso = true;
			}
			Float precio = Float.parseFloat(preciojueg.getText());
			int pegi = Integer.parseInt(pegijueg.getText());
			String plataforma = plataformajueg.getText();
			String genero = generojueg.getText();
			Juego.ingresarJuego(nombre, uso, precio, pegi, plataforma, genero);
			
		}
	}
	
	class BotonIngresarPerifericoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			String nombre = nombreperif.getText();
			Boolean uso = false;
			if(usoperif.getText().equals("Nuevo")) {
				uso  = false;				
			}else if(usoperif.getText().equals("Usado")) {
				uso = true;
			}
			Float precio = Float.parseFloat(precioperif.getText());
			String plataforma = plataformaperif.getText();
			Periferico.ingresarPeriferico(nombre, uso, precio, plataforma);
		}
	}
	
	class  agregarPerifericoHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			vusuario.getChildren().set(1, ingresarpreriferico);
		}
	}
	
	public  Scene getEscena() {
		return escenaimperial;
	}

}