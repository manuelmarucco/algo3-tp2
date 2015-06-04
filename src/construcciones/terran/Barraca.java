package construcciones.terran;


import interfaces.Construible;

import java.util.ArrayList;

import excepciones.ExcepcionNecesitaConstruirOtroEdificio;
import unidades.*;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Barraca extends ConstruccionTerran {
	
	
	public Barraca() {

		this.vida = new Vida(1000);
		nombre = "Barraca";
		costo = new Costo(150,0);
		tiempoDeConstruccion = 12;
		
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
	
	
	@Override
	public void update() {
		 
		//this.regenerar.regenerar(this);
		
	}

	@Override
	public <T extends Construible> void verificaConstruccionPrevia(ArrayList<T> cs) throws ExcepcionNecesitaConstruirOtroEdificio {
		// TODO Auto-generated method stub
		
	}
	
	public boolean habilitaAConstruir(Fabrica t) {
		return true;
	}
}

