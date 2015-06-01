package construcciones.comandos.terran;

import construcciones.Construccion;
import construcciones.terran.Barraca;
import interfaces.AccionConstruir;

public class AccionConstruirBarraca implements AccionConstruir{
	@Override
	public Construccion accionConstruir(){
		Barraca barraca = new Barraca();
		return barraca;
	}
}
