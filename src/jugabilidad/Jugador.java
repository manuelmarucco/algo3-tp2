package jugabilidad;

import java.util.ArrayList;

import construcciones.Construccion;
import construcciones.ProxyConstrucciones;

public class Jugador {

	private ArrayList<Construccion> construccionesCreadas = new ArrayList<Construccion>();

	public void construir(Construccion construccion) {
		ProxyConstrucciones proxy = new ProxyConstrucciones();
		
		proxy.esConstruible(construccion, construccionesCreadas);
		
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
