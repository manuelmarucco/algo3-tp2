package construcciones.protoss;

import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ExcepcionNecesitaConstruirPortalEstelar;
import excepciones.ExcepcionNoSePuedeConstruir;


public class ArchivosTemplarios extends ConstruccionProtoss{
	
	public ArchivosTemplarios(){
		super(500,500);
		nombre = "ArchivosTemplarios";
		costo = new Costo(150,200);
		tiempoDeConstruccion = 9;
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
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados) throws ExcepcionNoSePuedeConstruir{
		boolean construible = false;
		
		for (Iterator<T> iterator = cs.iterator(); iterator.hasNext();) {
			T c = iterator.next();
			if(((ConstruccionProtoss)c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirPortalEstelar();

		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}

}
