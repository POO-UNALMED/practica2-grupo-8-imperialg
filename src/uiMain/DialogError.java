package uiMain;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;

public class DialogError extends Alert {
    public static boolean verificador = false;
    public DialogError(Exception e) {
        super(AlertType.ERROR);
        this.setHeaderText("Error de tipo: " +e.getMessage());
        this.setContentText("Por favor rellene todos los formularios");
        this.showAndWait();
    }
}