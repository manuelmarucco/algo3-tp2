package razas.terran.construcciones.accionesConstruir;

import razas.terran.construcciones.Refineria;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirRefineria implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Refineria refineria = new Refineria(jugador.getRecursos());
		return refineria;
	}
}
