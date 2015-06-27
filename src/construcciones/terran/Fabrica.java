package construcciones.terran;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNecesitaConstruirBarraca;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.Golliat;
import unidades.terrran.ResistenciaTerran;

import java.util.ArrayList;


public class Fabrica extends CentroDeEntrenamiento{

	public Fabrica(){
		resistencia = new ResistenciaTerran(1250);
		costo = new Costo(200,100);
		tiempoDeConstruccion = 12;

	}
	public Fabrica(Jugador j){
		resistencia = new ResistenciaTerran(1250);
		costo = new Costo(200,100);
		tiempoDeConstruccion = 12;
		this.jugador = j;
	}


	public Golliat entrenarGolliat() throws ExcepcionNoSePuedeEntrenarUnidad {
		Golliat g = new Golliat(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(g);

		this.colaDeEntrenamiento.add(g);

		return g;
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
/*
	@Override
	public boolean habilitaAConstruir(Construccion c) {
		return c.NecesitaFabrica();
	}

	@Override
	public boolean NecesitaBarraca() {
		return true;
	}
	*/

	public boolean habilitaAConstruir(PuertoEstelar t) {
		return true;
	}

	@Override
	public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}
