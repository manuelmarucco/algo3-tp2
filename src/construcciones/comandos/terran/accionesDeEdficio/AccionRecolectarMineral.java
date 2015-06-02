package construcciones.comandos.terran.accionesDeEdficio;

import jugabilidad.Jugador;
import interfaces.AccionDeEdificio;

public class AccionRecolectarMineral implements AccionDeEdificio{

	@Override
	public void accionDeEdificio(Jugador jugador) {
		jugador.agregarMinerales(10);
	}

}
