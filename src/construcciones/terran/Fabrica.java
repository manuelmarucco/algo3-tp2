package construcciones.terran;

import interfaces.Construible;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ExcepcionNecesitaConstruirBarraca;
import unidades.Vida;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;


public class Fabrica extends ConstruccionTerran{
	
	//necesita que la Barraca haya sido construida para poder crearse
	
	public Fabrica(){
		nombre = "Fabrica";
		vida = new Vida(1250);
		costo = new Costo(200,100);
		tiempoDeConstruccion = 12;

	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public <T extends Construible> void verificaConstruccionPrevia(ArrayList<T> cs) throws ExcepcionNecesitaConstruirBarraca {
		boolean construible = false;
		
		for (Iterator<T> iterator = cs.iterator(); iterator.hasNext();) {
			T c = iterator.next();
			if(((ConstruccionTerran)c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirBarraca();
		
	}
	
	public boolean habilitaAConstruir(PuertoEstelar t) {
		return true;
	}

}
