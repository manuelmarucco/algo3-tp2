package interfaces;

import java.util.ArrayList;

import excepciones.ExcepcionNecesitaConstruirOtroEdificio;

public interface Construible extends Actualizable{

	public <T extends Construible> void verificaConstruccionPrevia(ArrayList<T> cs) throws ExcepcionNecesitaConstruirOtroEdificio;
	//si no funciona, volver a extends Construccion
}
