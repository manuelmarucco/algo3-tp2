package construcciones;

import java.util.ArrayList;

import construcciones.terran.Fabrica;

public class ProxyConstrucciones {
	
	public void esConstruible(Construccion construccion, ArrayList<Construccion> construccionesCreadas){
		
	}
	
	private void esConstruible2(Fabrica fabrica, ArrayList<Construccion> construccionesCreadas) {
		
		boolean construible = false;
		
		for(Construccion c : construccionesCreadas){
			if(c.getNombre() == "barraca"){
					construible = true;
			}
		}
		
		if(construible == false){
			// crear Excepcion 
		}
		
	}


}
