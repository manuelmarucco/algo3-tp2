package construcciones.terran;

import construcciones.Construccion;
import fiuba.algo3.algocraft.unidades.Vida;

public class BaseTerran extends ConstruccionTerran{
	
	public BaseTerran() {
		vida = new Vida(500);
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
