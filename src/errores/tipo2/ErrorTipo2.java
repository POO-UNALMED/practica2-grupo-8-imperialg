package errores.tipo2;

import errores.ErrorAplicacion;
/*

Errores de tipo2: Todos los errores de tipo2 consisten en verificaciones exactas que realiza el sistema para hacer posible una transaccion, es decir:

-ClienteNoseleccionado: No se tiene seleccionado un cliente para realizar una transaccion.
-FacturaVacia: No hay detalles para realizar una factura.
-VerificarCelular: Se coloco un celular que no incluye 10 cifras.
-UnidadesEnteras: No se ingresaron unidades enteras al formulario.
*/

public class ErrorTipo2 extends ErrorAplicacion {
    public ErrorTipo2(String texto){
        super(texto);
    }
}
