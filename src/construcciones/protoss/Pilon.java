package construcciones.protoss;

import unidades.VidaEscudo;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;


public class Pilon extends ConstruccionProtoss{
	
	private final int capacidadExtra = 5;
	
	public Pilon(Jugador jugador){
		vidaEscudo = new VidaEscudo(300,300);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 5;
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
		super.update();
	}

}
