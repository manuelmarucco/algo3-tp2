package construcciones.terran.accionesConstruir;

import construcciones.Construccion;
import construcciones.terran.Fabrica;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirFabrica implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		Fabrica fabrica = new Fabrica();
		return fabrica;
	}
}
