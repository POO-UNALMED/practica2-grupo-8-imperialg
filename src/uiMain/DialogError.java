package uiMain;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;

public class DialogError extends Alert {
    public static boolean verificador = false;
    public DialogError(AlertType alertType) {
        super(alertType);
        this.setContentText("Por favor rellene todos los formularios");
    }
}
