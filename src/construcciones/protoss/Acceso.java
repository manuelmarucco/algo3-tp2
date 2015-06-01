package construcciones.protoss;

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
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

}
