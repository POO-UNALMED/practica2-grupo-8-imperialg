package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Juego;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ModificarJuego {
    ObservableList<Juego> listajuegos = FXCollections.observableArrayList(Datos.listaJuegos);
    VBox modificarJuego;
    ComboBox listamj = new ComboBox(listajuegos);
    TextField nombrejueg = new TextField();
    TextField usojueg = new TextField();
    TextField preciojueg = new TextField();
    TextField pegijueg = new TextField();
    TextField plataformajueg = new TextField();
    TextField generojueg = new TextField();

    public ModificarJuego(){
        /////////////////// Inicio Formulario Ingresar Juego ////////////////////////////
        modificarJuego = new VBox(50);
        modificarJuego.setAlignment(Pos.CENTER);
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
            public void changed(ObservableValue x, String y, String t) {
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
        modificarJuego.getChildren().addAll(procesoj, detalleprocesoj,listamj, formularioingresojuego);
/////////////////// Fin Formulario Ingresar Juego ////////////////////////////
    }

    public VBox getModificarJuego() {
        return modificarJuego;
    }
}
