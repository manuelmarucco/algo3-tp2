package construcciones.terran;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import auxiliares.Costo;
import construcciones.Construccion;
import fiuba.algo3.algocraft.unidades.Vida;

public class BaseTerran extends ConstruccionTerran{
	
	public BaseTerran() {
		vida = new Vida(500);
		costo = new Costo(400,0);
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
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
	
}
