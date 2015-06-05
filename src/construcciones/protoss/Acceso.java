package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;


public class Acceso extends ConstruccionProtoss{

	public Acceso(){
		super(500,500);
		nombre = "Acceso";
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		super.update();
	}
	

	public boolean habilitaAConstruir(PortalEstelar t) {
		return true;
	}

}
