package jugabilidad;

import interfaces.Construible;
import interfaces.Entrenable;

import java.util.ArrayList;
import java.util.Iterator;

import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionSuministrosInsuficientes;
import razas.Raza;

public class Jugador {
	
	private Raza raza;
	private Recursos recursosRecolectados;
	private Suministros suministros;
	private ArrayList<Construible> construccionesCreadas = new ArrayList<Construible>();
	private ArrayList<Entrenable> unidadesCreadas = new ArrayList<Entrenable>();
	private ArrayList<Construible> colaDeConstruccion = new ArrayList<Construible>();


	public Jugador(Raza r,Recursos recursosIniciales){
		this.raza = r;
		this.recursosRecolectados = recursosIniciales;
		this.suministros =  new Suministros(0,20);
		
		//HAY QUE HACER QUE EL JUGADOR EMPIECE CON 5 RECOLECTARES....
		//EL PROBLEMA DE ESTO ES QUE DEPENDE LA ESTRUCTURA EN CADA RAZA... HAY QUE VER COMO LO RESOLVEMOS
	}
	

	public void construir(Construible construccionCreada){
		
		try {
			construccionCreada.esConstruible(construccionesCreadas,recursosRecolectados);
		} catch (ExcepcionNoSePuedeConstruir e) {
			e.printStackTrace();
			return;
		}
		
		colaDeConstruccion.add(construccionCreada);
		
		//construccionesCreadas.add(construccionCreada);
	}
	
	
	public Raza getRaza(){
		return raza;
	}

	public Recursos getRecursos() {
		return recursosRecolectados;
	}
	
	public void agregarUnidad(Entrenable unidad){
		unidadesCreadas.add(unidad);
	}

	public void agregarMinerales(int i) {
		recursosRecolectados.agregarRecursos(i,0);
		
	}

	public void update() {
		for (Iterator<Construible> iterator = colaDeConstruccion.iterator(); iterator.hasNext();) {
			Construible c = iterator.next();
			
			c.update();
			
			if(c.getTiempoDeConstruccion() == 0)
				construccionesCreadas.add(c);
			//AGREGAR LA CONSTRUCCION AL MAPA	
			//c.agregarse(mapa????,coordenadas???);
			
		}
		
	}
	
	public boolean buscarConstruccion(Construible c1){
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


	public void aumentarSuministros(int capacidadExtra) {
		suministros.aumentarSuministrosDisponibles(capacidadExtra);
		
	}


	public boolean buscarUnidad(Entrenable m) {
		for(Entrenable e: unidadesCreadas){
			if(m.equals(e)){
				return true;
			}
		}
		return false;
	}
	
}
