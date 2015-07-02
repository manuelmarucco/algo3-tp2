package modelo.construcciones;

import modelo.construcciones.protoss.ArchivosTemplarios;
import modelo.construcciones.protoss.PortalEstelar;
import modelo.construcciones.terran.Fabrica;
import modelo.construcciones.terran.PuertoEstelar;
import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.excepciones.construcciones.ExcepcionRecursosInsuficientes;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Construible;
import modelo.interfaces.Daniable;
import modelo.interfaces.Hechizable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Resistencia;

import java.util.ArrayList;



public abstract class Construccion implements ColocableEnMapa,Construible, Daniable , Hechizable {
	
	//protected Regeneracion regenerar;

	protected Costo costo;
	protected int tiempoDeConstruccion;
	protected Resistencia resistencia;

	public int getVida(){
		return resistencia.getVidaActual();
	}

	@Override
	public Costo getCosto(){
		return costo;
	}

	@Override
	public void recibirDanio(int danio){
		this.resistencia.quitar(danio);
		this.verificarDestruccionDeEdificio();
	}

	protected void verificarDestruccionDeEdificio(){

		ProxyMapa mapa = ProxyMapa.getInstance();

		if(resistencia.getVidaActual() == 0) mapa.borrarEnCapaTerrestre( mapa.getCoordenada(this) );

	}
	
	protected void verificarRecursosDisponibles(Recursos r) throws ExcepcionRecursosInsuficientes{
		r.validacionRecursosSuficientes(costo);
	}
	
	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenada coordenada) throws ExcepcionNoSePuedeConstruir {
		this.verificarRecursosDisponibles(recursosRecolectados);
	}
	
	@Override
	public int getTiempoDeConstruccion() {

		return tiempoDeConstruccion;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenada coordenada) {

		try {
			mapa.agregarEnCapaTerrestre(this, coordenada);
		} catch (ExcepcionPosicionOcupada e){
			e.printStackTrace();
		}
	}

	@Override
	public void update() {

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

	public void irradiar(){

	}

/*
	@Override
	public  abstract boolean habilitaAConstruir(Construccion c);

	//public abstract boolean NecesitaBarraca();

	public abstract boolean NecesitaFabrica();
	*/
}
