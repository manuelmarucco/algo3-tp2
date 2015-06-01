package jugabilidad;

import java.util.ArrayList;

import auxiliares.Recursos;
import construcciones.Construccion;
import construcciones.ProxyConstrucciones;
import construcciones.comandos.ConstruccionesDisponibles;
import excepciones.ExcepcionNecesitaCrearOtraConstruccionPrevia;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.Unidad;
import razas.Raza;

public class Jugador {
	
	private Raza raza;
	private Recursos recursosRecolectados;
	private ArrayList<Construccion> construccionesCreadas = new ArrayList<Construccion>();
	private ArrayList<Unidad> unidadesCreadas = new ArrayList<Unidad>();

	public Jugador(Raza r,Recursos recursosIniciales){
		raza = r;
		recursosRecolectados = recursosIniciales;
	}
	
	public void construir(ConstruccionesDisponibles construccion){
		ProxyConstrucciones proxy = new ProxyConstrucciones();
		Construccion construccionCreada;
		
		try{
			proxy.esConstruible(construccion, construccionesCreadas);
		}catch(ExcepcionNecesitaCrearOtraConstruccionPrevia e){
			return; //dentro de las excepciones habria q hacer q aparezca un cartelito q le avise al usuario porque no la puede construir
		}
		
		construccionCreada = raza.seleccionarConstruccion(construccion).accionConstruir();
		
		try {
			recursosRecolectados.gastarRecursos(construccionCreada.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			return; //poner cartelito en la excepcion avisando que no se construye porque no tiene recursos
		}
		
		construccionesCreadas.add(construccionCreada);
	}
	
	public void crearUnidad(Unidad unidad){
		try {
			recursosRecolectados.gastarRecursos(unidad.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			return; //poner cartelito en la excepcion avisando que no se construye porque no tiene recursos
		}
		
		unidadesCreadas.add(unidad);
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
