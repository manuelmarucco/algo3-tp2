package construcciones.comandos.terran;

import jugabilidad.Jugador;
import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.Refineria;

public class AccionConstruirRefineria implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Refineria refineria = new Refineria(jugador.getRecursos());
		return refineria;
	}
}
