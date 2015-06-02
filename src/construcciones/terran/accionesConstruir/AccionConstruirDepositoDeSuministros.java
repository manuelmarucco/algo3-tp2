package construcciones.terran.accionesConstruir;

import construcciones.Construccion;
import construcciones.terran.DepositoDeSuministros;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirDepositoDeSuministros implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(jugador);
		return depositoDeSuministros;
	}
}
