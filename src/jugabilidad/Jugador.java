package jugabilidad;

import java.util.ArrayList;

import construcciones.Construccion;

public class Jugador {

	private ArrayList<Construccion> construccionesCreadas = new ArrayList<Construccion>();

	public void construir(Construccion construccion) {
		construccionesCreadas.add(construccion);
	}
	
	public Construccion buscarConstruccionCreada(String nombre){
		for(Construccion c : construccionesCreadas){
			if(c.getNombre() == nombre){
					return c;
			}
		}
		return null;
	}
	
}
