package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.parametros.VidaEscudo;


public class PortalEstelar extends ConstruccionProtoss{
	
	//necesita que el Acceso haya sido construida para poder crearse
	
	public PortalEstelar(){
		nombre = "PortalEstelar";
		vidaEscudo = new VidaEscudo(150,50);
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
		
}
