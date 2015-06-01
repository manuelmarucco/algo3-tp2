package jugabilidad;

import auxiliares.Recursos;
import construcciones.Construccion;
import fiuba.algo3.algocraft.unidades.Unidad;
import razas.Raza;

import java.util.ArrayList;

public class Jugador {
	
	private Raza raza;
	private Recursos recursosRecolectados;
	private ArrayList<Construccion> construccionesCreadas = new ArrayList<Construccion>();
	private ArrayList<Unidad> unidadesCreadas = new ArrayList<Unidad>();

	public Jugador(Raza r,Recursos recursosIniciales){
		raza = r;
		recursosRecolectados = recursosIniciales;
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
	
}
