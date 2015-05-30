package construcciones;

public abstract class Construccion {
	
	protected String nombre;
	
	public abstract void recibirDanio(int danioParcial);

	public String getNombre() {
		return nombre;
	}
	
}
