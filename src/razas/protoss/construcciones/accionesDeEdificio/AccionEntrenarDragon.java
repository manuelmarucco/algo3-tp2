package razas.protoss.construcciones.accionesDeEdificio;

import razas.protoss.unidades.Dragon;
import manejoDeUnidades.Unidad;
import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarDragon implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad dragon = new Dragon();
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaque
		
		try {
			jugador.getRecursos().gastarRecursos(dragon.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarSuministros(dragon.getSuministro());
		} catch (ExcepcionSuministrosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(dragon);
		
	}
}
