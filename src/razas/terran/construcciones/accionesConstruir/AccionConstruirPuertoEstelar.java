package razas.terran.construcciones.accionesConstruir;

import razas.terran.construcciones.PuertoEstelar;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirPuertoEstelar implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		return puertoEstelar;
	}
}
