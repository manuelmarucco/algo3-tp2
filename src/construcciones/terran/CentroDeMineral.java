package construcciones.terran;

import construcciones.CentroDeRecoleccion;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;

public class CentroDeMineral extends CentroDeRecoleccion {

	public CentroDeMineral(Recursos recursos){
		vida = new Vida(500);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		this.recursosDeJugador = recursos;
	}


	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}

}
