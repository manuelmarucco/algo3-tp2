package construcciones;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionDeClase;
import fiuba.algo3.algocraft.unidades.Regenerable;
import fiuba.algo3.algocraft.unidades.Regeneracion;
import auxiliares.Costo;

import java.util.HashMap;


public abstract class Construccion{
	
	//protected Regeneracion regenerar;

	//public HashMap<Accion, AccionDeEdificio> accion;

	protected String nombre;
	protected Costo costo;
	
	public abstract void recibirDanio(int danioParcial);

	public String getNombre() {
		return nombre;
	}
	
}
