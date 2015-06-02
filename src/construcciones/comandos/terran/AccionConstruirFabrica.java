package construcciones.comandos.terran;

import jugabilidad.Jugador;
import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.Fabrica;

public class AccionConstruirFabrica implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Fabrica fabrica = new Fabrica();
		return fabrica;
	}
}
