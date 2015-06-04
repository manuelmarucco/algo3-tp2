package construcciones;

import construcciones.comandos.AccionesDisponibles;
import excepciones.ExcepcionAccionNoDisponible;
import interfaces.AccionDeEdificio;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Costo;
import unidades.Vida;

import java.util.HashMap;


public abstract class 	Construccion implements ColocableEnMapa,Actualizable{
	
	//protected Regeneracion regenerar;

	public HashMap<AccionesDisponibles, AccionDeEdificio> acciones;

	protected String nombre;
	protected Costo costo;
	protected int tiempoDeConstruccion;
	protected Vida vida;

	public abstract void recibirDanio(int danioParcial);

	public String getNombre() {
		return nombre;
	}

	public Costo getCosto() {
		return costo;
	}

	public void accionesDeEdificio(Jugador jugador,AccionesDisponibles accion) {

		//la idea de pasarle al jugador1 como parametro es que el edificio es el q entrena al marine (y no el jugador) entonces
		//el edificio (que es inteligente) le pide al jugador sus atributos para ver si cuenta con los recursos y poblacion maxima para poder construirlo
		
		if(acciones.get(accion) == null){
			try {
				throw new ExcepcionAccionNoDisponible();
			} catch (ExcepcionAccionNoDisponible e) {
				e.printStackTrace();
			}
		}else
			acciones.get(accion).accionDeEdificio(jugador);	
	}
	
}
