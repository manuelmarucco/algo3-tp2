package construcciones.terran;


import excepciones.ExcepcionRecursosInsuficientes;
import excepciones.ExcepcionSuministrosInsuficientes;
import interfaces.Entrenable;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;
import unidades.terrran.Marine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Barraca extends ConstruccionTerran {
	
	Queue<Entrenable>  colaDeEntrenamiento = new LinkedList<Entrenable>();
	ArrayList<Entrenable> unidadesCreadas = new ArrayList<Entrenable>();
	Jugador jugador;
	
	public Barraca(){
		this.vida = new Vida(1000);
		nombre = "Barraca";
		costo = new Costo(150,0);
		tiempoDeConstruccion = 12;
	} //por ahora para los tests
	public Barraca(Jugador j) {

		this.vida = new Vida(1000);
		nombre = "Barraca";
		costo = new Costo(150,0);
		tiempoDeConstruccion = 12;
		jugador = j;
		
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
	
	
	@Override
	public void update() {
		
		super.update();
		
		if(!colaDeEntrenamiento.isEmpty()){
			Entrenable unidad= colaDeEntrenamiento.peek();
			
			unidad.disminuirTiempoDeEntrenamiento();
			
			if(unidad.getTiempoDeEntrenamiento() == 0){
				this.crearUnidad(unidad);
			}
		}
			//this.regenerar.regenerar(this);
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
	public void entrenarMarine(Marine m){
		colaDeEntrenamiento.add(m);
	}
	
	public boolean habilitaAConstruir(Fabrica t) {
		return true;
	}

}

