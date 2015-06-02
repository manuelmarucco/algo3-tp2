package construcciones.terran.accionesConstruir;

import construcciones.Construccion;
import construcciones.terran.Barraca;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirBarraca implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Barraca barraca = new Barraca();
		return barraca;
	}
}
