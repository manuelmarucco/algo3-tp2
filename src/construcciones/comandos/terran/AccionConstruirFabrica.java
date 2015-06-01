package construcciones.comandos.terran;

import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.Fabrica;

public class AccionConstruirFabrica implements AccionConstruir{
	@Override
	public Construccion accionConstruir(){
		Fabrica fabrica = new Fabrica();
		return fabrica;
	}
}
