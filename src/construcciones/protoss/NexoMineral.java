package construcciones.protoss;


import construcciones.CentroDeEntrenamiento;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;


public class NexoMineral extends CentroDeEntrenamiento {

	private final int mineralesRecolectados = 10; //por turno
	private Recursos recursosDeJugador;
	private Escudo escudo;

	public NexoMineral(Recursos recursos){

		vida = new Vida(250);
		escudo = new Escudo(250);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		recursosDeJugador = recursos;
	}

	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		recursosDeJugador.agregarRecursos(mineralesRecolectados, 0);
		super.update();
	}

}
