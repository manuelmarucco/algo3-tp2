package construcciones.terran;

/*
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
*/

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.parametros.Vida;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

//import auxiliares.Recursos;
//import excepciones.ExcepcionRecursosInsuficientes;

public class Barraca extends ConstruccionTerran {

	public Barraca() {

		this.vida = new Vida(250);
		nombre = "Barraca";
		costo = new Costo(150,0);
	}
	/*
	public void update(){
		this.regenerar.regenerar(this);
	}
	*/

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

}
