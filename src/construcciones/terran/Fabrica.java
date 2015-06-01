package construcciones.terran;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import fiuba.algo3.algocraft.unidades.ClaseDeUnidad;
import fiuba.algo3.algocraft.unidades.Danio;
import fiuba.algo3.algocraft.unidades.Terrestre;
import fiuba.algo3.algocraft.unidades.Ubicacion;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.algocraft.unidades.UnidadGuerrera;
import fiuba.algo3.algocraft.unidades.Vida;
import auxiliares.Costo;


public class Fabrica extends ConstruccionTerran{
	
	//necesita que la Barraca haya sido construida para poder crearse
	
	public Fabrica(){
		nombre = "Fabrica";
		vida = new Vida(1250);
		costo = new Costo(200,100);
		tiempoDeConstruccion = 12;
	}
	/*
	public Unidad entrenarGoliat() {
		
		Ubicacion terreno = new Terrestre();
		ClaseDeUnidad clase = new UnidadGuerrera(new Danio(12,10, 4));
		Unidad goliat = new Unidad("marine",new Vida(125), 8, terreno, clase,new Costo(100,50));
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaqueAereo y Terrestre
		return goliat;
	}
*/
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

}
