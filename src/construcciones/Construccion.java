package construcciones;

import interfaces.ColocableEnMapa;
import interfaces.Construible;
import jugabilidad.auxiliares.Costo;
import unidades.Vida;



public abstract class Construccion implements ColocableEnMapa,Construible{
	
	//protected Regeneracion regenerar;


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

	
}
