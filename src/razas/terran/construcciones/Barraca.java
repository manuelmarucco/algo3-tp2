package razas.terran.construcciones;


import interfaces.AccionDeEdificio;

import java.util.HashMap;

import razas.terran.construcciones.accionesDeEdificio.AccionEntrenarMarine;
import manejoDeConstrucciones.comandos.AccionesDisponibles;
import manejoDeUnidades.*;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Barraca extends ConstruccionTerran {
	
	
	public Barraca() {

		this.vida = new Vida(1000);
		nombre = "Barraca";
		costo = new Costo(150,0);
		tiempoDeConstruccion = 12;
		
		acciones = new HashMap<AccionesDisponibles, AccionDeEdificio>();
		acciones.put(AccionesDisponibles.EntrenarMarine,new AccionEntrenarMarine());
		
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		 
		//this.regenerar.regenerar(this);
		
	}
}

