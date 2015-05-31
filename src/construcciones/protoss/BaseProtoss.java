package construcciones.protoss;

public class BaseProtoss extends ConstruccionProtoss{
	public BaseProtoss() {
		vida = 400;
		escudo = 50;
	}
	
	public Acceso construirAcceso(){
		Acceso acceso = new Acceso();
		return acceso;
	}
}
