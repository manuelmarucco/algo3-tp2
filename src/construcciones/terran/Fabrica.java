package construcciones.terran;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.ExcepcionNecesitaConstruirBarraca;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionNoSePuedeEntrenarUnidad;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;
import unidades.terrran.Golliat;

import java.util.ArrayList;


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


	public Golliat entrenarGolliat(){
		Golliat g = new Golliat();
		try {
			this.validarCreacionUnidad(g);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return g;
		}
		colaDeEntrenamiento.add(g);
		return g;
	}

	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados,Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir{
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
