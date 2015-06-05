package construcciones.terran;

import unidades.Vida;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;



public class DepositoDeSuministros extends ConstruccionTerran{
	
	private final int capacidadExtra = 5;
	
	public DepositoDeSuministros(Jugador jugador){
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		jugador.aumentarSuministros(capacidadExtra);
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}

	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

}
