package construcciones.protoss;


import construcciones.CentroDeEntrenamiento;
import construcciones.CentroDeRecoleccion;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;


public class NexoMineral extends CentroDeRecoleccion {

	private Escudo escudo;

	public NexoMineral(Recursos recursos){

		vida = new Vida(250);
		escudo = new Escudo(250);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		recursosDeJugador = recursos;
	}

	public int getEscudo() {
		return escudo.getEscudoActual();
	}

	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}


}
