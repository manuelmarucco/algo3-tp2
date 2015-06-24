package jugabilidad;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Unidad;

import java.util.ArrayList;
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

	public ArrayList<ColocableEnMapa> obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(Coordenadas centro, int radio)
			throws ExcepcionNoSePudoAgregarAlMapa{

		ArrayList<ColocableEnMapa> unidadesYconstruccionesPertenecientes = new ArrayList<>();

		for (int i = 0; i <= 2 * radio; i++){

			for (int j = 0; j <= 2 * radio; j ++){

				Coordenadas punto = this.armarPuntoDeInicio(centro,radio);

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

	// Mover ---------

	public void moverEnCapaTerrestre(ColocableEnMapa colacable,Coordenadas hasta) throws ExcepcionPosicionOcupada {

		this.agregarEnCapaTerrestre( colacable, hasta );
		this.quitar( (Unidad) colacable);

	}

	public void moverEnCapaAerea(ColocableEnMapa colacable,Coordenadas hasta) throws ExcepcionPosicionOcupada {

		this.agregarEnCapaAerea(colacable, hasta);
		this.quitar( (Unidad) colacable);

	}

	//--------------

	public boolean posicionAereaOcupada(Coordenadas coordenadas) {

		return (this.capaAerea.containsKey(coordenadas));

	}

	public boolean posicionTerrestreOcupada(Coordenadas coordenadas) {

		return (this.capaTerrestre.containsKey(coordenadas));

	}

	public boolean posicionDeRecursosOcupada(Coordenadas coordenadas){

		return (this.capaDeRecursos.containsKey(coordenadas));

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

	public void quitar(Unidad unidad) {
		Coordenadas c =this.getCoordenada(unidad);
		if(this.capaTerrestre.get(c)==unidad)
			this.capaTerrestre.remove(c);
		if(this.capaAerea.get(c)==unidad)
			this.capaAerea.remove(c);
	}

	// Metodos privados ----------------------------------------------------

	private Coordenadas armarPuntoDeInicio(Coordenadas punto, int radio){

		if(punto!=null) {
			int x = punto.getX() - radio;
			int y = punto.getY() - radio;

			return (new Coordenadas(x, y));
		}

		return null;
	}

}

