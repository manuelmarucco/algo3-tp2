package jugabilidad;

import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Unidad;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

	public ColocableEnMapa getAerea(Coordenadas coordenadas) {

		return ( aire.get(coordenadas) ) ;

	}

	public boolean posicionTerrestreOcupada( Coordenadas coordenadas ) {

		return ( this.tierra.containsKey(coordenadas) );
	}

	public boolean posicionAereaOcupada( Coordenadas coordenadas ) {

		return ( this.aire.containsKey(coordenadas) );
	}

	public Coordenadas getCoordenada(final ColocableEnMapa daniable) {
		for (Map.Entry<Coordenadas, ColocableEnMapa> entry : tierra.entrySet()) {
			if (Objects.equals(daniable, entry.getValue())) {
				return entry.getKey();
			}
		}
		for (Map.Entry<Coordenadas, ColocableEnMapa> entry : aire.entrySet()) {
			if (Objects.equals(daniable, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void borrarTerrestre(Coordenadas coordenadas){

		this.tierra.remove(coordenadas);

	}

	public void Quitar(Unidad unidad) {//TODO:hacer un quitar aire y tierra
		Coordenadas c =this.getCoordenada(unidad);
			this.tierra.remove(c);
	}
}

