package razas.terran.construcciones.accionesConstruir;

import razas.terran.construcciones.Barraca;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirBarraca implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Barraca barraca = new Barraca();
		return barraca;
	}
}
