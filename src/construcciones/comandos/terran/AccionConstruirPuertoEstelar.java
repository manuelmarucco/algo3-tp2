package construcciones.comandos.terran;

import jugabilidad.Jugador;
import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.PuertoEstelar;

public class AccionConstruirPuertoEstelar implements AccionConstruir{
	@Override
	public Construccion accionConstruir(Jugador jugador){
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		return puertoEstelar;
	}
}
