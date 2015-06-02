package razas.terran.construcciones;

import interfaces.AccionDeEdificio;

import java.util.HashMap;

import razas.terran.construcciones.accionesDeEdificio.AccionEntrenarGolliat;
import manejoDeConstrucciones.comandos.AccionesDisponibles;
import manejoDeUnidades.Vida;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;


public class Fabrica extends ConstruccionTerran{
	
	//necesita que la Barraca haya sido construida para poder crearse
	
	public Fabrica(){
		nombre = "Fabrica";
		vida = new Vida(1250);
		costo = new Costo(200,100);
		tiempoDeConstruccion = 12;

		acciones = new HashMap<AccionesDisponibles, AccionDeEdificio>();
		acciones.put(AccionesDisponibles.EntrenarGolliat,new AccionEntrenarGolliat());
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		
	}

}
