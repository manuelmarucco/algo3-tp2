package construcciones.protoss;

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
