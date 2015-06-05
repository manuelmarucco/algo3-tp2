package construcciones.protoss;

import construcciones.CentroDeSuministros;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;


public class Pilon extends CentroDeSuministros {
	
	private final int capacidadExtra = 5;
	private Escudo escudo;
	
	public Pilon(Jugador jugador){

		vida = new Vida(300);
		escudo = new Escudo(300);
		this.costo = new Costo(100,0);
		this.tiempoDeConstruccion = 5;
		jugador.aumentarSuministros(capacidadExtra);
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}


	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

}
