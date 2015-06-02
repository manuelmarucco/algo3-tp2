package jugabilidad;

import java.util.ArrayList;

import jugabilidad.auxiliares.Recursos;
import manejoDeConstrucciones.Construccion;
import manejoDeConstrucciones.ProxyConstrucciones;
import manejoDeConstrucciones.comandos.ConstruccionesDisponibles;
import manejoDeUnidades.Unidad;
import excepciones.ExcepcionNecesitaCrearOtraConstruccionPrevia;
import excepciones.ExcepcionSuministrosInsuficientes;
import excepciones.ExcepcionRecursosInsuficientes;
import razas.Raza;

public class Jugador {
	
	private Raza raza;
	private Recursos recursosRecolectados;
	private ArrayList<Construccion> construccionesCreadas = new ArrayList<Construccion>();
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
	

	public void construir(ConstruccionesDisponibles construccion){
		ProxyConstrucciones proxy = new ProxyConstrucciones();
		Construccion construccionCreada;
		
		try{
			proxy.esConstruible(construccion, construccionesCreadas);
		}catch(ExcepcionNecesitaCrearOtraConstruccionPrevia e){
			e.printStackTrace();
			return; 
		}
		
		construccionCreada = raza.seleccionarConstruccion(construccion).accionConstruir(this);
		
		try {
			recursosRecolectados.gastarRecursos(construccionCreada.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return; 
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
		for(Construccion c: construccionesCreadas){
			c.update();
		}
		
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
