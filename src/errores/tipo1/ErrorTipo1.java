package errores.tipo1;

import errores.ErrorAplicacion;

/*
Errores de tipo1: Todo error que here de tipo1 sera un error que por defecto deben incluir los formularios del sistema:

-CampoNumerico: Se coloca un string en vez de un numero
-CampoVacio: Un formulario tiene un campo vacio.
-ComboVacio: Un comboBox esta vacio.

*/

public class ErrorTipo1 extends ErrorAplicacion {
    public ErrorTipo1(String texto){
        super(texto);
    }
}
