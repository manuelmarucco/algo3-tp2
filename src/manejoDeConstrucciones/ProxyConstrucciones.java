package manejoDeConstrucciones;

import java.util.ArrayList;

import manejoDeConstrucciones.comandos.ConstruccionesDisponibles;
import excepciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.ExcepcionNecesitaConstruirBarraca;
import excepciones.ExcepcionNecesitaConstruirFabrica;
import excepciones.ExcepcionNecesitaConstruirPortalEstelar;
import excepciones.ExcepcionNecesitaCrearOtraConstruccionPrevia;

public class ProxyConstrucciones {
	
	//HABRIA QUE BUSCAR UNA MANERA MEJOR DE RESOLVER ESTO, POR AHORA ES PARA Q PASE
	
	public void esConstruible(ConstruccionesDisponibles construccion, ArrayList<Construccion> construccionesCreadas) 
					throws 	ExcepcionNecesitaCrearOtraConstruccionPrevia
	{
		if(construccion.name() == "FABRICA"){
			this.fabricaEsConstruible(construccionesCreadas);
		}
		if(construccion.name() == "PUERTOESTELAR"){
			this.puertoEstelarEsConstruible(construccionesCreadas);
		}
		if(construccion.name() == "PORTALESTELAR"){
			this.portalEstelarEsConstruible(construccionesCreadas);
		}
		if(construccion.name() == "ARCHIVOSTEMPLARIOS"){
			this.archivosTemplariosEsConstruible(construccionesCreadas);
		}
	};
	
	private void fabricaEsConstruible(ArrayList<Construccion> construccionesCreadas)
			throws ExcepcionNecesitaConstruirBarraca{
		
		boolean construible = false;
		
		for(Construccion c : construccionesCreadas){
			if(c.getNombre() == "Barraca"){
					construible = true;
			}
		}
		
		if(construible == false){
			throw new ExcepcionNecesitaConstruirBarraca();
		}
		
		
	}
	
	private void puertoEstelarEsConstruible(ArrayList<Construccion> construccionesCreadas) 
			throws ExcepcionNecesitaConstruirFabrica{
		
		boolean construible = false;
		
		for(Construccion c : construccionesCreadas){
			if(c.getNombre() == "Fabrica"){
					construible = true;
			}
		}
		
		if(construible == false){
			throw new ExcepcionNecesitaConstruirFabrica();
		}
		
		
	}
	
	private void portalEstelarEsConstruible(ArrayList<Construccion> construccionesCreadas) 
			throws ExcepcionNecesitaConstruirAcceso{
		
		boolean construible = false;
		
		for(Construccion c : construccionesCreadas){
			if(c.getNombre() == "Acceso"){
					construible = true;
			}
		}
		
		if(construible == false){
			throw new ExcepcionNecesitaConstruirAcceso();
		}

	}
	
	private void archivosTemplariosEsConstruible(ArrayList<Construccion> construccionesCreadas)
			throws ExcepcionNecesitaConstruirPortalEstelar{
		
		boolean construible = false;
		
		for(Construccion c : construccionesCreadas){
			if(c.getNombre() == "PortalEstelar"){
					construible = true;
			}
		}
		
		if(construible == false){
			throw new ExcepcionNecesitaConstruirPortalEstelar();
		}

	}


}
