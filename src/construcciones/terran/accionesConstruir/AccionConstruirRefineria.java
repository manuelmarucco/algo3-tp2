package construcciones.terran.accionesConstruir;

import construcciones.Construccion;
import construcciones.terran.Refineria;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirRefineria implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Refineria refineria = new Refineria(jugador.getRecursos());
		return refineria;
	}
}
