package construcciones.comandos.protoss.accionesDeEdficio;

import excepciones.ExcepcionPoblacionMaximaInsuficiente;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.Protoss.AltoTemplario;
import fiuba.algo3.algocraft.unidades.Unidad;
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
			jugador.agregarPoblacion(altoTemplario.getSuministro());
		} catch (ExcepcionPoblacionMaximaInsuficiente e) {
			e.printStackTrace();
			return;
		}
		
		jugador.agregarUnidad(altoTemplario);
		
	}
}
