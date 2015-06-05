package interfaces;

import java.util.ArrayList;

import jugabilidad.auxiliares.Recursos;
import excepciones.ExcepcionNoSePuedeConstruir;

public interface Construible extends Actualizable{

	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos r) throws ExcepcionNoSePuedeConstruir;
	//public void esConstruibleAPartirDeRecursos(Recursos r) throws ExcepcionRecursosInsuficientes;
	
}
