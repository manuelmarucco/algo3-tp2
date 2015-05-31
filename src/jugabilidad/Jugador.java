package jugabilidad;

import java.util.ArrayList;

import construcciones.Construccion;
import construcciones.ProxyConstrucciones;
import excepciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.ExcepcionNecesitaConstruirBarraca;
import excepciones.ExcepcionNecesitaConstruirFabrica;
import excepciones.ExcepcionNecesitaConstruirPortalEstelar;

public class Jugador {
	
	private 
	private ArrayList<Construccion> construccionesCreadas = new ArrayList<Construccion>();

	public void construir(Construccion construccion){
		ProxyConstrucciones proxy = new ProxyConstrucciones();
		
		try{
			proxy.esConstruible(construccion, construccionesCreadas);
		}catch(ExcepcionNecesitaConstruirBarraca | 
				ExcepcionNecesitaConstruirAcceso |
				ExcepcionNecesitaConstruirFabrica|
				ExcepcionNecesitaConstruirPortalEstelar e){
			return; //dentro de las excepciones habria q hacer q aparezca un cartelito q le avise al usuario porque no la puede construir
		}
		
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
