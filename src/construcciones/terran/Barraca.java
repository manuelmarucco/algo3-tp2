package construcciones.terran;


import interfaces.Entrenable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import excepciones.ExcepcionRecursosInsuficientes;
import unidades.*;
import unidades.terrran.Marine;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Barraca extends ConstruccionTerran {
	
	ArrayList<Entrenable> colaDeEntrenamiento = new ArrayList<Entrenable>();
	ArrayList<Entrenable> unidadesCreadas = new ArrayList<Entrenable>();
	Jugador jugador;
	
	public Barraca(){} //por ahora para los tests
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
		Entrenable unidad = colaDeEntrenamiento.get(colaDeEntrenamiento.size()-1);
		unidad.disminuirTiempoDeEntrenamiento();
		if(unidad.getTiempoDeEntrenamiento() == 0){
			this.crearUnidad(unidad);
		}
			//this.regenerar.regenerar(this);
}
		

	private <T extends Entrenable >void crearUnidad(T unidad) {
		
		try {
			jugador.getRecursos().gastarRecursos(unidad.getCosto());
		} catch (ExcepcionRecursosInsuficientes e) {
			e.printStackTrace();
			return;
		}
			jugador.usarSuministrosDisponibles(unidad);
		//jugador.agregarUnidad(unidad);
		//FALTA AGREGARSE AL MAPA
		
	}
	public void entrenarMarine(){
		Marine m = new Marine();
		colaDeEntrenamiento.add(m);
	}
	
	public boolean habilitaAConstruir(Fabrica t) {
		return true;
	}

}

