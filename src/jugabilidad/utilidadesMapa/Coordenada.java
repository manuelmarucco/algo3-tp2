package jugabilidad.utilidadesMapa;

public class Coordenada {
	
	private int x;
	private int y;
	
	public Coordenada(int nuevoX, int nuevoY) {
		this.x = nuevoX;
		this.y = nuevoY;
	}

	public int getY() {
		return ( this.y );
	}

	public int getX() {
		return ( this.x );
	}
	

	@Override
    public boolean equals(Object obj) {

		boolean resultado = false;

		if (obj instanceof Coordenada) {
			Coordenada coordenadaALaDerechaDelIgual = (Coordenada) obj;

			resultado = (this.getX() == coordenadaALaDerechaDelIgual.getX()
					&& this.getY() == coordenadaALaDerechaDelIgual.getY());

		}

		return resultado;
       
	}
	
	// Fuente de la funcion de hash = https://www.artima.com/lejava/articles/equality.html
	
	@Override 
	public int hashCode() {
		
		return (41 * (41 + getX()) + getY());
       
   }

	public int distancia(Coordenada destino) { //redondea para arriba
		return (int)Math.ceil( Math.hypot((double)destino.getX()-(double)this.getX(), (double)destino.getY()-(double)this.getY()));
	}

	public void aumentarX( int cantidad ){

		this.x += cantidad;

	}

	public void aumentarY( int cantidad ){

		this.y += cantidad;

	}
}
