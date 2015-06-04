package construcciones.protoss;

import construcciones.comandos.AccionesDisponibles;
import construcciones.protoss.accionesDeEdificio.AccionEntrenarNaveTransporte;
import construcciones.protoss.accionesDeEdificio.AccionEntrenarScout;
import interfaces.AccionDeEdificio;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.HashMap;


public class PortalEstelar extends ConstruccionProtoss{
	
	//necesita que el Acceso haya sido construida para poder crearse
	
	public PortalEstelar(){
		super(600,600);
		nombre = "PortalEstelar";
		costo = new Costo(150,150);
		tiempoDeConstruccion = 10;

		acciones = new HashMap<AccionesDisponibles, AccionDeEdificio>();
		acciones.put(AccionesDisponibles.EntrenarScout,new AccionEntrenarScout());
		acciones.put(AccionesDisponibles.EntrenarNaveDeTransporte,new AccionEntrenarNaveTransporte());
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		super.update();
	}

}
