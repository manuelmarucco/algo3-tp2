package modelo.construcciones.terran;

import modelo.construcciones.CentroDeSuministros;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.terrran.ResistenciaTerran;


public class DepositoDeSuministros extends CentroDeSuministros {

	
	public DepositoDeSuministros(Suministros suministros){
		resistencia = new ResistenciaTerran(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		capacidadExtra = 5;
		this.suministrosDelJugador = suministros;
		//suministrosDelJugador.aumentarSuministrosLimiteActuales(5);
	}

	@Override
	public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}
