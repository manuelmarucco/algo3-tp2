package interfaces;

import jugabilidad.auxiliares.Costo;

public interface Entrenable {
	public void disminuirTiempoDeEntrenamiento();
	int getTiempoDeEntrenamiento();
	public Costo getCosto();
	public int getSuministro();
}
