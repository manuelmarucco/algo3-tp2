package interfaces;

import jugabilidad.auxiliares.Costo;

public interface Entrenable extends ColocableEnMapa {
	public void disminuirTiempoDeEntrenamiento();
	int getTiempoDeEntrenamiento();
	public Costo getCosto();
	public int getSuministro();
}
