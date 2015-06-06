package construcciones;

import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.PortalEstelar;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;

import java.util.ArrayList;



public abstract class Construccion implements ColocableEnMapa,Construible, Actualizable {
	
	//protected Regeneracion regenerar;

	protected Costo costo;
	protected int tiempoDeConstruccion;
	protected Vida vida;

	public int getVida(){
		return vida.getVidaActual();
	}


	public abstract void recibirDanio(int danioParcial);
	
	protected void verificarRecursosDisponibles(Recursos r) throws ExcepcionRecursosInsuficientes{
		r.gastarRecursos(costo);
	}
	
	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados) throws ExcepcionNoSePuedeConstruir{
		this.verificarRecursosDisponibles(recursosRecolectados);
	}
	
	@Override
	public int getTiempoDeConstruccion() {

		return tiempoDeConstruccion;
	}


	@Override
	public void agregarse( Coordenadas coordenadas) {
		Mapa mapa = SingletonMapa.getInstance();
		this.agregarse(mapa,coordenadas);

	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		mapa.agregarEnCapaTerrestre(this, coordenadas);
	}


	public boolean habilitaAConstruir(Fabrica f){
		return false;
	}

	public boolean habilitaAConstruir(PuertoEstelar p){
		return false;
	}

	public boolean habilitaAConstruir(PortalEstelar f){
		return false;
	}

	public boolean habilitaAConstruir(ArchivosTemplarios p){
		return false;
	}

}
