package construcciones.protoss;

import construcciones.comandos.AccionesDisponibles;
import construcciones.protoss.accionesDeEdificio.AccionEntrenarAltoTemplario;
import interfaces.AccionDeEdificio;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.HashMap;


public class ArchivosTemplarios extends ConstruccionProtoss{
	
	public ArchivosTemplarios(){
		super(500,500);
		nombre = "ArchivosTemplarios";
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
		super.update();
		
	}

}
