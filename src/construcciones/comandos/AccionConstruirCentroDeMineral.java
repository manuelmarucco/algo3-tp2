package construcciones.comandos;

import interfaces.AccionConstruir;
import construcciones.Construccion;
import construcciones.terran.CentroDeMineral;

public class AccionConstruirCentroDeMineral implements AccionConstruir{
		@Override
		public Construccion accionConstruir(){
			CentroDeMineral centroDeMineral = new CentroDeMineral();
			return centroDeMineral;
		}
	}

