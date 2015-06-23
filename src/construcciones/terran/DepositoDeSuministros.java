package construcciones.terran;

import construcciones.CentroDeSuministros;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.ResistenciaTerran;


public class DepositoDeSuministros extends CentroDeSuministros{

	
	public DepositoDeSuministros(Suministros suministros){
		resistencia = new ResistenciaTerran(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		capacidadExtra = 5;
		this.suministrosDelJugador = suministros;
		//suministrosDelJugador.aumentarSuministrosLimiteActuales(5);
	}

	@Override
	public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}
