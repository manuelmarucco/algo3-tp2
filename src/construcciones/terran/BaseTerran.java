package construcciones.terran;

import construcciones.Construccion;

public class BaseTerran extends ConstruccionTerran{
	
	public BaseTerran() {
		vida = 500;
	}
	
	public Barraca construirBarraca(){
		Barraca barraca = new Barraca();
		return barraca;
	}
	
	public Fabrica construirFabrica(){
		Fabrica fabrica = new Fabrica();
		return fabrica;
	}

	public Construccion construirPuertoEstelar() {
		PuertoEstelar puertoEstelar = new PuertoEstelar();
		return puertoEstelar;
	}
	
}
