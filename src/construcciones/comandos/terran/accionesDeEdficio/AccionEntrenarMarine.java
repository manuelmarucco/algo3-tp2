package construcciones.comandos.terran.accionesDeEdficio;

import excepciones.ExcepcionPoblacionMaximaInsuficiente;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.*;
import fiuba.algo3.algocraft.unidades.terran.Marine;
import interfaces.AccionDeEdificio;
import jugabilidad.Jugador;

public class AccionEntrenarMarine implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Unidad marine = new Marine();
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaque
		
		try {
			jugador.getRecursos().gastarRecursos(marine.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
		
		try {
			jugador.agregarPoblacion(marine.getSuministro());
		} catch (ExcepcionPoblacionMaximaInsuficiente e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(marine);
		
	}
}
