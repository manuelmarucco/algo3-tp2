package jugabilidad;

import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionSuministrosInsuficientes;
import interfaces.Construible;
import interfaces.Entrenable;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Jugador {

	protected Recursos recursosRecolectados;
	protected Suministros suministros;
	protected ArrayList<Construible> construccionesCreadas = new ArrayList<Construible>();
	protected ArrayList<Entrenable> unidadesCreadas = new ArrayList<Entrenable>();
	protected ArrayList<Construible> colaDeConstruccion = new ArrayList<Construible>();

	protected void construir(Construible construccionCreada){
		
		try {
			construccionCreada.esConstruible(construccionesCreadas,recursosRecolectados);
		} catch (ExcepcionNoSePuedeConstruir e) {
			e.printStackTrace();
			return;
		}
		//EdificioEnConstruccion edificioEnConstruccion = new EdificioEnConstruccion(coordenadas,construccionCreadas);
		//colaDeConstruccion.add(edificioEnConstruccion);
		colaDeConstruccion.add(construccionCreada);


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
		for (Construible c : colaDeConstruccion) {
		// for (EdificioEnConstruccion e : colaDeConstruccion) {

				c.update(); //baja el tiempo de construccion del edificioEnConstruccion

				if (c.getTiempoDeConstruccion() == 0) {
					construccionesCreadas.add(c);

					//Construible t = e.finalizarConstruccion();
					//construccionesCreadas.add(t);
					//t.agregarseEnMapa(mapa,e.getCoordenadas());
					//colaDeConstruccion.remove(e);
				}
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

	/*
	public void aumentarSuministros(int capacidadExtra) {
		suministros.aumentarSuministrosDisponibles(capacidadExtra);
		
	}
	*/

	public boolean buscarUnidad(Entrenable m) {
		for(Entrenable e: unidadesCreadas){
			if(m.equals(e)){
				return true;
			}
		}
		return false;
	}

}
