package construcciones.comandos.terran;

import jugabilidad.Jugador;
import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.DepositoDeSuministros;

public class AccionConstruirDepositoDeSuministros implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(jugador.getPoblacionMaxima());
		return depositoDeSuministros;
	}
}
