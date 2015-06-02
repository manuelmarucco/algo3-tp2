package razas.terran.construcciones.accionesDeEdificio;

import razas.terran.unidades.Marine;
import manejoDeUnidades.Unidad;
import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import jugabilidad.Jugador;
import interfaces.AccionDeEdificio;

public class AccionEntrenarMarine implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad marine = new Marine();
		
		try {
			jugador.getRecursos().gastarRecursos(marine.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarSuministros(marine.getSuministro());
		} catch (ExcepcionSuministrosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(marine);
		
	}
}
