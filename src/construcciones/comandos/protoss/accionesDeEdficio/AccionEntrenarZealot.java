package construcciones.comandos.protoss.accionesDeEdficio;

import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.Protoss.Zealot;
import fiuba.algo3.algocraft.unidades.Unidad;
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
