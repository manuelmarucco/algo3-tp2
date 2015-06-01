package construcciones.comandos;

import interfaces.Construible;
import construcciones.Construccion;
import construcciones.terran.CentroDeMineral;

public class AccionConstruirCentroDeMineral implements Construible{
		@Override
		public Construccion accionConstruir(){
			CentroDeMineral centroDeMineral = new CentroDeMineral();
			return centroDeMineral;
		}
	}

