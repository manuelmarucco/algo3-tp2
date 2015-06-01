package construcciones.terran;

import auxiliares.Recursos;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.parametros.Vida;
import auxiliares.Costo;


public class CentroDeMineral extends ConstruccionTerran {
	
	private final int mineralRecolectado = 10; //por turno
	private Recursos recursos;

	public CentroDeMineral(Recursos recursos){
		vida = new Vida(150);
		costo = new Costo(50,0);
		this.recursos = recursos;
	}
	
	// esta funcion la debe llamar alguna clase en cada turno y debe modificar el atributo de la instancia Jugador
	//  |
	//  |
	//  v
	public int getMineralRecolectado(){
		return mineralRecolectado;
	}

	private void recolectar(){
		this.recursos.RecolectarMirerales(mineralRecolectado);
	}
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	public void update(){
		super.update();
		this.recolectar();
	}
	
}
