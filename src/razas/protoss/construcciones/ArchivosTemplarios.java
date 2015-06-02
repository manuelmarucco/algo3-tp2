package razas.protoss.construcciones;

import interfaces.AccionDeEdificio;

import java.util.HashMap;

import razas.protoss.construcciones.accionesDeEdificio.AccionEntrenarAltoTemplario;
import manejoDeConstrucciones.comandos.AccionesDisponibles;
import manejoDeUnidades.VidaEscudo;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;


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
