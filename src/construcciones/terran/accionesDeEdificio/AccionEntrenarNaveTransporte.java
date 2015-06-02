package construcciones.terran.accionesDeEdificio;

import unidades.Unidad;
import unidades.terrran.NaveTransporte;
import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarNaveTransporte implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad naveTransporte = new NaveTransporte();
		
		try {
			jugador.getRecursos().gastarRecursos(naveTransporte.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarSuministros(naveTransporte.getSuministro());
		} catch (ExcepcionSuministrosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(naveTransporte);
		
	}
}
