package interfaces;

import excepciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;

public interface Construible extends Actualizable{

	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos r, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir;

	public int getTiempoDeConstruccion();
	
}
