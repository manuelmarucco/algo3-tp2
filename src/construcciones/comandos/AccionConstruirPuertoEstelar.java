package construcciones.comandos;

import interfaces.Construible;
import construcciones.Construccion;
import construcciones.terran.PuertoEstelar;

public class AccionConstruirPuertoEstelar implements Construible{
	@Override
	public Construccion accionConstruir(){
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		return puertoEstelar;
	}
}
