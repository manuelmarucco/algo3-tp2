package modelo.construcciones.terran;

import modelo.construcciones.CentroDeEntrenamiento;
import modelo.construcciones.Construccion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNecesitaConstruirFabrica;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.interfaces.Construible;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.terrran.Espectro;
import modelo.unidades.terrran.NaveCiencia;
import modelo.unidades.terrran.NaveTransporteTerran;
import modelo.unidades.terrran.ResistenciaTerran;

import java.util.ArrayList;


public class PuertoEstelar extends CentroDeEntrenamiento {

	//necesita que la Fabrica haya sido construida para poder crearse

	
	public PuertoEstelar(){
		resistencia = new ResistenciaTerran(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;

	}
	public PuertoEstelar(Jugador j){
		resistencia = new ResistenciaTerran(1300);
		costo = new Costo(150,100);
		tiempoDeConstruccion = 10;
		this.jugador = j;
	}


	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados,Coordenada coordenada) throws ExcepcionNoSePuedeConstruir {
		boolean construible = false;

		for (T c : cs) {
			if (((Construccion) c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirFabrica();
		
		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}


	public Espectro entrenarEspectro() throws ExcepcionNoSePuedeEntrenarUnidad {
		Espectro espectro = new Espectro(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(espectro);

		this.colaDeEntrenamiento.add(espectro);
		return espectro;
	}

	public NaveCiencia entrenarNaveCiencia() throws ExcepcionNoSePuedeEntrenarUnidad {
		NaveCiencia naveCiencia = new NaveCiencia(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(naveCiencia);

		this.colaDeEntrenamiento.add(naveCiencia);
		return naveCiencia;
	}

	public NaveTransporteTerran entrenarNaveTransporte() throws ExcepcionNoSePuedeEntrenarUnidad {
		NaveTransporteTerran naveTransporte = new NaveTransporteTerran(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(naveTransporte);

		this.colaDeEntrenamiento.add(naveTransporte);
		return naveTransporte;
	}

	@Override
	public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}

}

