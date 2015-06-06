package construcciones.terran;

/*
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
*/

import construcciones.comandos.ConstruirMarine;
import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.unidades.parametros.Vida;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

//import auxiliares.Recursos;
//import excepciones.ExcepcionRecursosInsuficientes;

public class Barraca extends ConstruccionTerran {

	public Barraca(Jugador jugador,Mapa mapa) {
		super();
		this.vida = new Vida(250);
		nombre = "Barraca";
		this.accionesPosibles.put(Accion.ConstruirMarine, new ConstruirMarine(jugador, mapa));

	}
	/*
	public void update(){
		this.regenerar.regenerar(this);
	}
	*/

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnCapaTerrestre(this, coordenadas);
		
	}

	public void actuar(Accion accion, Coordenadas Coordenadas) {
		this.accionesPosibles.get(accion).actuar(Coordenadas);
	}

}
