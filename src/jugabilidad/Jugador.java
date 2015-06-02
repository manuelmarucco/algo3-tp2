package jugabilidad;

import java.util.ArrayList;

import auxiliares.Recursos;
import construcciones.Construccion;
import construcciones.ProxyConstrucciones;
import construcciones.comandos.ConstruccionesDisponibles;
import excepciones.ExcepcionNecesitaCrearOtraConstruccionPrevia;
import excepciones.ExcepcionPoblacionMaximaInsuficiente;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.Unidad;
import razas.Raza;

public class Jugador {
	
	private Raza raza;
	private Recursos recursosRecolectados;
	private ArrayList<Construccion> construccionesCreadas = new ArrayList<Construccion>();
	private ArrayList<Unidad> unidadesCreadas = new ArrayList<Unidad>();
	protected int poblacionMaxima;
	protected int poblacion;

	public Jugador(Raza r,Recursos recursosIniciales){
		this.raza = r;
		this.recursosRecolectados = recursosIniciales;
		this.poblacionMaxima = 0;
		this.poblacion = 0;
		
		//HAY QUE HACER QUE EL JUGADOR EMPIECE CON 5 RECOLECTARES....
		//EL PROBLEMA DE ESTO ES QUE DEPENDE LA ESCRUCTURA EN CADA RAZA... HAY QUE VER COMO LO RESOLVEMOS
	}
	
	public void construir(ConstruccionesDisponibles construccion){
		ProxyConstrucciones proxy = new ProxyConstrucciones();
		Construccion construccionCreada;
		
		try{
			proxy.esConstruible(construccion, construccionesCreadas);
		}catch(ExcepcionNecesitaCrearOtraConstruccionPrevia e){
			return; //dentro de las excepciones habria q hacer q aparezca un cartelito q le avise al usuario porque no la puede construir
		}
		
		construccionCreada = raza.seleccionarConstruccion(construccion).accionConstruir(this);
		
		try {
			recursosRecolectados.gastarRecursos(construccionCreada.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			return; //poner cartelito en la excepcion avisando que no se construye porque no tiene recursos
		}
		
		construccionesCreadas.add(construccionCreada);
	}
	
	public Construccion buscarConstruccionCreada(String nombre){
		for(Construccion c : construccionesCreadas){
			if(c.getNombre() == nombre){
					return c;
			}
		}
		return null;
	}
	
	public Raza getRaza(){
		return raza;
	}

	public Recursos getRecursos() {
		return recursosRecolectados;
	}

	public Unidad buscarUnidadCreada(String nombre) {
		for(Unidad c : unidadesCreadas){
			if(c.getNombre() == nombre){
					return c;
			}
		}
		return null;
	}
	
	public void agregarUnidad(Unidad unidad){
		unidadesCreadas.add(unidad);
	}

	public void agregarMinerales(int i) {
		recursosRecolectados.agregarRecursos(i,0);
		
	}

	public void agregarPoblacion(int suministro) throws ExcepcionPoblacionMaximaInsuficiente {
		if(poblacionMaxima < poblacion + suministro){
			throw new ExcepcionPoblacionMaximaInsuficiente();
		}
		
	}

	public int getPoblacionMaxima() {
		return poblacionMaxima;
	}

	public void update() {
		for(Construccion c: construccionesCreadas){
			c.update();
		}
		
	}

	
}
