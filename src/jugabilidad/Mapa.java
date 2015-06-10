package jugabilidad;

import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Unidad;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Mapa {
	
	private HashMap<Coordenadas, ColocableEnMapa> capaTerrestre = new HashMap<>();
	private HashMap<Coordenadas, ColocableEnMapa> capaAerea = new HashMap<>();
	private HashMap<Coordenadas, ColocableEnMapa> capaDeRecursos = new HashMap<>();
	
	public Mapa(){
	
	}

	// Agregar -----
	
	public void agregarEnCapaAerea(ColocableEnMapa colocable, Coordenadas coordenadas)
			throws ExcepcionPosicionOcupada{

		if (this.posicionAereaOcupada(coordenadas)){
			throw new ExcepcionPosicionOcupada();
		}

		this.capaAerea.put(coordenadas, colocable);

	}
	
	public void agregarEnCapaTerrestre(ColocableEnMapa colocable, Coordenadas coordenadas)
			throws ExcepcionPosicionOcupada {

		if (this.posicionTerrestreOcupada(coordenadas)){
			throw new ExcepcionPosicionOcupada();
		}
		
		this.capaTerrestre.put(coordenadas, colocable);
		
	}

	public void agregarEnCapaDeRecursos(ColocableEnMapa colocable, Coordenadas coordenadas){

		this.capaDeRecursos.put(coordenadas, colocable);

	}

	// Obtener -----

	public ColocableEnMapa obtenerDeCapaTerrestre(Coordenadas coordenadas) {

		return ( capaTerrestre.get(coordenadas) ) ;

	}

	public ColocableEnMapa obtenerDeCapaAerea(Coordenadas coordenadas) {

		return ( capaAerea.get(coordenadas) ) ;

	}

	public ColocableEnMapa obtenerDeCapaDeRecursos(Coordenadas coordenadas){

		return ( this.capaDeRecursos.get(coordenadas) );

	}

	// Remover -----

	public void borrarEnCapaTerrestre(Coordenadas coordenadas){ //para el movimiento de las unidades

		this.capaTerrestre.remove(coordenadas);

	}

	public void borrarEnCapaAerea(Coordenadas coordenadas) {

		this.capaAerea.remove(coordenadas);

	}

	// -------------

	public boolean posicionAereaOcupada(Coordenadas coordenadas) {

		return (this.capaAerea.containsKey(coordenadas));

	}

	public boolean posicionTerrestreOcupada(Coordenadas coordenadas) {

		return (this.capaTerrestre.containsKey(coordenadas));

	}

	public Coordenadas getCoordenada(final ColocableEnMapa daniable) {
		for (Map.Entry<Coordenadas, ColocableEnMapa> entry : capaTerrestre.entrySet()) {
			if (Objects.equals(daniable, entry.getValue())) {
				return entry.getKey();
			}
		}
		for (Map.Entry<Coordenadas, ColocableEnMapa> entry : capaAerea.entrySet()) {
			if (Objects.equals(daniable, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void quitar(Unidad unidad) {//TODO:hacer un quitar capaAerea y capaTerrestre
		Coordenadas c =this.getCoordenada(unidad);
			this.capaTerrestre.remove(c);
	}

}

