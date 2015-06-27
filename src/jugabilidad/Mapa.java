package jugabilidad;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.Unidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Mapa {
	
	private HashMap<Coordenada, ColocableEnMapa> capaTerrestre = new HashMap<>();
	private HashMap<Coordenada, ColocableEnMapa> capaAerea = new HashMap<>();
	private HashMap<Coordenada, ColocableEnMapa> capaDeRecursos = new HashMap<>();
	
	public Mapa(){
	
	}

	// Agregar -----
	
	public void agregarEnCapaAerea(ColocableEnMapa colocable, Coordenada coordenada)
			throws ExcepcionPosicionOcupada{

		if (this.posicionAereaOcupada(coordenada)){
			throw new ExcepcionPosicionOcupada();
		}

		this.capaAerea.put(coordenada, colocable);

	}
	
	public void agregarEnCapaTerrestre(ColocableEnMapa colocable, Coordenada coordenada)
		throws ExcepcionPosicionOcupada {

		if (this.posicionTerrestreOcupada(coordenada)){
			throw new ExcepcionPosicionOcupada();
		}
		
		this.capaTerrestre.put(coordenada, colocable);
		
	}

	public void agregarEnCapaDeRecursos(ColocableEnMapa colocable, Coordenada coordenada){

		this.capaDeRecursos.put(coordenada, colocable);

	}

	// Obtener -----

	public ArrayList<ColocableEnMapa> obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(Coordenada centro, int radio)
			throws ExcepcionNoSePudoAgregarAlMapa{

		ArrayList<ColocableEnMapa> unidadesYconstruccionesPertenecientes = new ArrayList<>();

		for (int i = 0; i <= 2 * radio; i++){

			for (int j = 0; j <= 2 * radio; j ++){

				Coordenada punto = this.armarPuntoDeInicio(centro,radio);

				punto.aumentarX(i);
				punto.aumentarY(j);

				if ( this.posicionTerrestreOcupada(punto) ){

					unidadesYconstruccionesPertenecientes.add(this.obtenerDeCapaTerrestre(punto));

				}

				if ( this.posicionAereaOcupada(punto) ){

					unidadesYconstruccionesPertenecientes.add(this.obtenerDeCapaAerea(punto));

				}
			}
		}

		return(unidadesYconstruccionesPertenecientes);

	}

	public ColocableEnMapa obtenerDeCapaTerrestre(Coordenada coordenada) {

		return ( capaTerrestre.get(coordenada) ) ;

	}

	public ColocableEnMapa obtenerDeCapaAerea(Coordenada coordenada) {

		return ( capaAerea.get(coordenada) ) ;

	}

	public ColocableEnMapa obtenerDeCapaDeRecursos(Coordenada coordenada){

		return ( this.capaDeRecursos.get(coordenada) );

	}

	// Remover -----

	public void borrarEnCapaTerrestre(Coordenada coordenada){ //para el movimiento de las unidades

		this.capaTerrestre.remove(coordenada);

	}

	public void borrarEnCapaAerea(Coordenadas coordenadas) {

		this.capaAerea.remove(coordenadas);

	}

	// Mover ---------

	public void moverEnCapaTerrestre(ColocableEnMapa colacable,Coordenada hasta) throws ExcepcionPosicionOcupada {
		if(this.posicionTerrestreOcupada(hasta)) throw new ExcepcionPosicionOcupada();
		this.quitar( (Unidad) colacable);
		this.agregarEnCapaTerrestre(colacable, hasta);

	}

	public void moverEnCapaAerea(ColocableEnMapa colacable,Coordenada hasta) throws ExcepcionPosicionOcupada {
		if(this.posicionAereaOcupada(hasta)) throw new ExcepcionPosicionOcupada();
		this.quitar( (Unidad) colacable);
		this.agregarEnCapaAerea(colacable, hasta);

	}

	//--------------

	public boolean posicionAereaOcupada(Coordenada coordenada) {

		return (this.capaAerea.containsKey(coordenada));

	}

	public boolean posicionTerrestreOcupada(Coordenada coordenada) {

		return (this.capaTerrestre.containsKey(coordenada));

	}

	public boolean posicionDeRecursosOcupada(Coordenada coordenada){

		return (this.capaDeRecursos.containsKey(coordenada));

	}

	public Coordenada getCoordenada(final ColocableEnMapa daniable) {
		for (Map.Entry<Coordenada, ColocableEnMapa> entry : capaTerrestre.entrySet()) {
			if (Objects.equals(daniable, entry.getValue())) {
				return entry.getKey();
			}
		}
		for (Map.Entry<Coordenada, ColocableEnMapa> entry : capaAerea.entrySet()) {
			if (Objects.equals(daniable, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void quitar(Unidad unidad) {
		Coordenada c =this.getCoordenada(unidad);
		if(this.capaTerrestre.get(c)==unidad)
			this.capaTerrestre.remove(c);
		if(this.capaAerea.get(c)==unidad)
			this.capaAerea.remove(c);
	}

	// Metodos privados ----------------------------------------------------

	private Coordenada armarPuntoDeInicio(Coordenada punto, int radio){

		if(punto!=null) {
			int x = punto.getX() - radio;
			int y = punto.getY() - radio;

			return (new Coordenada(x, y));
		}

		return null;
	}

}

