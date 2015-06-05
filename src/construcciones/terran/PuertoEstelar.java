package construcciones.terran;

import excepciones.ExcepcionNecesitaConstruirFabrica;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionRecursosInsuficientes;
import excepciones.ExcepcionSuministrosInsuficientes;
import interfaces.Construible;
import interfaces.Entrenable;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class PuertoEstelar extends ConstruccionTerran{

	//necesita que la Fabrica haya sido construida para poder crearse

	Queue<Entrenable> colaDeEntrenamiento = new LinkedList<Entrenable>();
	ArrayList<Entrenable> unidadesCreadas = new ArrayList<Entrenable>();
	Jugador jugador;
	
	public PuertoEstelar(){
		nombre = "PuertoEstelar";
		vida = new Vida(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;

	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		super.update();
		
	}

	private void crearUnidad(Entrenable unidad) {

		try {
			jugador.getRecursos().gastarRecursos(unidad.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}

		try {
			jugador.usarSuministrosDisponibles(unidad.getSuministro());
		} catch (ExcepcionSuministrosInsuficientes e) {
			e.printStackTrace();
		}

		jugador.agregarUnidad(unidad);
		colaDeEntrenamiento.remove();
		//FALTA AGREGARSE AL MAPA

	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados) throws ExcepcionNoSePuedeConstruir{
		boolean construible = false;
		
		for (Iterator<T> iterator = cs.iterator(); iterator.hasNext();) {
			T c = iterator.next();
			if(((ConstruccionTerran)c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirFabrica();
		
		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}
}

