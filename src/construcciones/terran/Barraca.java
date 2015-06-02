package construcciones.terran;


import interfaces.AccionDeEdificio;

import java.util.HashMap;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.terran.accionesDeEdficio.AccionEntrenarMarine;
import auxiliares.Costo;
//import auxiliares.Recursos;
//import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.*;

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

