package errores.tipo2;

public class ErrorClienteNoseleccionado extends ErrorTipo2 {
    public ErrorClienteNoseleccionado(){
        super("Cliente no seleccionado");
        this.setDescripcion("No se selecciono ningun cliente para hacer esta transaccion.");
    }

}
