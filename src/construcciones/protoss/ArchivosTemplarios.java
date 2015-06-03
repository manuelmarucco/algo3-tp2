package construcciones.protoss;

import construcciones.comandos.AccionesDisponibles;
import construcciones.protoss.accionesDeEdificio.AccionEntrenarAltoTemplario;
import interfaces.AccionDeEdificio;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.VidaEscudo;

import java.util.HashMap;


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
		super.update();
		
	}

}
