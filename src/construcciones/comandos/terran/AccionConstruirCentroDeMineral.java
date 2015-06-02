package construcciones.comandos.terran;

import jugabilidad.Jugador;
import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.CentroDeMineral;

public class AccionConstruirCentroDeMineral implements AccionConstruir{
		@Override
		public Construccion accionConstruir(Jugador jugador){
			CentroDeMineral centroDeMineral = new CentroDeMineral(jugador.getRecursos());
			return centroDeMineral;
		}
	}

