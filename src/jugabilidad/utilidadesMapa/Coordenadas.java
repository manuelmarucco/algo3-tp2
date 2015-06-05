package jugabilidad.utilidadesMapa;

public class Coordenadas {
	
	private int x;
	private int y;
	
	public Coordenadas(int nuevoX, int nuevoY) {
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
	// Yo se que siempre voy a comparar dos coordenadas por eso no necesito preguntar el tipo de lo
	// que entra por parametro como indica la fuente de abajo.
		
		Coordenadas coordenadaALaDerechaDelIgual = (Coordenadas) obj;
		
		return (this.getX() == coordenadaALaDerechaDelIgual.getX() && 
					this.getY() == coordenadaALaDerechaDelIgual.getY());
       
	}
	
	// Fuente de la funcion de hash = https://www.artima.com/lejava/articles/equality.html
	
	@Override 
	public int hashCode() {
		
		return (41 * (41 + getX()) + getY());
       
   }

	public int distacina(Coordenadas destino) { //redondea para arriba
		return (int)Math.ceil( Math.hypot((double)destino.getX()-(double)this.getX(), (double)destino.getY()-(double)this.getY()));
	}
}
