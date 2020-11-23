package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import gestorAplicacion.transacciones.Detalle;
import gestorAplicacion.transacciones.Factura;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.util.ArrayList;


public class VentanaConsultas {
	VBox consultas = new VBox(15);
	TextField textconsulta = new TextField();
	GridPane opciones;
	VBox submenu = new VBox(10);
	VBox clpuntos;
	VBox juegoedad;
	HBox histreportes;
	VBox gananciastienda;
	VBox masmenosvendidos;
	
	ListView<Cliente> lsclient;
	ListView<Consola>lscons;
	ListView<Periferico>lsper;
	ListView<Juego>lsjuego;
	ListView<Factura>lsfact;
	Cliente cl;
	public VentanaConsultas() {
//////////////////////////// Historial y reportes //////////////////////////////////////////
		histreportes = new HBox(20);
		histreportes.setAlignment(Pos.CENTER);
		MenuBar reportes = new MenuBar();
		Menu repor1 = new Menu("Reportes de ventas");
		MenuItem ganancias = new MenuItem("Ganancias");
		GananciasHandlerClass handler = new GananciasHandlerClass();
		ganancias.setOnAction(handler);		
		MenuItem prodvendidos = new MenuItem("Productos Mas y Menos Vendidos");
		MasMenosVendidosHandlerClass handlermnv = new MasMenosVendidosHandlerClass();
		prodvendidos.setOnAction(handlermnv);	
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
		clpuntos = new VBox(20);
		clpuntos.setAlignment(Pos.CENTER);				
		int aux = 0;
 		cl=null;
 		for(Cliente cliente:Datos.listaClientes ) {
 			
 			if(cliente.getPuntos()>aux) {
 				aux = cliente.getPuntos();
 				cl = cliente;
 			}
 		}
 		
 		if(cl.getPuntos()>=20) {
 			TextField clp = new TextField("El cliente "+cl.getNombre()+" Tiene un bono de COP $ 300.000 en nuestra tienda por alcanzar los 20 puntos ");
 			TextField desea = new TextField("Desea redimir el bono al cliente " + cl.getNombre() + " ?");
 			desea.setEditable(false);
 			desea.setMaxWidth(500);
 			desea.setAlignment(Pos.CENTER);
 			clp.setEditable(false);
 			clp.setMaxWidth(800);
 			clp.setAlignment(Pos.CENTER);
 			Button redimir = new Button("Redimir Bono");
 			BotonRedimir redimirptos = new BotonRedimir();
 	        redimir.setOnAction(redimirptos);
 			Button noredimir = new Button("NO Redimir"); 
 			BotonNoRedimir noredimirptos = new BotonNoRedimir();
 	        noredimir.setOnAction(noredimirptos);
 	        HBox red = new HBox(15);
 	        red.setAlignment(Pos.CENTER); 	        
 	        red.getChildren().addAll(redimir,noredimir);
 			clpuntos.getChildren().addAll(clp,desea,red);
 		}else {
 			TextField faltanptos = new TextField("Al cliente "+cl.getNombre()+" le faltan "+(20-cl.getPuntos())+" puntos para ganar un bono ");
 			faltanptos.setEditable(false);
 			faltanptos.setMaxWidth(700);
 			faltanptos.setAlignment(Pos.CENTER);
 			clpuntos.getChildren().add(faltanptos);
 		}			
////////////////////////////Fin Ver cliente con mas puntos //////////////////////////////////////////		
		
////////////////////////////Recomendar Juegos por edad //////////////////////////////////////////
		juegoedad = new VBox(15);
		juegoedad.setAlignment(Pos.CENTER);
		TextField edad12 = new TextField("Juegos recomendados para edad de 6 anios a 12 anios inclusive");
		edad12.setMaxWidth(500);
		edad12.setEditable(false);
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
		edad18.setMaxWidth(500);
		edad18.setEditable(false);
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
		edadmas18.setMaxWidth(500);
		edadmas18.setEditable(false);
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
		
		
//////////////////////////// Ver Ganancias de la tienda //////////////////////////////////////////
		ListView<String>gananciass = new ListView();
		ArrayList<String> consolasmv = new ArrayList<String>();
		
		TextField totalganancias;		
		gananciastienda = new VBox(10);
		gananciastienda.setAlignment(Pos.CENTER);
		TextField textoganancias = new TextField("Total de ganancias por venta de Consolas");
		textoganancias.setAlignment(Pos.CENTER);
		textoganancias.setMaxWidth(500);
		textoganancias.setEditable(false);	
	        ArrayList<String> nombres = Consola.productosVendidos();        
	        ArrayList<String> nombresUnicos = new ArrayList<String>();
	        
	        for (String nombre: nombres){
	            if(!nombresUnicos.contains(nombre))
	                nombresUnicos.add(nombre);
	        }
	        
	        
	        consolasmv.add("Nombre de la Consola"+"       ||      "+"Unidades Vendidas"+ "    ||    "+"Precio por unidad"+"    ||    "+" Subtotal "+"\n");
	        Float total = (float) 0;
	        for (String nombre: nombresUnicos){
	        	total += Consola.precioss(nombre);
	            consolasmv.add("    "+nombre + "                           " +Consola.unidadess(nombre) +" undidades                 "+Consola.precioConsola(nombre)+"$ COP "+"              "+Consola.precioss(nombre));
	        }totalganancias=new TextField("***** TOTAL DE GANANCIAS POR VENTA DE CONSOLAS: " + "COP $ " + total + " *****");
	        totalganancias.setAlignment(Pos.CENTER);
	        ObservableList<String> totalgananciass = FXCollections.observableArrayList(consolasmv);
	        gananciass.setItems(totalgananciass);
	        gananciass.setMaxSize(700, 130);
	        
	        
	        
			ListView<String>gananciasjuegos = new ListView();
			ArrayList<String> juegosmv = new ArrayList<String>();
			TextField totalgananciasj;
			TextField textogananciasj = new TextField("Total de ganancias por venta de Juegos");
			textogananciasj.setAlignment(Pos.CENTER);
			textogananciasj.setMaxWidth(500);
			textogananciasj.setEditable(false);	
	        ArrayList<String> nombresj = Juego.productosVendidos();        
	        ArrayList<String> nombresUnicosj = new ArrayList<String>();
	        
	        for (String nombre: nombresj){
	            if(!nombresUnicosj.contains(nombre))
	                nombresUnicosj.add(nombre);
	        }
	        juegosmv.add("Nombre del Juego "+"       ||      "+"Unidades Vendidas "+ "    ||    "+"Precio por unidad"+"    ||    "+" Subtotal ");
	        Float totalj = (float) 0;
	        for (String nombrej: nombresUnicosj){
	        	totalj += Juego.precioss(nombrej);
	            juegosmv.add("    "+nombrej + "                           " +Juego.unidadess(nombrej) +" undidades                 "+Juego.precioJuego(nombrej)+"$ COP "+"              "+Juego.precioss(nombrej));
	        } totalgananciasj = new TextField("***** TOTAL DE GANANCIAS POR VENTA DE JUEGOS: "  + "COP $ " + totalj + " *****");
	        totalgananciasj.setAlignment(Pos.CENTER);
	        ObservableList<String> totalgananciassj = FXCollections.observableArrayList(juegosmv);
	        gananciasjuegos.setItems(totalgananciassj);
	        gananciasjuegos.setMaxSize(700, 130);

	        
			ListView<String>gananciasperif = new ListView();
			ArrayList<String> perifericosmv = new ArrayList<String>();
			TextField totalgananciasp;
			TextField textogananciasp = new TextField("Total de ganancias por venta de Perifericos");
			textogananciasp.setAlignment(Pos.CENTER);
			textogananciasp.setMaxWidth(500);
			textogananciasp.setEditable(false);	
	        ArrayList<String> nombresp = Periferico.productosVendidos();        
	        ArrayList<String> nombresUnicosp = new ArrayList<String>();
	        
	        for (String nombre: nombresp){
	            if(!nombresUnicosp.contains(nombre))
	                nombresUnicosp.add(nombre);
	        }
	        perifericosmv.add("Nombre del Periferico"+"       ||      "+"Unidades Vendidas"+ "    ||    "+"Precio por unidad"+"    ||    "+" Subtotal ");
	        Float totalp = (float) 0;
	        for (String nombrep: nombresUnicosp){
	        	totalp += Periferico.precioss(nombrep);
	            perifericosmv.add("    "+nombrep + "                           " +Periferico.unidadess(nombrep) +" undidades                 "+Periferico.precioPeriferico(nombrep)+"$ COP "+"              "+Periferico.precioss(nombrep));
	        } totalgananciasp = new TextField("***** TOTAL DE GANANCIAS POR VENTA DE PERIFERICOS: "+ "COP $"+ totalp +"  *****"); 
	        totalgananciasp.setAlignment(Pos.CENTER);
	        ObservableList<String> totalgananciassp = FXCollections.observableArrayList(perifericosmv);
	        gananciasperif.setItems(totalgananciassp);
	        gananciasperif.setMaxSize(700,130);
	        gananciastienda.getChildren().addAll(textoganancias,gananciass,totalganancias,textogananciasj,gananciasjuegos,totalgananciasj,textogananciasp,gananciasperif,totalgananciasp);
	        
	
//////////////////////////// Fin ver Ganancias de la tienda //////////////////////////////////////////
	        
	        
	        
////////////////////////////Ver productos mas y menos vendidos ///////////////////////////////////////////
	       	        
	        masmenosvendidos = new VBox(15);
	        
	        TextField consmasv;
	        TextField consmenv;	
	        ArrayList<Integer> cantidadesunidadc = new ArrayList<Integer>();
	        for (String nombre: nombresUnicos){
	            cantidadesunidadc.add(Consola.unidadess(nombre));
	        }
	        
	        int auxcmn = 0;
	        String scmn = "";
	        for(int x=0;x<cantidadesunidadc.size();x++) {
	        	if(cantidadesunidadc.get(x)>auxcmn) {
	        		auxcmn = cantidadesunidadc.get(x);
	        		scmn = nombresUnicos.get(x);
	        	}
	        }consmasv = new TextField("NOMBRE DE LA CONSOLA MAS VENDIDA: "+scmn+"  ||  "+"Unidades Vendidas: "+auxcmn);
	        
	        int auxcmn1 = cantidadesunidadc.get(0);
	        String scmn1 = "";
	        for(int x=0;x<cantidadesunidadc.size();x++) {
	        	if(cantidadesunidadc.get(x)<=auxcmn1) {
	        		auxcmn1 = cantidadesunidadc.get(x);
	        		scmn1 = nombresUnicos.get(x);
	        	}
	        }consmenv = new TextField("NOMBRE DE LA CONSOLA MENOS VENDIDA: "+scmn1+"  ||  "+"Unidades Vendidas: "+auxcmn1);
	        consmasv.setAlignment(Pos.CENTER);
			consmasv.setMaxWidth(800);
			consmasv.setEditable(false);
			consmenv.setAlignment(Pos.CENTER);
			consmenv.setMaxWidth(800);
			consmenv.setEditable(false);
	        
	        TextField juemasv; 
	        TextField juemenosv;
	        ArrayList<Integer> cantidadesunidad = new ArrayList<Integer>();
	        for (String nombre: nombresUnicosj){
	            cantidadesunidad.add(Juego.unidadess(nombre));
	        }
	        
	        int auxjmnv = 0;
	        String nombrejmnv = "";
	        for(int x=0;x<cantidadesunidad.size();x++) {
	        	if(cantidadesunidad.get(x)>auxjmnv) {
	        		auxjmnv = cantidadesunidad.get(x);
	        		nombrejmnv = nombresUnicosj.get(x);
	        	}
	        }juemasv = new TextField("NOMBRE DEL JUEGO MAS VENDID0: "+nombrejmnv+"  ||  "+"Unidades Vendidas: "+auxjmnv);
	        
	        int auxjmnv1 = cantidadesunidad.get(0);
	        String nombrejmnv1 = "";
	        for(int x=0;x<cantidadesunidad.size();x++) {
	        	if(cantidadesunidad.get(x)<=auxjmnv1) {
	        		auxjmnv1 = cantidadesunidad.get(x);
	        		nombrejmnv1 = nombresUnicosj.get(x);
	        	}
	        }juemenosv = new TextField("NOMBRE DEL JUEGO MENOS VENDIDO: "+nombrejmnv1+"  ||  "+"Unidades Vendidas: "+auxjmnv1);
	        juemasv.setAlignment(Pos.CENTER);
			juemasv.setMaxWidth(800);
			juemasv.setEditable(false);
			juemenosv.setAlignment(Pos.CENTER);
			juemenosv.setMaxWidth(800);
			juemenosv.setEditable(false);	              
	        
	        TextField perifmasv;
	        TextField perifmensv;
	    
	        ArrayList<Integer> cantidadesunidadp = new ArrayList<Integer>();
	       
	        for (String nombre: nombresUnicosp){
	            cantidadesunidadp.add(Periferico.unidadess(nombre));
	        }
	        
	        int auxpmn = 0;
	        String pmnv = "";
	        for(int x=0;x<cantidadesunidadp.size();x++) {
	        	if(cantidadesunidadp.get(x)>auxpmn) {
	        		auxpmn = cantidadesunidadp.get(x);
	        		pmnv = nombresUnicosp.get(x);
	        	}
	        }perifmasv = new TextField("NOMBRE DEL PERIFERICO MAS VENDIDO: "+pmnv+"  ||  "+"Unidades Vendidas: "+auxpmn);
	        
	        int auxpmn1 = cantidadesunidadp.get(0);
	        String pmnv1 = "";
	        for(int x=0;x<cantidadesunidadp.size();x++) {
	        	if(cantidadesunidadp.get(x)<=auxpmn1) {
	        		auxpmn1 = cantidadesunidadp.get(x);
	        		pmnv1 = nombresUnicosp.get(x);
	        	}
	        }perifmensv = new TextField("NOMBRE DEL PERIFERICO MENOS VENDIDO: "+pmnv1+"  ||  "+"Unidades Vendidas: "+auxpmn1);
	    
	        perifmasv.setAlignment(Pos.CENTER);
			perifmasv.setMaxWidth(800);
			perifmasv.setEditable(false);
			perifmensv.setAlignment(Pos.CENTER);
			perifmensv.setMaxWidth(800);
			perifmensv.setEditable(false);
	        
	        
	        
	        
	        
	        masmenosvendidos.getChildren().addAll(new Label(" "),consmasv,consmenv,new Label(" "),juemasv,juemenosv,new Label(" "),perifmasv,perifmensv);
	        masmenosvendidos.setAlignment(Pos.CENTER);
	        
////////////////////////////Fin ver productos mas y menos vendidos //////////////////////////////////////////
		
		
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
	
	class GananciasHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
		submenu.getChildren().set(2, gananciastienda);
		
		}
	}
	
	class MasMenosVendidosHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			submenu.getChildren().set(2, masmenosvendidos);
		}
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
				if(submenu.getChildren().contains(submenu.getChildren().get(2))) {
					submenu.getChildren().set(2,new Label(""));
				}
				
				
			}else if(consulta.equals("Recomendar Juegos Por Edad")) {
				submenu.getChildren().set(1,juegoedad);
				if(submenu.getChildren().contains(submenu.getChildren().get(2))) {
					submenu.getChildren().set(2,new Label(""));
				}
				
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
	
	class BotonRedimir implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			cl.agregarPunto(0);
			Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
    		dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
    		dialogoDescripcion.setHeaderText("Usted acaba de redimir los puntos del cliente "+cl.getNombre());
    		dialogoDescripcion.setContentText("Proceso Exitoso.");
    		dialogoDescripcion.showAndWait();
    		VentanaInicial.window.setScene(new VentanaImperial().getEscena());
			
		}
	}
	
	class BotonNoRedimir implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			VentanaInicial.window.setScene(new VentanaImperial().getEscena());
		}
	}

}
