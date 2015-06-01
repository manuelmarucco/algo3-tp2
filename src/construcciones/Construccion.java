package construcciones;

import fiuba.algo3.algocraft.comandos.Accion;
import interfaces.AccionConstruir;
import interfaces.Actuable;
import interfaces.ColocableEnMapa;
import interfaces.Targeteable;

import java.util.HashMap;
import java.util.Set;


public abstract class Construccion implements ColocableEnMapa, Targeteable{
	
	//protected Regeneracion regenerar;

	//public HashMap<Accion, AccionDeEdificio> accion;

	protected String nombre;
	//protected Costo costo;
	protected HashMap<Accion, Actuable> poolDeAcciones;
	protected HashMap<Accion, AccionConstruir> accionesPosibles;

	public Construccion(){
		this.accionesPosibles= new HashMap<Accion, AccionConstruir>();
	}

	public String getNombre() {
		return nombre;
	}

	public  void update(){
		for(Accion a:poolDeAcciones.keySet()){
			poolDeAcciones.get(a).actuar(this);
		}
	}

	public Set<Accion> getAcciones(){
		return accionesPosibles.keySet();
	}
	
}
