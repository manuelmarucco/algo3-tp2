package construcciones.terran;

import construcciones.Construccion;

public class BaseTerran extends ConstruccionTerran{
	
	public BaseTerran() {
		vida = 500;
	}
	
	public Construccion construirBarraca(){
		Barraca barraca = new Barraca();
		return barraca;
	}
	
}
