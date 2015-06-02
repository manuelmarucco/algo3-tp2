package razas.protoss.construcciones.accionesDeEdificio;

import razas.protoss.unidades.AltoTemplario;
import manejoDeUnidades.Unidad;
import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarAltoTemplario implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad altoTemplario = new AltoTemplario();
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaque
		
		try {
			jugador.getRecursos().gastarRecursos(altoTemplario.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarSuministros(altoTemplario.getSuministro());
		} catch (ExcepcionSuministrosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(altoTemplario);
		
	}
}
