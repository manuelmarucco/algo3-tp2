package construcciones.terran;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.ExcepcionNecesitaConstruirFabrica;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionNoSePuedeEntrenarUnidad;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import unidades.Vida;
import unidades.terrran.Espectro;
import unidades.terrran.NaveCiencia;
import unidades.terrran.NaveTransporte;

import java.util.ArrayList;


public class PuertoEstelar extends CentroDeEntrenamiento{

	//necesita que la Fabrica haya sido construida para poder crearse

	
	public PuertoEstelar(){
		vida = new Vida(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;

	}
	public PuertoEstelar(Jugador j){
		vida = new Vida(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;
		this.jugador = j;
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


	public Espectro entrenarEspectro() {
		Espectro espectro = new Espectro();
		try {
			this.validarCreacionUnidad(espectro);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return espectro;
		}
		this.colaDeEntrenamiento.add(espectro);
		return espectro;
	}

	public NaveCiencia entrenarNaveCiencia() {
		NaveCiencia naveCiencia = new NaveCiencia();
		try {
			this.validarCreacionUnidad(naveCiencia);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return naveCiencia;
		}
		this.colaDeEntrenamiento.add(naveCiencia);
		return naveCiencia;
	}

	public NaveTransporte entrenarNaveTransporte() {
		NaveTransporte naveTransporte = new NaveTransporte();
		try {
			this.validarCreacionUnidad(naveTransporte);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return naveTransporte;
		}
		this.colaDeEntrenamiento.add(naveTransporte);
		return naveTransporte;
	}
}

