package construcciones.comandos;

import auxiliares.Costo;
import construcciones.Construccion;
import construcciones.terran.Barraca;
import excepciones.ExcepcionRecursosInsuficientes;
import interfaces.AccionConstruir;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class AccionConstruirBarraca implements AccionConstruir{
	private final Jugador jugador;
	private final Mapa mapa;

	public AccionConstruirBarraca(Jugador jugador, Mapa mapa){
		this.jugador=jugador;
		this.mapa = mapa;
	}

	public void actuar(Coordenadas coordenadas){
		Construccion barraca = new Barraca();
		try {
			this.jugador.getRecursos().gastarRecursos(new Costo(150,0));
		} catch (ExcepcionRecursosInsuficientes excepcionRecursosInsuficientes) {
			excepcionRecursosInsuficientes.printStackTrace();
			return;
		}
		this.mapa.agregar(barraca,coordenadas);
	}
}
