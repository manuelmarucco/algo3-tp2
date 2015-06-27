package interfaces;

import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenada;

import java.util.ArrayList;

public interface Construible extends Actualizable{

	<T extends Construible> void esConstruible(ArrayList<T> cs,Recursos r, Coordenada coordenada) throws ExcepcionNoSePuedeConstruir;

	int getTiempoDeConstruccion(); // algo construible tiene q tener un tiempo de construccion y un costo obligatoriamente
	Costo getCosto();

}
