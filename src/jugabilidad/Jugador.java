package jugabilidad;

import interfaces.Construible;

import java.util.ArrayList;
import java.util.Iterator;

import jugabilidad.auxiliares.Recursos;
import excepciones.ExcepcionNecesitaConstruirOtroEdificio;
import excepciones.ExcepcionRecursosInsuficientes;
import excepciones.ExcepcionSuministrosInsuficientes;
import razas.Raza;
import unidades.Unidad;

public class Jugador {
	
	private Raza raza;
	private Recursos recursosRecolectados;
	private ArrayList<Construible> construccionesCreadas = new ArrayList<Construible>();
	private ArrayList<Unidad> unidadesCreadas = new ArrayList<Unidad>();
	protected int suministrosMaximos;
	protected int suministrosUsados;


	public Jugador() {}
	public Jugador(Raza r,Recursos recursosIniciales){
		this.raza = r;
		this.recursosRecolectados = recursosIniciales;
		this.suministrosMaximos = 0;
		this.suministrosUsados = 0;
		
		//HAY QUE HACER QUE EL JUGADOR EMPIECE CON 5 RECOLECTARES....
		//EL PROBLEMA DE ESTO ES QUE DEPENDE LA ESTRUCTURA EN CADA RAZA... HAY QUE VER COMO LO RESOLVEMOS
	}
	

	public void construir(Construible construccionCreada){
		
		try {
			construccionCreada.verificaConstruccionPrevia(construccionesCreadas);
		} catch (ExcepcionNecesitaConstruirOtroEdificio e) {
			e.printStackTrace();
			return;
		}
		
		
		try {
			construccionCreada.esConstruibleAPartirDeRecursos(recursosRecolectados);
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return; 
		}
		
		construccionesCreadas.add(construccionCreada);
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
		//permite encapsular la implementacion del atributo unidadesCreadas
	}

	public void agregarMinerales(int i) {
		recursosRecolectados.agregarRecursos(i,0);
		
	}

	public void agregarSuministros(int suministro) throws ExcepcionSuministrosInsuficientes {
		if(suministrosMaximos < suministrosUsados + suministro){
			throw new ExcepcionSuministrosInsuficientes();
		}else
			suministrosUsados += suministro;
		
	}

	public void update() {
		for (Iterator<Construible> iterator = construccionesCreadas.iterator(); iterator
				.hasNext();) {
			Construible c = iterator.next();
			c.update();
			
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

	public void aumentarSuministrosMaximos(int suministro){
		suministrosMaximos  += suministro;
	}
	public int getSuministrosMaximos() {
		return suministrosMaximos;
	}
	public int getSuministrosUsados() {
		return suministrosUsados;
	}

	
}
