package construcciones.comandos.terran;

import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.PuertoEstelar;

public class AccionConstruirPuertoEstelar implements AccionConstruir{
	@Override
	public Construccion accionConstruir(){
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		return puertoEstelar;
	}
}
