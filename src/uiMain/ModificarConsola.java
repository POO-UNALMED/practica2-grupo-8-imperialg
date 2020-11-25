package uiMain;

import BaseDatos.Datos;
import errores.tipo1.ErrorCampoNumerico;
import errores.tipo1.ErrorCampoVacio;
import errores.tipo2.ErrorVerificarCelular;
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
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sun.font.TrueTypeFont;

public class ModificarConsola extends VBox{

    ComboBox listamcons;
    FieldPanel fp;
    Consola consola;

    public ModificarConsola(){
        listamcons = new ComboBox(FXCollections.observableArrayList(Datos.listaConsolas));
        listamcons.setPromptText("Seleccione una Consola");
        listamcons.setPrefWidth(500);
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        //Textfield con el titulo del proceso

        Proceso proceso1 = new Proceso("Ingresar, Eliminar o Modificar una Consola de la Base De Datos");

        //TextField con el detalle del proceso

        DetalleProceso detalleproceso1 = new DetalleProceso("Debe llenar todos los campos correspondientes para ingresar una Consola");

        //Formulario:

        String[] criterios = new String[] {"Nombre", "Color", "Precio", "Version", "Almacenamiento"};
        String[] booleanos = new String[] {"Uso"};

        this.fp = new FieldPanel("Datos Consola",criterios,"Datos",null,booleanos);        
        //Botones del formulario:

        Button modificar = new Button("Modificar");
        Button eliminar = new Button("Eliminar");
        Button ingresar = new Button("Ingresar");
        Button refrescar = new Button("Refrescar Campos");



        //Anadir Interactividad a formulario:

        //Mostrar en pantalla los datos de la consola:

        ComboBoxConsolaSeleccionada accioncombocons = new ComboBoxConsolaSeleccionada();
        listamcons.setOnAction(accioncombocons);

        //Modificar consola seleccionada:
        BotonModificarConsola botonModificarConsola = new BotonModificarConsola();
        modificar.setOnAction(botonModificarConsola);

        //Eliminar consola:
        BotonEliminarConsola botonEliminarConsola = new BotonEliminarConsola();
        eliminar.setOnAction(botonEliminarConsola);

        //Agregar Consola:
        BotonAgregarConsola botonAgregarConsola = new BotonAgregarConsola();
        ingresar.setOnAction(botonAgregarConsola);

        //Refrescar Campos del textfield
        BotonRefrescar botonRefrescar = new BotonRefrescar();
        refrescar.setOnAction(botonRefrescar);

        //Hbox con botones
        HBox hbox = new HBox();
        hbox.getChildren().addAll(ingresar, modificar,eliminar);
        hbox.setAlignment(Pos.CENTER);
  
        //Anadir elementos al Vbox
        HBox field = new HBox(fp);
        field.setAlignment(Pos.CENTER);
        this.getChildren().addAll(proceso1,detalleproceso1,listamcons,field,hbox, refrescar);

    }

    //Seleccionar una consola y que se rellenen automaticamente los textfield:

    class ComboBoxConsolaSeleccionada implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            consola = (Consola) listamcons.getSelectionModel().getSelectedItem();
            if (consola != null){
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
    }

    //Modificar atributos de la consola cuando se presiona el boton modificar:

    class BotonModificarConsola implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            try {
                consola.setNombre(fp.getValue("Nombre"));
                consola.setColor(fp.getValue("Color"));
                try {
                    consola.setAlmacenamiento(Integer.parseInt(fp.getValue("Almacenamiento")));
                    consola.setVersion(fp.getValue("Version"));
                    consola.setPrecio(Float.parseFloat(fp.getValue("Precio")));
                }catch (NumberFormatException e){
                    throw new ErrorCampoNumerico();
                }
                if(fp.getCondicion("Uso") == true) {
                    consola.setUso(true);
                }else if(fp.getCondicion("Uso") == false) {
                    consola.setUso(false);
                }
                listamcons.getItems().clear();
                listamcons.setItems(FXCollections.observableArrayList(Datos.listaConsolas));
                fp.refrescar();
            } catch (ErrorCampoVacio e){
                new DialogError(e);
            } catch (ErrorCampoNumerico f){
                new DialogError(f);
            }



        }
    }

    class BotonAgregarConsola implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            try {
                Consola consola = new Consola();
                consola.setNombre(fp.getValue("Nombre"));
                consola.setColor(fp.getValue("Color"));
                try {
                    consola.setAlmacenamiento(Integer.parseInt(fp.getValue("Almacenamiento")));
                    consola.setPrecio(Float.parseFloat(fp.getValue("Precio")));
                } catch (NumberFormatException e){
                    throw new ErrorCampoNumerico();
                }

                consola.setVersion(fp.getValue("Version"));

                if (fp.getCondicion("Uso") == true) {
                    consola.setUso(true);
                } else if (fp.getCondicion("Uso") == false) {
                    consola.setUso(false);
                }
                Datos.listaConsolas.add(consola);
                Consola.consolasRegistradas();
                listamcons.getItems().clear();
                listamcons.setItems(FXCollections.observableArrayList(Datos.listaConsolas));

                //Dialogo de confirmacion despues de agregada la Consola a la base de datos de la tienda.
                Alert dialogoDescripcion = new Alert(Alert.AlertType.INFORMATION);
                dialogoDescripcion.setTitle(" MENSAJE DE CONFIRMACION");
                dialogoDescripcion.setHeaderText("Usted acaba de agregar una nueva Consola a la base de datos de la tienda.");
                dialogoDescripcion.setContentText("Proceso Exitoso.");
                dialogoDescripcion.showAndWait();
                fp.refrescar();
            }catch (ErrorCampoVacio e) {
                new DialogError(e);
            }catch (ErrorCampoNumerico g){
                new DialogError(g);
            }
        }
    }

    //Eliminar una consola de la base de datos:

    class BotonEliminarConsola implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Datos.listaConsolas.remove(consola);
            listamcons.getItems().clear();
            listamcons.setItems(FXCollections.observableArrayList(Datos.listaConsolas));
            fp.refrescar();

        }
    }

    class BotonRefrescar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            fp.refrescar();
        }
    }
}
