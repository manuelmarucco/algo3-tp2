package construcciones.terran;

import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.Vida;
import auxiliares.Costo;



public class DepositoDeSuministros extends ConstruccionTerran{
	
	private final int capacidadExtra = 5;
	
	public DepositoDeSuministros(Jugador jugador){
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		jugador.aumentarSuministrosMaximos(capacidadExtra);
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
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
