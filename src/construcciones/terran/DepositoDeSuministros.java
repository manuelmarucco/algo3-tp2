package construcciones.terran;

import construcciones.CentroDeSuministros;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Suministros;
import unidades.Vida;



public class DepositoDeSuministros extends CentroDeSuministros{

	
	public DepositoDeSuministros(Suministros suministros){
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		capacidadExtra = 5;
		this.suministrosDelJugador = suministros;
		//suministrosDelJugador.aumentarSuministrosLimiteActuales(5);
	}


	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}
}
