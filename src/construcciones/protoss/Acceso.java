package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.parametros.VidaEscudo;


public class Acceso extends ConstruccionProtoss{

	public Acceso(){
		nombre = "Acceso";
		vidaEscudo = new VidaEscudo(150,50);
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
	
}
