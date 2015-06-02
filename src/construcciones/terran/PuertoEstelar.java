package construcciones.terran;
import interfaces.AccionDeEdificio;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import construcciones.terran.accionesDeEdificio.AccionEntrenarEspectro;
import construcciones.terran.accionesDeEdificio.AccionEntrenarNaveCiencia;
import construcciones.terran.accionesDeEdificio.AccionEntrenarNaveTransporte;
import unidades.Vida;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;


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
