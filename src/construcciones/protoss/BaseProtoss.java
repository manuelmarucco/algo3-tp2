package construcciones.protoss;

public class BaseProtoss extends ConstruccionProtoss{
	public BaseProtoss() {
		nombre = "BaseProtoss";
		vida = 400;
		escudo = 50;
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
