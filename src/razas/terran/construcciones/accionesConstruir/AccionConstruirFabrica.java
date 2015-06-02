package razas.terran.construcciones.accionesConstruir;

import razas.terran.construcciones.Fabrica;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirFabrica implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Fabrica fabrica = new Fabrica();
		return fabrica;
	}
}
