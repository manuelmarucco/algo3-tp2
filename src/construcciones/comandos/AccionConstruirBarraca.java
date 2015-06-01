package construcciones.comandos;

import construcciones.Construccion;
import construcciones.terran.Barraca;
import interfaces.Construible;

public class AccionConstruirBarraca implements Construible{
	@Override
	public Construccion accionConstruir(){
		Barraca barraca = new Barraca();
		return barraca;
	}
}
