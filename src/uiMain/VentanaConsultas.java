package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import uiMain.VentanaImperial.BotonIngresarConsolaHandlerClass;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;

public class VentanaConsultas {
	VBox consultas = new VBox(15);
	TextField textconsulta = new TextField();
	GridPane opciones;
	VBox submenu = new VBox(10);
	VBox clpuntos;
	VBox juegoedad;
	HBox histreportes;
	ListView<Cliente> lsclient;
	ListView<Consola>lscons;
	ListView<Periferico>lsper;
	ListView<Juego>lsjuego;
	ListView<Factura>lsfact;
	public VentanaConsultas() {
//////////////////////////// Historial y reportes //////////////////////////////////////////
		histreportes = new HBox(20);
		histreportes.setAlignment(Pos.CENTER);
		MenuBar reportes = new MenuBar();
		Menu repor1 = new Menu("Reportes de ventas");
		MenuItem ganancias = new MenuItem("Ganancias");
		MenuItem prodvendidos = new MenuItem("Productos Mas y Menos Vendidos");
		repor1.getItems().addAll(ganancias,prodvendidos);
		reportes.getMenus().add(repor1);
		
		Button clregistrados = new Button("Clientes registrados");
		ObservableList<Cliente> listaclientes = FXCollections.observableArrayList(Datos.listaClientes);
		lsclient = new ListView();
		lsclient.setItems(listaclientes);
		BotonMostrarClientesRegistrados clreg = new BotonMostrarClientesRegistrados();
        clregistrados.setOnAction(clreg);
        
		Button consdisp = new Button("Consolas disponibles");
		ObservableList<Consola> listaconsolas = FXCollections.observableArrayList(Datos.listaConsolas);
		lscons = new ListView();
		lscons.setItems(listaconsolas);
		BotonMostrarConsolasRegistradas conreg = new BotonMostrarConsolasRegistradas();
        consdisp.setOnAction(conreg);
        
		Button perdisp = new Button("Perifericos disponibles");
		ObservableList<Periferico> listaperifericos = FXCollections.observableArrayList(Datos.listaPerifericos);
		lsper = new ListView();
		lsper.setItems(listaperifericos);
		BotonMostrarPerifericosRegistrados perreg = new BotonMostrarPerifericosRegistrados();
        perdisp.setOnAction(perreg);
        
		Button juegdisp = new Button("Juegos disponibles");
		ObservableList<Juego> listajuegos = FXCollections.observableArrayList(Datos.listaJuegos);
		lsjuego = new ListView();
		lsjuego.setItems(listajuegos);
		BotonMostrarJuegosRegistrados juereg = new BotonMostrarJuegosRegistrados();
        juegdisp.setOnAction(juereg);
        
		Button facturas = new Button("Facturas registradas");
		ObservableList<Factura> listafacturas = FXCollections.observableArrayList(Datos.listaFacturas);
		lsfact = new ListView();
		lsfact.setItems(listafacturas);
		BotonMostrarFacturasRegistradas factreg = new BotonMostrarFacturasRegistradas();
        facturas.setOnAction(factreg);
		
		histreportes.getChildren().addAll(reportes,consdisp,perdisp,juegdisp,facturas,clregistrados);
		
//////////////////////////// Fin Historial y reportes //////////////////////////////////////////
		
		
////////////////////////////Ver cliente con mas puntos //////////////////////////////////////////
		clpuntos = new VBox();
		clpuntos.getChildren().add(new Button("Aqui deberia mostrar el cliente con mas puntos"));
////////////////////////////Fin Ver cliente con mas puntos //////////////////////////////////////////		
		
////////////////////////////Recomendar Juegos por edad //////////////////////////////////////////
		juegoedad = new VBox(10);
		
		TextField edad12 = new TextField("Juegos recomendados para edad de 6 anios a 12 anios inclusive");
		ArrayList<String>juegos12 = new ArrayList<String>();
		for(Juego juego:Datos.listaJuegos) {
			if(juego.getPegi()<=12) {				
				juegos12.add("Nombre del Juego: "+juego.getNombre()+"  ||  "+" Genero: "+juego.getGenero()+"  ||  "+" Precio: "+juego.getPrecio()+"  ||  "+"Edad recomendada para jugar: "+juego.getPegi());
			}
		}
		ObservableList<String> listajuego12 = FXCollections.observableArrayList(juegos12);
		ListView<String>lsjueg12 = new ListView();
		lsjueg12.setItems(listajuego12);
		lsjueg12.setMaxSize(1000, 100);
		
		TextField edad18 = new TextField("Juegos recomendados para edad de mas de 12 anios a 18 anios inclusive");
		ArrayList<String>juegos18 = new ArrayList<String>();
		for(Juego juego:Datos.listaJuegos) {
			if(juego.getPegi()>12&&juego.getPegi()<=18) {	
				juegos18.add("Nombre del Juego: "+juego.getNombre()+"  ||  "+" Genero: "+juego.getGenero()+"  ||  "+" Precio: "+juego.getPrecio()+"  ||  "+"Edad recomendada para jugar: "+juego.getPegi());

			}
		}
		ObservableList<String> listajuego18 = FXCollections.observableArrayList(juegos18);
		ListView<String>lsjueg18 = new ListView();
		lsjueg18.setItems(listajuego18);
		lsjueg18.setMaxSize(1000, 100);
		
		TextField edadmas18 = new TextField("Juegos recomendados para edad de +18 anios");
		ArrayList<String>juegosmas18 = new ArrayList<String>();
		for(Juego juego:Datos.listaJuegos) {
			if(juego.getPegi()>18) {	
				juegosmas18.add("Nombre del Juego: "+juego.getNombre()+"  ||  "+" Genero: "+juego.getGenero()+"  ||  "+" Precio: "+juego.getPrecio()+"  ||  "+"Edad recomendada para jugar: "+juego.getPegi());

			}			
		}
		ObservableList<String> listajuegomas18 = FXCollections.observableArrayList(juegosmas18);
		ListView<String>lsjuegmas18 = new ListView();
		lsjuegmas18.setItems(listajuegomas18);
		lsjuegmas18.setMaxSize(1000, 100);
		
		
		juegoedad.getChildren().addAll(edad12,lsjueg12,edad18,lsjueg18,edadmas18,lsjuegmas18);
		
		
////////////////////////////Fin recomendar juegos por edad //////////////////////////////////////////	
		consultas.setAlignment(Pos.CENTER);
		consultas.setPadding(new Insets(10,10,10,10));
		TextField cons = new TextField("Consultas IMPERIAL-GAMING");
		cons.setScaleX(1.2);
		cons.setScaleY(1.2);
		cons.setMaxWidth(500);
    	cons.setEditable(false);
    	cons.setAlignment(Pos.CENTER);
		String submenuimperial[] = {"Modificar Precios","Ver Historial y Reportes","Ver Cliente Con Mas Puntos","Recomendar Juegos Por Edad"};
		ComboBox menu = new ComboBox(FXCollections.observableArrayList(submenuimperial));
		menu.valueProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue x,String y,String t) {
    			textconsulta.setText(t);
    		}
    	});
		
		
		Image imagens1= new Image("file:src/img/lupa.png");
		ImageView imagens11 = new ImageView(imagens1);
		imagens11.setFitWidth(30);
		imagens11.setFitHeight(20);
		Button consultar = new Button("Consultar", imagens11);
		consultar.setScaleX(1.1);
		consultar.setScaleY(1.1);
		Button salir = new Button("Salir");
		salir.setScaleX(1.1);
		salir.setScaleY(1.1);
		BotonSalir botonsalir = new BotonSalir();
        salir.setOnAction(botonsalir);
		
		
		menu.setPromptText("Seleccione una opcion");
		BotonConsultaHandlerClass ingresarConsola = new BotonConsultaHandlerClass();
        consultar.setOnAction(ingresarConsola);
		opciones = new GridPane();
		opciones.setPadding(new Insets(10,10,10,10));
		opciones.setVgap(20);
		opciones.setHgap(30);
		opciones.add(menu, 0, 0);
		opciones.add(consultar, 1, 0);
		opciones.add(salir, 2, 0);
		submenu.getChildren().add(opciones);
		submenu.getChildren().add(1,new VBox());
		submenu.getChildren().add(2,new VBox());
		
		consultas.getChildren().addAll(cons,submenu);
	}
	
	
	class BotonConsultaHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			
			String consulta = textconsulta.getText();
			if(consulta.equals("Modificar Precios")) {
				
			}
			else if(consulta.equals("Ver Historial y Reportes")) {
				submenu.getChildren().set(1, histreportes);
			}
			else if(consulta.equals("Ver Cliente Con Mas Puntos")) {
				submenu.getChildren().set(1, clpuntos);
				
			}else if(consulta.equals("Recomendar Juegos Por Edad")) {
				submenu.getChildren().set(1,juegoedad);			
			}
		}
	}
	
	class BotonMostrarClientesRegistrados implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			submenu.getChildren().set(2,lsclient);
			
		}
	}
	
	class BotonMostrarConsolasRegistradas implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			submenu.getChildren().set(2, lscons);
			
			
		}
	}
	
	class BotonMostrarPerifericosRegistrados implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			submenu.getChildren().set(2, lsper);
			
			
		}
	}
	
	class BotonMostrarFacturasRegistradas implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			submenu.getChildren().set(2, lsfact);
			
		}
	}
	
	class BotonMostrarJuegosRegistrados implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			submenu.getChildren().set(2, lsjuego);
		}
	}
	
	class BotonSalir implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			VentanaInicial.window.setScene(new VentanaImperial().getEscena());
		}
	}

}
	


