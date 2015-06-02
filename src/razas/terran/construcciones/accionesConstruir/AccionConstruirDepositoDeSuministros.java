package razas.terran.construcciones.accionesConstruir;

import razas.terran.construcciones.DepositoDeSuministros;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirDepositoDeSuministros implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(jugador);
		return depositoDeSuministros;
	}
}
