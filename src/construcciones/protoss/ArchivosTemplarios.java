package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.ExcepcionNecesitaConstruirPortalEstelar;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionNoSePuedeEntrenarUnidad;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;
import unidades.protoss.AltoTemplario;

import java.util.ArrayList;


public class ArchivosTemplarios extends CentroDeEntrenamiento {

	private Escudo escudo;

	public ArchivosTemplarios(){

		vida = new Vida(500);
		escudo = new Escudo(500);
		costo = new Costo(150,200);
		tiempoDeConstruccion = 9;
	}

	public ArchivosTemplarios(Jugador j){

		vida = new Vida(500);
		escudo = new Escudo(500);
		costo = new Costo(150,200);
		tiempoDeConstruccion = 9;
		this. jugador = j;
	}


	public int getEscudo() {
		return escudo.getEscudoActual();
	}

	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir{
		boolean construible = false;

		for (T c : cs) {
			if ( ((Construccion)c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirPortalEstelar();

		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}

	public AltoTemplario entrenarAltoTemplario() {
		AltoTemplario a = new AltoTemplario();
		try {
			this.validarCreacionUnidad(a);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return a;
		}
		this.colaDeEntrenamiento.add(a);
		return a;
	}
}

