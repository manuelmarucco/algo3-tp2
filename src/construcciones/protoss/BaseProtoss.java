package construcciones.protoss;

import fiuba.algo3.algocraft.unidades.VidaEscudo;

public class BaseProtoss extends ConstruccionProtoss{
	public BaseProtoss() {
		nombre = "BaseProtoss";
		vidaEscudo = new VidaEscudo(400,50);
	}
	
	public Acceso construirAcceso(){
		Acceso acceso = new Acceso();
		return acceso;
	}

	public PortalEstelar construirPortalEstelar() {
		PortalEstelar portalEstelar = new PortalEstelar();
		return portalEstelar;
	}
	
	public ArchivosTemplarios construirArchivosTemplarios() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		return archivosTemplarios;
	}
	
}
