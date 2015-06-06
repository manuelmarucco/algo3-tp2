package construcciones.terran;

import construcciones.CentroDeSuministros;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;



public class DepositoDeSuministros extends CentroDeSuministros{

	
	public DepositoDeSuministros(Suministros suministros){
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		capacidadExtra = 5;
		suministros.aumentarSuministrosDisponibles(5);
	}


	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}
}
