package jugabilidad;

import interfaces.ColocableEnMapa;

import java.util.HashMap;

import jugabilidad.utilidadesMapa.Coordenadas;

public class Mapa {
	
	private HashMap<Coordenadas, ColocableEnMapa> tierra = new HashMap<>();
	private HashMap<Coordenadas, ColocableEnMapa> aire = new HashMap<>();
	
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
	
}
