package uiMain;

import BaseDatos.Datos;
import errores.tipo1.ErrorCampoVacio;
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
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModificarPeriferico extends VBox {

    ComboBox listaperif;
    FieldPanel fp;
    Periferico periferico;

    public ModificarPeriferico(){
        listaperif = new ComboBox(FXCollections.observableArrayList(Datos.listaPerifericos));
        listaperif.setPromptText("Seleccione un Periferico");
        listaperif.setPrefWidth(500);
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

   
        //Textfield con el titulo del proceso

        Proceso procesop = new Proceso("Ingresar, Eliminar o Modificar un Periferico de la Base De Datos");
        //Textfield con el detalle del proceso

        DetalleProceso detalleprocesop = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar un Periferico");

        //Formulario:

        String[] criterios = new String[] {"Nombre", "Precio", "Plataforma"};
        String[] booleanos = new String[] {"Uso"};
        fp = new FieldPanel("Perifericos", criterios, "Datos periferico", null,booleanos);

        //Creacion botones:

        Button ingresar = new Button("Ingresar");
        Button modificarper = new Button("Modificar");
        Button eliminarper = new Button("Eliminar");
        Button refrescar = new Button("Refrescar Campos");


        //Interactividad:

        ComboBoxPerifericoSeleccionado comboBoxPerifericoSeleccionado = new ComboBoxPerifericoSeleccionado();
        listaperif.setOnAction(comboBoxPerifericoSeleccionado);

        BotonModificarPeriferico botonModificarPeriferico = new BotonModificarPeriferico();
        modificarper.setOnAction(botonModificarPeriferico);

        BotonEliminarPeriferico botonEliminarPeriferico = new BotonEliminarPeriferico();
        eliminarper.setOnAction(botonEliminarPeriferico);

        BotonIngresarPeriferico botonIngresarPeriferico = new BotonIngresarPeriferico();
        ingresar.setOnAction(botonIngresarPeriferico);

        BotonRefrescar botonRefrescar= new BotonRefrescar();
        refrescar.setOnAction(botonRefrescar);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(ingresar, modificarper, eliminarper);

        //Anadir elementos al vbox
        HBox field = new HBox(fp);
        field.setAlignment(Pos.CENTER);
        this.getChildren().addAll(procesop, detalleprocesop, listaperif,field, hbox, refrescar);

    }

    //Clases anonimas:

    //Seleccionar un perfererico y que se rellenen automaticamente los textfield:
    class ComboBoxPerifericoSeleccionado implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            periferico = (Periferico) listaperif.getSelectionModel().getSelectedItem();
            if(periferico != null) {
                fp.getCampo("Nombre").setText(periferico.getNombre());
                fp.getCampo("Precio").setText(Float.toString(periferico.getPrecio()));
                fp.getCampo("Plataforma").setText(periferico.getPlataforma());
                Boolean uso = periferico.getUso();
                if (uso == true) {
                    fp.getCheckBox("Uso").setSelected(true);
                } else if (uso == false) {
                    fp.getCheckBox("Uso").setSelected(false);
                }
            }
        }
    }


    //Modificar atributos de la consola cuando se presiona el boton modificar:
    class BotonModificarPeriferico implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            try{
                periferico.setNombre(fp.getValue("Nombre"));
                periferico.setPrecio(Float.parseFloat(fp.getValue("Precio")));
                if (fp.getCondicion("Uso") == true) {
                    periferico.setUso(true);
                } else if (fp.getCondicion("Uso") == false) {
                    periferico.setUso(false);
                }
                listaperif.getItems().clear();
                listaperif.setItems(FXCollections.observableArrayList(Datos.listaPerifericos));
                fp.refrescar();
            }catch (ErrorCampoVacio e){
                new DialogError(e);
            }
        }

    }

    //Eliminar un periferico de la base de datos:

    class BotonEliminarPeriferico implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Datos.listaPerifericos.remove(periferico);
            listaperif.getItems().clear();
            listaperif.setItems(FXCollections.observableArrayList(Datos.listaPerifericos));
            fp.refrescar();
        }
    }

    class BotonIngresarPeriferico implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            try {
                Periferico periferico = new Periferico();
                periferico.setNombre(fp.getValue("Nombre"));
                periferico.setPrecio(Float.parseFloat(fp.getValue("Precio")));
                if (fp.getCondicion("Uso") == true) {
                    periferico.setUso(true);
                } else if (fp.getCondicion("Uso") == false) {
                    periferico.setUso(false);
                }
                periferico.setPlataforma(fp.getValue("Plataforma"));
                Datos.listaPerifericos.add(periferico);
                listaperif.getItems().clear();
                listaperif.setItems(FXCollections.observableArrayList(Datos.listaPerifericos));

                //Verificar que el periferico esta en la base de datos:

                // Dialogo de confirmacion despues de agregado el periferico a la base de datos de la tienda.
                Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
                dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
                dialogoDescripcion.setHeaderText("Usted acaba de agregar un nuevo Periferico a la base de datos de la tienda.");
                dialogoDescripcion.setContentText("Proceso Exitoso.");
                dialogoDescripcion.showAndWait();
            }catch (ErrorCampoVacio e){
                new DialogError(e);
            }

        }
    }
    class BotonRefrescar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            fp.refrescar();
        }
    }
}
