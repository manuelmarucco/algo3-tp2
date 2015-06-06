package construcciones.terran;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.ExcepcionNecesitaConstruirFabrica;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;

import java.util.ArrayList;
import java.util.Iterator;


public class PuertoEstelar extends CentroDeEntrenamiento{

	//necesita que la Fabrica haya sido construida para poder crearse

	
	public PuertoEstelar(){
		nombre = "PuertoEstelar";
		vida = new Vida(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;

	}


	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados) throws ExcepcionNoSePuedeConstruir{
		boolean construible = false;

		for (T c : cs) {
			if (((Construccion) c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirFabrica();
		
		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}

	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}


}

