package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class ArchivosTemplarios extends ConstruccionProtoss{
	
	public ArchivosTemplarios(){
		nombre = "ArchivosTemplarios";
		vidaEscudo = new VidaEscudo(150,50);
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
}
