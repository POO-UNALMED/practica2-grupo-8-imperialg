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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModificarPeriferico extends VBox {


    VBox modificarPeriferico;
    ComboBox listaperif;
    FieldPanel fp;



    public ModificarPeriferico(){

        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso

        Proceso procesop = new Proceso("Ingresar un Periferico a la Base De Datos");
        //Textfield con el detalle del proceso

        DetalleProceso detalleprocesop = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar un Periferico");

        //Formulario:

        String[] criterios = new String[] {"Nombre", "Precio", "Plataforma"};
        String[] booleanos = new String[] {"Uso"};
        fp = new FieldPanel("Perifericos", criterios, "Datos periferico", null,booleanos);

        //Creacion botones:

        Button modificarper = new Button("Modificar");
        Button eliminarper = new Button("Cancelar");


        //Interactividad:

        ComboBoxPerifericoSeleccionado comboBoxPerifericoSeleccionado = new ComboBoxPerifericoSeleccionado();
        listaperif.setOnAction(comboBoxPerifericoSeleccionado);

        BotonModificarPeriferico botonModificarPeriferico = new BotonModificarPeriferico();
        modificarper.setOnAction(botonModificarPeriferico);

        BotonEliminarPeriferico botonEliminarPeriferico = new BotonEliminarPeriferico();
        eliminarper.setOnAction(botonEliminarPeriferico);


        HBox hbox = new HBox();
        hbox.getChildren().addAll(modificarper, eliminarper);

        //Anadir elementos al vbox
        modificarPeriferico.getChildren().addAll(procesop, detalleprocesop, listaperif,fp, hbox);


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
            fp.getCampo("Nombre").setText(periferico.getNombre());
            fp.getCampo("Precio").setText(Float.toString(periferico.getPrecio()));
            fp.getCampo("Plataforma").setText(periferico.getPlataforma());
            Boolean uso = periferico.getUso();
            if (uso == true){
                fp.getCheckBox("Uso").setSelected(true);
            } else if(uso == false){
                fp.getCheckBox("Uso").setSelected(false);
            }
            listaperif.getItems().clear();
            listaperif.setItems(FXCollections.observableArrayList(Datos.listaPerifericos));
        }
    }


    //Modificar atributos de la consola cuando se presiona el boton modificar:
    class BotonModificarPeriferico implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Periferico periferico = (Periferico) listaperif.getSelectionModel().getSelectedItem();
            periferico.setNombre(fp.getValue("Nombre"));
            periferico.setPrecio(Float.parseFloat(fp.getValue("Precio")));
            if(fp.getCondicion("Uso") == true) {
                periferico.setUso(true);
            }else if(fp.getCondicion("Uso") == false) {
                periferico.setUso(false);
            }
            listaperif.getItems().clear();
            listaperif.setItems(FXCollections.observableArrayList(Datos.listaPerifericos));
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
