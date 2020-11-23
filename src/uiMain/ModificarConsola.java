package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
import gestorAplicacion.producto.Juego;
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
import sun.font.TrueTypeFont;

public class ModificarConsola extends VBox{

    ComboBox listamcons;
    FieldPanel fp;

    public ModificarConsola(){

        listamcons = new ComboBox(FXCollections.observableArrayList(Datos.listaConsolas));
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso

        Proceso proceso1 = new Proceso("Ingresar una Consola a la Base De Datos");

        //TextField con el detalle del proceso

        DetalleProceso detalleproceso1 = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar una Consola");

        //Formulario:

        String[] criterios = new String[] {"Nombre", "Color", "Precio", "Version", "Almacenamiento"};
        String[] booleanos = new String[] {"Uso"};

        this.fp = new FieldPanel("Datos Consola",criterios,"Datos",null,booleanos);

        //Botones del formulario:

        Button modificar = new Button("Modificar");
        Button eliminar = new Button("Eliminar");



        //Anadir Interactividad a formulario:

        //Mostrar en pantalla los datos de la consola:

        ComboBoxConsolaSeleccionada accioncombocons = new ComboBoxConsolaSeleccionada();
        listamcons.setOnAction(accioncombocons);

        BotonModificarConsola botonModificarConsola = new BotonModificarConsola();
        modificar.setOnAction(botonModificarConsola);

        BotonEliminarConsola botonEliminarConsola = new BotonEliminarConsola();
        eliminar.setOnAction(botonEliminarConsola);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(modificar,eliminar);

        //Anadir elementos al Vbox
        this.getChildren().addAll(proceso1,detalleproceso1,listamcons,fp,hbox);

    }

    //Seleccionar una consola y que se rellenen automaticamente los textfield:

    class ComboBoxConsolaSeleccionada implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Consola consola = (Consola) listamcons.getSelectionModel().getSelectedItem();
            fp.getCampo("Nombre").setText(consola.getNombre());
            fp.getCampo("Precio").setText(Float.toString(consola.getPrecio()));
            fp.getCampo("Color").setText(consola.getColor());
            fp.getCampo("Version").setText(consola.getVersion());
            fp.getCampo("Almacenamiento").setText(Integer.toString(consola.getAlmacenamiento()));
            Boolean uso = consola.getUso();
            if (uso == true){
                fp.getCheckBox("Uso").setSelected(true);
            } else if(uso == false){
                fp.getCheckBox("Uso").setSelected(false);
            }
        }
    }

    //Modificar atributos de la consola cuando se presiona el boton modificar:

    class BotonModificarConsola implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Consola consola = (Consola) listamcons.getSelectionModel().getSelectedItem();
            consola.setNombre(fp.getValue("Nombre"));
            consola.setColor(fp.getValue("Color"));
            consola.setAlmacenamiento(Integer.parseInt(fp.getValue("Almacenamiento")));
            consola.setVersion(fp.getValue("Version"));
            consola.setPrecio(Float.parseFloat(fp.getValue("Precio")));
            if(fp.getCondicion("Uso") == true) {
                consola.setUso(true);
            }else if(fp.getCondicion("Uso") == false) {
                consola.setUso(false);
            }
            System.out.println(consola);
            Consola.consolasRegistradas();
            listamcons.getItems().clear();
            listamcons.setItems(FXCollections.observableArrayList(Datos.listaConsolas));

        }
    }

    //Eliminar una consola de la base de datos:

    class BotonEliminarConsola implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Consola consola = (Consola) listamcons.getSelectionModel().getSelectedItem();
            Datos.listaConsolas.remove(consola);
            listamcons.getItems().clear();
            listamcons.setItems(FXCollections.observableArrayList(Datos.listaConsolas));

        }
    }
}
