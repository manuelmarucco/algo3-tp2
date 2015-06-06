package construcciones.terran;

import fiuba.algo3.algocraft.unidades.parametros.Vida;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;


public class Fabrica extends ConstruccionTerran{
	
	//necesita que la Barraca haya sido construida para poder crearse
	
	public Fabrica(){
		nombre = "Fabrica";
		vida = new Vida(200);
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnCapaTerrestre(this, coordenadas);
		
	}

}
