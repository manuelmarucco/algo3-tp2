package modelo.interfaces;

import modelo.jugabilidad.auxiliares.Costo;

public interface Entrenable extends ColocableEnMapa {
	void disminuirTiempoDeEntrenamientoActual();
	int getTiempoDeEntrenamientoActual();
	int getTiempoDeEntrenamientoTotal();
	Costo getCosto();
	int getSuministro();
}
