package construcciones;

public abstract class Construccion {
	
	protected static String nombre;
	
	public abstract void recibirDanio(int danioParcial);

	public String getNombre() {
		return nombre;
	}
	
}
