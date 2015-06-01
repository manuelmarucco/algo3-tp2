package construcciones.comandos.terran;

import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.Refineria;

public class AccionConstruirRefineria implements AccionConstruir{
	@Override
	public Construccion accionConstruir(){
		Refineria refineria = new Refineria();
		return refineria;
	}
}
