package gestorAplicacion.producto;

public class Periferico extends Producto {
    private String plataforma;
    private boolean estado;


    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    public boolean getEstado() {
    	return estado;
    }
    
    public void setEstado(boolean estado) {
    	this.estado=estado;
    }

    public Periferico(String nombre, boolean uso, float precio, String plataforma) {
        super(nombre, uso, precio);
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return getNombre() + " " + plataforma + getPrecio();
    }
    public void repararPeriferico(Periferico periferico){
    	if (periferico.getEstado()==false){
    		System.out.println("La Consola ya se encuentra reparada");
    	}else {
    		periferico.setEstado(false);
    		System.out.println("Se ha reparado la consola");
    	}
    }
}

