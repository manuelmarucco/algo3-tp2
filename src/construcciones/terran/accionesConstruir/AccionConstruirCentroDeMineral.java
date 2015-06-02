package construcciones.terran.accionesConstruir;

import construcciones.Construccion;
import construcciones.terran.CentroDeMineral;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirCentroDeMineral implements AccionConstruir{
		@Override
		public Construccion accionConstruir(Jugador jugador){
			CentroDeMineral centroDeMineral = new CentroDeMineral(jugador.getRecursos());
			return centroDeMineral;
		}
	}

