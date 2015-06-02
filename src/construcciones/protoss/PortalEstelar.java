package construcciones.protoss;

import interfaces.AccionDeEdificio;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.protoss.accionesDeEdficio.AccionEntrenarNaveTransporte;
import construcciones.comandos.protoss.accionesDeEdficio.AccionEntrenarScout;
import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class PortalEstelar extends ConstruccionProtoss{
	
	//necesita que el Acceso haya sido construida para poder crearse
	
	public PortalEstelar(){
		nombre = "PortalEstelar";
		vidaEscudo = new VidaEscudo(600,600);
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
		// TODO Auto-generated method stub
		
	}

}
