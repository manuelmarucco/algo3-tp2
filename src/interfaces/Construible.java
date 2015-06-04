package interfaces;

import java.util.ArrayList;

import jugabilidad.auxiliares.Recursos;
import excepciones.ExcepcionNecesitaConstruirOtroEdificio;
import excepciones.ExcepcionRecursosInsuficientes;

public interface Construible extends Actualizable{

	public <T extends Construible> void verificaConstruccionPrevia(ArrayList<T> cs) throws ExcepcionNecesitaConstruirOtroEdificio;
	public void esConstruibleAPartirDeRecursos(Recursos r) throws ExcepcionRecursosInsuficientes;
	
}
