package uiMain;

import errores.ErrorAplicacion;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;

public class DialogError extends Alert {
    public static boolean verificador = false;
    public DialogError(ErrorAplicacion e) {
        super(AlertType.ERROR);
        this.setHeaderText("Error de tipo: " +e.getMessage());
        this.setContentText(e.getDescripcion());
        this.showAndWait();
    }
}