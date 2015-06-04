package construcciones.protoss;

import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ExcepcionNecesitaConstruirAcceso;


public class PortalEstelar extends ConstruccionProtoss{
	
	//necesita que el Acceso haya sido construida para poder crearse
	
	public PortalEstelar(){
		super(600,600);
		nombre = "PortalEstelar";
		costo = new Costo(150,150);
		tiempoDeConstruccion = 10;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public <T extends Construible> void verificaConstruccionPrevia(
			ArrayList<T> cs) throws ExcepcionNecesitaConstruirAcceso {
		boolean construible = false;
		
		for (Iterator<T> iterator = cs.iterator(); iterator.hasNext();) {
			T c = iterator.next();
			if(((ConstruccionProtoss)c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirAcceso();
		
		
	}
	
	public boolean habilitaAConstruir(ArchivosTemplarios t) {
		return true;
	}
	
}
