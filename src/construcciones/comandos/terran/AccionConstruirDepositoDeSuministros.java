package construcciones.comandos.terran;

import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.DepositoDeSuministros;

public class AccionConstruirDepositoDeSuministros implements AccionConstruir{
	@Override
	public Construccion accionConstruir(){
		DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros();
		return depositoDeSuministros;
	}
}
