package construcciones;

import java.util.ArrayList;

import excepciones.ExcepcionNoSePuedeConstruir;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import unidades.Vida;



public abstract class Construccion implements ColocableEnMapa,Construible{
	
	//protected Regeneracion regenerar;


	protected String nombre;
	protected Costo costo;
	protected int tiempoDeConstruccion;
	protected Vida vida;

	public abstract void recibirDanio(int danioParcial);
	/*
	public String getNombre() {
		return nombre;
	}
	
	public Costo getCosto() {
		return costo;
	}
	*/
	
	protected void verificarRecursosDisponibles(Recursos r) throws ExcepcionRecursosInsuficientes{
		r.gastarRecursos(costo);
	}
	
	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados) throws ExcepcionNoSePuedeConstruir{
		this.verificarRecursosDisponibles(recursosRecolectados);
	}
	
}
