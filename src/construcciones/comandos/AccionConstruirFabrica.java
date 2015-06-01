package construcciones.comandos;

import interfaces.Construible;
import construcciones.Construccion;
import construcciones.terran.Fabrica;

public class AccionConstruirFabrica implements Construible{
	@Override
	public Construccion accionConstruir(){
		Fabrica fabrica = new Fabrica();
		return fabrica;
	}
}
