package construcciones;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.AccionDeClase;
import fiuba.algo3.algocraft.unidades.Regenerable;
import fiuba.algo3.algocraft.unidades.Regeneracion;

import java.util.HashMap;

public abstract class Construccion implements Regenerable {
	
	protected static String nombre;
	private Regeneracion regenerar;

	public HashMap<Accion, AccionDeEdificio> accion;

	public abstract void recibirDanio(int danioParcial);

	public String getNombre() {
		return nombre;
	}
	
}
