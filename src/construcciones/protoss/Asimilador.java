package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import construcciones.CentroDeRecoleccion;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;


public class Asimilador extends CentroDeRecoleccion {

	private Escudo escudo;
	
	public Asimilador(Recursos recursos){

		vida = new Vida(450);
		escudo = new Escudo(450);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
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
