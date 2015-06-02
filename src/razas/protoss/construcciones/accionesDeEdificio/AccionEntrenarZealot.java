package razas.protoss.construcciones.accionesDeEdificio;

import razas.protoss.unidades.Zealot;
import manejoDeUnidades.Unidad;
import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarZealot implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad zealot = new Zealot();
		
		try {
			jugador.getRecursos().gastarRecursos(zealot.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarSuministros(zealot.getSuministro());
		} catch (ExcepcionSuministrosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(zealot);
		
	}
}
