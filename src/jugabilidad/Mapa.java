package jugabilidad;

import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.HashMap;

public class Mapa {
	
	private HashMap<Coordenadas, ColocableEnMapa> tierra = new HashMap<Coordenadas, ColocableEnMapa>();
	private HashMap<Coordenadas, ColocableEnMapa> aire = new HashMap<Coordenadas, ColocableEnMapa>();
	
	public Mapa(){
	
	}
	
	public void agregar(ColocableEnMapa colocable, Coordenadas coordenadas){
		
		colocable.agregarse(this, coordenadas);
		
	}
	
	public void agregarEnAire(ColocableEnMapa colocable, Coordenadas coordenadas){
		
		this.aire.put(coordenadas, colocable);
		
	}
	
	public void agregarEnTierra(ColocableEnMapa colocable, Coordenadas coordenadas){
		
			this.tierra.put(coordenadas, colocable);
		
	}


	public ColocableEnMapa getTerrestre(Coordenadas coordenadas) {
		
		return ( tierra.get(coordenadas) ) ;
	
	}

	public boolean posicionTerrestreOcupada( Coordenadas coordenadas ) {

		return ( this.tierra.containsKey(coordenadas) );
	}
}
