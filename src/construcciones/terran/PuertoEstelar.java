package construcciones.terran;
import auxiliares.Costo;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import fiuba.algo3.algocraft.unidades.Vida;


public class PuertoEstelar extends ConstruccionTerran{

	//necesita que la Fabrica haya sido construida para poder crearse
	
	public PuertoEstelar(){
		nombre = "PuertoEstelar";
		vida = new Vida(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
