package construcciones.protoss;

import interfaces.AccionDeEdificio;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import construcciones.protoss.accionesDeEdificio.AccionEntrenarDragon;
import construcciones.protoss.accionesDeEdificio.AccionEntrenarZealot;
import unidades.VidaEscudo;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;


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
