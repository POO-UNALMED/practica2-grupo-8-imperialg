package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
import gestorAplicacion.producto.Periferico;
import gestorAplicacion.transacciones.Cliente;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ModificarPeriferico {
    //Importar datos:
    ObservableList<Periferico> listaperifericos = FXCollections.observableArrayList(Datos.listaPerifericos);

    //Nodos a utilizar:

    VBox modificarPeriferico;

    ComboBox listaperif = new ComboBox(listaperifericos);
    TextField nombreperif = new TextField();
    TextField usoperif = new TextField();
    TextField precioperif = new TextField();
    TextField plataformaperif = new TextField();
    ComboBox<String> usop = new ComboBox<String>();


    public ModificarPeriferico(){

        //Creacion de Vbox para modificar periferico:

        modificarPeriferico = new VBox(50);
        modificarPeriferico.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso

        TextField procesop = new TextField("Ingresar un Periferico a la Base De Datos");
        procesop.setMaxWidth(500);
        procesop.setEditable(false);
        procesop.setAlignment(Pos.CENTER);

        //Textfield con el detalle del proceso

        TextField detalleprocesop = new TextField("Debe llenar todos los campos correspondientes para ingresar un Periferico");
        detalleprocesop.setAlignment(Pos.CENTER);
        detalleprocesop.setMaxWidth(800);
        detalleprocesop.setEditable(false);

        //Gridpane con formulario

        GridPane formularioingresop = new GridPane();

        //Campos del formulario:

        //Campo nombre:

        Label nombreper = new Label("Nombre:");
        nombreper.setScaleX(1.1);
        nombreper.setScaleY(1.1);

        //Campo uso:

        Label usoper = new Label("Uso del Periferico:");
        usop.getItems().addAll("Nuevo","Usado");
        usop.setPromptText("Seleccione una opcion");
        usop.valueProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue x, String y, String t) {
                usoperif.setText(t);
            }
        });
        usoper.setScaleX(1.1);
        usoper.setScaleY(1.1);

        //Campo precio:

        Label precioper = new Label("Precio:");
        precioper.setScaleX(1.1);
        precioper.setScaleY(1.1);

        //Campo plataforma
        Label plataformaper = new Label("Plataforma asociada:");
        plataformaper.setScaleX(1.1);
        plataformaper.setScaleY(1.1);

        //Botones modificar y cancelar

        Button modificarper = new Button("Modificar");
        Button cancelarper = new Button("Cancelar");

        //Agregar campos a formulario:

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
        formularioingresop.add(modificarper, 0, 4);
        formularioingresop.add(cancelarper, 1, 4);

        //Interactividad:

        ComboBoxPerifericoSeleccionado comboBoxPerifericoSeleccionado = new ComboBoxPerifericoSeleccionado();
        listaperif.setOnAction(comboBoxPerifericoSeleccionado);

        BotonModificarPeriferico botonModificarPeriferico = new BotonModificarPeriferico();
        modificarper.setOnAction(botonModificarPeriferico);

        //Anadir elementos al vbox
        modificarPeriferico.getChildren().addAll(procesop, detalleprocesop, listaperif,formularioingresop);


    }

    public VBox getModificarPeriferico() {
        return modificarPeriferico;
    }

    //Clases anonimas:
    //Seleccionar un perfererico y que se rellenen automaticamente los textfield:
    class ComboBoxPerifericoSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            Periferico periferico = (Periferico) listaperif.getSelectionModel().getSelectedItem();
            nombreperif.setText(periferico.getNombre());
            precioperif.setText(Float.toString(periferico.getPrecio()));
            plataformaperif.setText(periferico.getPlataforma());
            Boolean uso = periferico.getUso();
            if (uso == true){
                usop.getSelectionModel().select(2);
            } else if(!uso){
                usop.getSelectionModel().select(1);
            }
        }
    }


    //Modificar atributos de la consola cuando se presiona el boton modificar:
    class BotonModificarPeriferico implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Periferico periferico = (Periferico) listaperif.getSelectionModel().getSelectedItem();
            periferico.setNombre(nombreperif.getText());
            periferico.setPrecio(Float.parseFloat(precioperif.getText()));
            if(usoperif.getText().equals("Nueva")) {
                periferico.setUso(false);
            }else if(usoperif.getText().equals("Usada")) {
                periferico.setUso(true);
            }
            Periferico.perifericosRegistrados();

        }

    }

    //Eliminar un periferico de la base de datos:

    class BotonEliminarPeriferico implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Periferico periferico = (Periferico) listaperif.getSelectionModel().getSelectedItem();
            Datos.listaPerifericos.remove(periferico);
        }
    }
}
