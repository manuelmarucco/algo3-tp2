package construcciones.protoss;

import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class PortalEstelar extends ConstruccionProtoss{
	
	//necesita que el Acceso haya sido construida para poder crearse
	
			public PortalEstelar(){
				nombre = "PortalEstelar";
				vidaEscudo = new VidaEscudo(150,50);
			}
		
}
