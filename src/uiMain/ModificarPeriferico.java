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

    public ModificarPeriferico(){
        //Creacion de Vbox para modificar periferico:
        modificarPeriferico = new VBox(50);
        modificarPeriferico.setAlignment(Pos.CENTER);
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
            public void changed(ObservableValue x, String y, String t) {
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
        modificarPeriferico.getChildren().addAll(procesop, detalleprocesop, listaperif,formularioingresop);

    }

    public VBox getModificarPeriferico() {
        return modificarPeriferico;
    }

    //Clases anonimas:
    //Seleccionar una consola y que se rellenen automaticamente los textfield:
    /*class ComboBoxConsolaSeleccionada implements EventHandler<ActionEvent> {
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

    }*/
}
