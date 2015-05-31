package construcciones;

import auxiliares.Costo;


public abstract class Construccion{
	
	//protected Regeneracion regenerar;

	//public HashMap<Accion, AccionDeEdificio> accion;

	protected String nombre;
	protected Costo costo;
	
	public abstract void recibirDanio(int danioParcial);

	public String getNombre() {
		return nombre;
	}

	public Costo getCosto() {
		return costo;
	}
	
}
