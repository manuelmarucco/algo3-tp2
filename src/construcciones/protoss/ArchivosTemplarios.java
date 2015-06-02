package construcciones.protoss;

import interfaces.AccionDeEdificio;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.protoss.accionesDeEdficio.AccionEntrenarAltoTemplario;
import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class ArchivosTemplarios extends ConstruccionProtoss{
	
	public ArchivosTemplarios(){
		nombre = "ArchivosTemplarios";
		vidaEscudo = new VidaEscudo(500,500);
		costo = new Costo(150,200);
		tiempoDeConstruccion = 9;

		acciones = new HashMap<AccionesDisponibles, AccionDeEdificio>();
		acciones.put(AccionesDisponibles.EntrenarAltoTemplario,new AccionEntrenarAltoTemplario());
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
