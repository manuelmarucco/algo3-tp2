package construcciones.comandos.protoss.accionesDeEdficio;

import excepciones.ExcepcionPoblacionMaximaInsuficiente;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.Protoss.Zealot;
import fiuba.algo3.algocraft.unidades.Unidad;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarZealot implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad zealot = new Zealot();
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaque
		
		try {
			jugador.getRecursos().gastarRecursos(zealot.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarPoblacion(zealot.getSuministro());
		} catch (ExcepcionPoblacionMaximaInsuficiente e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(zealot);
		
	}
}
