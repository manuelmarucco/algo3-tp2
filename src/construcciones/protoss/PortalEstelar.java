package construcciones.protoss;

import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class PortalEstelar extends ConstruccionProtoss{
	
	//necesita que el Acceso haya sido construida para poder crearse
	
	public PortalEstelar(){
		nombre = "PortalEstelar";
		vidaEscudo = new VidaEscudo(600,600);
		costo = new Costo(150,150);
		tiempoDeConstruccion = 10;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

}
