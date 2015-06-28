package jugabilidad;

import construcciones.Construccion;
import construcciones.EdificioEnConstruccion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import excepciones.construcciones.ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa;
import excepciones.construcciones.ExcepcionSuministrosInsuficientes;
import interfaces.Actualizable;
import interfaces.Construible;
import interfaces.Entrenable;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.Unidad;

import java.util.ArrayList;

public abstract class Jugador implements Actualizable{

	protected String nombre;
	protected String color;

	protected Vision visibilidad;
	protected Recursos recursosRecolectados;
	protected Suministros suministros;
	protected ArrayList<Construible> construccionesCreadas = new ArrayList<>();
	protected ArrayList<Entrenable> unidadesCreadas = new ArrayList<>();
	protected ArrayList<EdificioEnConstruccion> edificiosEnConstruccion = new ArrayList<>();

	protected void 	construir(Construible construccionCreada,Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
		ProxyMapa proxyMapa = ProxyMapa.getInstance();

		if(! this.visibilidad.esVisible(coordenada))throw new ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa();

		construccionCreada.esConstruible(construccionesCreadas,recursosRecolectados, coordenada);

		EdificioEnConstruccion edificioEnConstruccion = new EdificioEnConstruccion(coordenada,construccionCreada);
		proxyMapa.agregar(edificioEnConstruccion, coordenada);

		recursosRecolectados.gastarRecursos(construccionCreada.getCosto());
		edificiosEnConstruccion.add(edificioEnConstruccion);
	}

	public Recursos getRecursos() {
		return recursosRecolectados;
	}
	public Suministros getSuministros(){return suministros; }
	
	public void agregarUnidad(Entrenable unidad){
		unidadesCreadas.add(unidad);
	}

	@Override
	public void update() {

		for (int i = 0; i < edificiosEnConstruccion.size(); i++) {
			EdificioEnConstruccion e = edificiosEnConstruccion.get(i);
			e.disminuirTiempoDeConstruccion();

			if (e.getTiempoDeConstruccionActual() == 0) {

				Construible t = e.finalizarConstruccion();
				construccionesCreadas.add(t);

				Coordenada coordenada = e.getCoordenada();
				ProxyMapa proxyMapa = ProxyMapa.getInstance();

				try {
					proxyMapa.agregar((Construccion) t, coordenada);
				} catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
					excepcionNoSePudoAgregarAlMapa.printStackTrace();
				}

				//para evitar casteo hacer que Construible herede de Actualizable
				edificiosEnConstruccion.remove(e);
				i--;//por q al borrar baja en 1 el size

			}
			if(e.getVida()==0){
				edificiosEnConstruccion.remove(e);
				i--;//por q al borrar baja en 1 el size
			}
		}

		for (int i = 0; i < construccionesCreadas.size(); i++) {
			Construccion c = (Construccion) construccionesCreadas.get(i);
			c.update();
			if(c.getVida() == 0) {
				construccionesCreadas.remove(c);
				i--;//por q al borrar baja en 1 el size
			}
		}

		for (int i = 0; i < unidadesCreadas.size(); i++) {
			Unidad c = (Unidad) unidadesCreadas.get(i);
			c.update();
			if(c.getVida() == 0) {
				unidadesCreadas.remove(c);
				suministros.disminuirSuministrosUsados(c.getSuministro());
				i--;//por q al borrar baja en 1 el size
			}
		}
	}
	
	public boolean buscarConstruccion(Object c1){
		for(Construible c2: construccionesCreadas){
			if(c1.equals(c2)){
				return true;
			}
		}
		return false;
	}

	public void usarSuministrosDisponibles(int i) throws ExcepcionSuministrosInsuficientes {
		suministros.usarSuministros(i);
		
	}

	public boolean buscarUnidad(Object m) {
		for(Entrenable e: unidadesCreadas){
			if(m.equals(e)){
				return true;
			}
		}
		return false;
	}

	// ---

	public void setNombre(String nombre){

		this.nombre = nombre;

	}

	public String getNombre(){

		return ( this.nombre );

	}

	public void setColor(String color){

		this.color = color;

	}

	public String getColor (){

		return ( this.color );

	}

	public Vision getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(Vision vision){
		this.visibilidad = vision;
	}

	public boolean noTieneMasConstruccionesYUnidades() {

		return ( construccionesCreadas.size() == 0 && unidadesCreadas.size() == 0 && edificiosEnConstruccion.size() == 0 );

	}
}
