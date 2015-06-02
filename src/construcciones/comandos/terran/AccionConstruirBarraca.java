package construcciones.comandos.terran;

import jugabilidad.Jugador;
import construcciones.Construccion;
import construcciones.terran.Barraca;
import interfaces.AccionConstruir;

public class AccionConstruirBarraca implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Barraca barraca = new Barraca();
		return barraca;
	}
}
