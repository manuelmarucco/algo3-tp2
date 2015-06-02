package construcciones.comandos.protoss.accionesDeEdficio;

import excepciones.ExcepcionPoblacionMaximaInsuficiente;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.Protoss.Scout;
import fiuba.algo3.algocraft.unidades.Unidad;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarScout implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad scout = new Scout();
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaque
		
		try {
			jugador.getRecursos().gastarRecursos(scout.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarPoblacion(scout.getSuministro());
		} catch (ExcepcionPoblacionMaximaInsuficiente e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(scout);
		
	}
}
