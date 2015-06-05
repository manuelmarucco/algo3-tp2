package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;


public class Asimilador extends CentroDeEntrenamiento {
	
	private final int gasRecolectado = 10; //por turno
	private Recursos recursosDeJugador;
	private Escudo escudo;
	
	public Asimilador(Recursos recursos){

		vida = new Vida(450);
		escudo = new Escudo(450);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
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
		recursosDeJugador.agregarRecursos(0, gasRecolectado);
		super.update();
	}





}
