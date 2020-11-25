package errores.tipo2;

public class ErrorFacturaVacia extends ErrorTipo2{
    public ErrorFacturaVacia(){
        super("Factura vacia");
        this.setDescripcion("Esta intentando hacer una factura vacia.");
    }
}
