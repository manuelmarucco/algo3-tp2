package construcciones;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import interfaces.AccionDeEdificio;
import interfaces.ColocableEnMapa;
import auxiliares.Costo;


public abstract class Construccion implements ColocableEnMapa{
	
	//protected Regeneracion regenerar;

	public HashMap<AccionesDisponibles, AccionDeEdificio> acciones;

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

	public void accionesDeEdificio(AccionesDisponibles accion) {
		acciones.get(accion);	
	}
	
}
