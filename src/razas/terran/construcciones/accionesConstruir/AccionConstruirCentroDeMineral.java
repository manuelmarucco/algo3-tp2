package razas.terran.construcciones.accionesConstruir;

import razas.terran.construcciones.CentroDeMineral;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirCentroDeMineral implements AccionConstruir{
		@Override
		public Construccion accionConstruir(Jugador jugador){
			CentroDeMineral centroDeMineral = new CentroDeMineral(jugador.getRecursos());
			return centroDeMineral;
		}
	}

