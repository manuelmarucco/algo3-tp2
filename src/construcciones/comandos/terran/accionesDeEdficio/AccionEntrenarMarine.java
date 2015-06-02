package construcciones.comandos.terran.accionesDeEdficio;

import auxiliares.Costo;
import excepciones.ExcepcionPoblacionMaximaInsuficiente;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.ClaseDeUnidad;
import fiuba.algo3.algocraft.unidades.Danio;
import fiuba.algo3.algocraft.unidades.Terrestre;
import fiuba.algo3.algocraft.unidades.Ubicacion;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.algocraft.unidades.UnidadGuerrera;
import fiuba.algo3.algocraft.unidades.Vida;
import jugabilidad.Jugador;
import interfaces.AccionDeEdificio;

public class AccionEntrenarMarine implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		Ubicacion terreno = new Terrestre();
		ClaseDeUnidad clase = new UnidadGuerrera(new Danio(6,6, 4));
		Unidad marine = new Unidad("marine",new Vida(40), 7, terreno, clase,new Costo(50,0));
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
