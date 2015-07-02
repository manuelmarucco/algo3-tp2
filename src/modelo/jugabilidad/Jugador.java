package modelo.jugabilidad;

import modelo.construcciones.Construccion;
import modelo.excepciones.construcciones.ExcepcionSuministrosInsuficientes;
import modelo.interfaces.Actualizable;
import modelo.interfaces.Construible;
import modelo.interfaces.Entrenable;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Unidad;

import java.util.ArrayList;

public abstract class Jugador implements Actualizable{

	protected String nombre;
	protected String color;
	private Coordenada coordenadaDeBase;

	protected Vision visibilidad;
	protected Recursos recursosRecolectados;
	protected Suministros suministros;
	protected ArrayList<Construible> construccionesCreadas = new ArrayList<>();
	protected ArrayList<Entrenable> unidadesCreadas = new ArrayList<>();


	public Recursos getRecursos() {
		return recursosRecolectados;
	}
	public Suministros getSuministros(){return suministros; }
	
	public void agregarUnidad(Entrenable unidad){
		unidadesCreadas.add(unidad);
	}

	@Override
	public void update() {

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

	public abstract boolean noTieneMasConstruccionesYUnidades();

	public Coordenada getCoordenadaDeBase() {
		return coordenadaDeBase;
	}

	public void setCoordenadaDeBase(Coordenada coordenadaInicial) {
		this.coordenadaDeBase = coordenadaInicial;
	}

	public abstract Object getPodereActivado(Coordenada coordenada);
}
