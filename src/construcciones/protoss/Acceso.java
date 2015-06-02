package construcciones.protoss;

import interfaces.AccionDeEdificio;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.protoss.accionesDeEdficio.AccionEntrenarDragon;
import construcciones.comandos.protoss.accionesDeEdficio.AccionEntrenarZealot;
import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class Acceso extends ConstruccionProtoss{

	public Acceso(){
		nombre = "Acceso";
		vidaEscudo = new VidaEscudo(500,500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
		
		acciones = new HashMap<AccionesDisponibles, AccionDeEdificio>();
		acciones.put(AccionesDisponibles.EntrenarZealot,new AccionEntrenarZealot());
		acciones.put(AccionesDisponibles.EntrenarDragon,new AccionEntrenarDragon());
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
