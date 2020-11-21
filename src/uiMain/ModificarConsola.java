package uiMain;

import BaseDatos.Datos;
import gestorAplicacion.producto.Consola;
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
import sun.font.TrueTypeFont;

public class ModificarConsola {

    VBox modificarConsola;
    ObservableList<Consola> listaconsolas = FXCollections.observableArrayList(Datos.listaConsolas);
    ComboBox listamcons = new ComboBox(listaconsolas);
    TextField nombrecons = new TextField();
    TextField usocons = new TextField();
    TextField preciocons = new TextField();
    TextField colorcons = new TextField();
    TextField versioncons = new TextField();
    TextField capacidadcons = new TextField();
    ComboBox<String> usoconsola = new ComboBox<String>();


    public ModificarConsola(){

        //Creacion Vbox para modificar consola:
        modificarConsola = new VBox(50);
        modificarConsola.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso

        TextField proceso1 = new TextField("Ingresar una Consola a la Base De Datos");
        proceso1.setMaxWidth(500);
        proceso1.setEditable(false);
        proceso1.setAlignment(Pos.CENTER);

        //TextField con el detalle del proceso

        TextField detalleproceso1 = new TextField("Debe llenar todos los campos correspondientes para ingresar una Consola");
        detalleproceso1.setAlignment(Pos.CENTER);
        detalleproceso1.setEditable(false);
        detalleproceso1.setMaxWidth(800);

        ///Gridpane con formulario:

        GridPane formularioingresocons1 = new GridPane();

        //Componentes del formulario:

        //Campo nombre:
        Label nombrecon = new Label("Nombre:");
        nombrecon.setScaleX(1.1);
        nombrecon.setScaleY(1.1);

        //Campo Uso:
        Label usocon = new Label("Uso de la Consola:");
        usoconsola.getItems().addAll("Nueva","Usada");
        usoconsola.setPromptText("Seleccione una opcion");
        usoconsola.valueProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue x, String y, String t) {
                usocons.setText(t);
            }
        });
        usocon.setScaleX(1.1);
        usocon.setScaleY(1.1);

        //Campo precio:

        Label preciocon = new Label("Precio:");
        preciocon.setScaleX(1.1);
        preciocon.setScaleY(1.1);

        //Campo color:

        Label colorcon = new Label("Color:");
        colorcon.setScaleX(1.1);
        colorcon.setScaleY(1.1);

        //Campo version:

        Label versioncon = new Label("Version:");
        versioncon.setScaleX(1.1);
        versioncon.setScaleY(1.1);

        //Campo capacidad:

        Label capacidadcon = new Label("Almacenamiento (Gb):");
        capacidadcon.setScaleX(1.1);
        capacidadcon.setScaleY(1.1);

        //Botones del formulario:

        Button ingresarcon = new Button("Ingresar");
        Button cancelarcon = new Button("Cancelar");

        //Parametros del gridpane

        formularioingresocons1.setPadding(new Insets(10,10,10,10));
        formularioingresocons1.setVgap(20);
        formularioingresocons1.setHgap(20);
        formularioingresocons1.setAlignment(Pos.CENTER);

        //Ingresar campos del formulario al gridpane:

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
        modificarConsola.getChildren().addAll(proceso1,detalleproceso1,listamcons,formularioingresocons1);


        //Anadir Interactividad a formulario:

        //Mostrar en pantalla los datos de la consola:

        ComboBoxConsolaSeleccionada accioncombocons = new ComboBoxConsolaSeleccionada();
        listamcons.setOnAction(accioncombocons);

        BotonModificarConsola botonModificarConsola = new BotonModificarConsola();
        ingresarcon.setOnAction(botonModificarConsola);

    }

    public VBox getModificarConsola() {
        return modificarConsola;
    }


    //Seleccionar una consola y que se rellenen automaticamente los textfield:
    class ComboBoxConsolaSeleccionada implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Consola consola = (Consola) listamcons.getSelectionModel().getSelectedItem();
            nombrecons.setText(consola.getNombre());
            preciocons.setText(Float.toString(consola.getPrecio()));
            colorcons.setText(consola.getColor());
            versioncons.setText(consola.getVersion());
            capacidadcons.setText(Integer.toString(consola.getAlmacenamiento()));
            Boolean uso = consola.getUso();
            if (uso == true){
                usoconsola.getSelectionModel().select(2);
            } else if(!uso){
                usoconsola.getSelectionModel().select(1);
            }
        }
    }


    //Modificar atributos de la consola cuando se presiona el boton modificar:
    class BotonModificarConsola implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Consola consola = (Consola) listamcons.getSelectionModel().getSelectedItem();
            consola.setNombre(nombrecons.getText());
            consola.setColor(colorcons.getText());
            consola.setAlmacenamiento(Integer.parseInt(capacidadcons.getText()));
            consola.setVersion(versioncons.getText());
            consola.setPrecio(Float.parseFloat(preciocons.getText()));
            if(usocons.getText().equals("Nueva")) {
                consola.setUso(false);
            }else if(usocons.getText().equals("Usada")) {
                consola.setUso(true);
            }
            System.out.println(consola);
            Consola.consolasRegistradas();

        }

    }
}
