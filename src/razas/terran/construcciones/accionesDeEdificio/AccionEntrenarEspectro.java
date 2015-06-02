package razas.terran.construcciones.accionesDeEdificio;

import razas.terran.unidades.Espectro;
import manejoDeUnidades.Unidad;
import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarEspectro implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad espectro = new Espectro();
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaque
		
		try {
			jugador.getRecursos().gastarRecursos(espectro.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarSuministros(espectro.getSuministro());
		} catch (ExcepcionSuministrosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(espectro);
		
	}
}
