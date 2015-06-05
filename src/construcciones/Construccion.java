package construcciones;

import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import unidades.Vida;

import java.util.ArrayList;



public abstract class Construccion implements ColocableEnMapa,Construible, Actualizable {
	
	//protected Regeneracion regenerar;


	protected String nombre;
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

	public void update(){
		tiempoDeConstruccion--;
	}


	public boolean habilitaAConstruir(Fabrica f){
		return false;
	}

	public boolean habilitaAConstruir(PuertoEstelar p){
		return false;
	}

}
