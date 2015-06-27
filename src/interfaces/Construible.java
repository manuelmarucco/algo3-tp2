package interfaces;

import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenada;

import java.util.ArrayList;

public interface Construible extends Actualizable{

	<T extends Construible> void esConstruible(ArrayList<T> cs,Recursos r, Coordenada coordenada) throws ExcepcionNoSePuedeConstruir;

	int getTiempoDeConstruccion();

}
