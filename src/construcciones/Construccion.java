package construcciones;

import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.PortalEstelar;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.construicciones.ExcepcionRecursosInsuficientes;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import interfaces.Daniable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Resistencia;

import java.util.ArrayList;



public abstract class Construccion implements ColocableEnMapa,Construible, Daniable {
	
	//protected Regeneracion regenerar;

	protected Costo costo;
	protected int tiempoDeConstruccion;
	protected Resistencia resistencia;

	public int getVida(){
		return resistencia.getVidaActual();
	}

	@Override
	public void recibirDanio(int danio){
		resistencia.quitar(danio);
	}
	
	protected void verificarRecursosDisponibles(Recursos r) throws ExcepcionRecursosInsuficientes{
		r.gastarRecursos(costo);
	}
	
	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir{
		this.verificarRecursosDisponibles(recursosRecolectados);
	}
	
	@Override
	public int getTiempoDeConstruccion() {

		return tiempoDeConstruccion;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {

		try {
			mapa.agregarEnCapaTerrestre(this, coordenadas);
		} catch (ExcepcionPosicionOcupada e){
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		ProxyMapa mapa = ProxyMapa.getInstance();

		if(resistencia.getVidaActual() == 0){
			mapa.borrarEnCapaTerrestre(mapa.getCoordenada(this));
		}

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

	public  void recibirEMP(){}

	public void recibirRadiacion(int danio){}
/*
	@Override
	public  abstract boolean habilitaAConstruir(Construccion c);

	//public abstract boolean NecesitaBarraca();

	public abstract boolean NecesitaFabrica();
	*/
}
