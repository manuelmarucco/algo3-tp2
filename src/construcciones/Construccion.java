package construcciones;

import fiuba.algo3.algocraft.comandos.Accion;
import interfaces.Actuable;
import interfaces.ColocableEnMapa;
import auxiliares.Costo;
import interfaces.Targeteable;

import java.util.HashMap;


public abstract class Construccion implements ColocableEnMapa, Targeteable{
	
	//protected Regeneracion regenerar;

	//public HashMap<Accion, AccionDeEdificio> accion;

	protected String nombre;
	protected Costo costo;
	protected HashMap<Accion, Actuable> poolDeAcciones;

	public String getNombre() {
		return nombre;
	}

	public Costo getCosto() {
		return costo;
	}

	public  void update(){
		for(Accion a:poolDeAcciones.keySet()){
			poolDeAcciones.get(a).actuar(this);
		}
	}
	
}
