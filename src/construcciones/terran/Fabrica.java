package construcciones.terran;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.ExcepcionNecesitaConstruirBarraca;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import interfaces.Entrenable;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;
import unidades.terrran.Golliat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class Fabrica extends CentroDeEntrenamiento{

	public Fabrica(){
		vida = new Vida(1250);
		costo = new Costo(200,100);
		tiempoDeConstruccion = 12;

	}
	public Fabrica(Jugador j){
		vida = new Vida(1250);
		costo = new Costo(200,100);
		tiempoDeConstruccion = 12;
		this.jugador = j;
	}


	public void entrenarGolliat(Golliat g){
		colaDeEntrenamiento.add(g);
	}

	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados) throws ExcepcionNoSePuedeConstruir{
		boolean construible = false;

		for (T c : cs) {
			if (((Construccion) c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirBarraca();
		
		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}
	
	public boolean habilitaAConstruir(PuertoEstelar t) {
		return true;
	}

}
