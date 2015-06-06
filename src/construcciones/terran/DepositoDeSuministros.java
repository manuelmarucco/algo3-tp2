package construcciones.terran;

import construcciones.CentroDeSuministros;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;



public class DepositoDeSuministros extends CentroDeSuministros{

	
	public DepositoDeSuministros(Jugador jugador){
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		capacidadExtra = 5;
		jugador.aumentarSuministros(capacidadExtra);
	}


	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}
}
