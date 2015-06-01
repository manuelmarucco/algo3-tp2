package construcciones;

import interfaces.ColocableEnMapa;
import auxiliares.Costo;


public abstract class Construccion /*implements ColocableEnMapa*/{
	
	//protected Regeneracion regenerar;

	//public HashMap<Accion, AccionDeEdificio> accion;

	protected String nombre;
	protected Costo costo;
	protected int tiempoDeConstruccion;
	
	public abstract void recibirDanio(int danioParcial);

	public String getNombre() {
		return nombre;
	}

	public Costo getCosto() {
		return costo;
	}
	
}
