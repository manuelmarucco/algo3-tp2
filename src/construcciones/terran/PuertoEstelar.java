package construcciones.terran;
import interfaces.AccionDeEdificio;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.terran.accionesDeEdficio.AccionEntrenarEspectro;
import construcciones.comandos.terran.accionesDeEdficio.AccionEntrenarNaveCiencia;
import construcciones.comandos.terran.accionesDeEdficio.AccionEntrenarNaveTransporte;
import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.Vida;


public class PuertoEstelar extends ConstruccionTerran{

	//necesita que la Fabrica haya sido construida para poder crearse
	
	public PuertoEstelar(){
		nombre = "PuertoEstelar";
		vida = new Vida(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;

		acciones = new HashMap<AccionesDisponibles, AccionDeEdificio>();
		acciones.put(AccionesDisponibles.EntrenarEspectro,new AccionEntrenarEspectro());
		acciones.put(AccionesDisponibles.EntrenarNaveDeTransporte,new AccionEntrenarNaveTransporte());
		acciones.put(AccionesDisponibles.EntrenarNaveDeCiencia,new AccionEntrenarNaveCiencia());
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
