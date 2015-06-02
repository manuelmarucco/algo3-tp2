package construcciones.terran.accionesConstruir;

import construcciones.Construccion;
import construcciones.terran.PuertoEstelar;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirPuertoEstelar implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		return puertoEstelar;
	}
}
