package construcciones.terran;

import fiuba.algo3.algocraft.unidades.ClaseDeUnidad;
import fiuba.algo3.algocraft.unidades.RazaDeUnidad;
import fiuba.algo3.algocraft.unidades.TerrenoDeUnidad;
import fiuba.algo3.algocraft.unidades.TerrenoUnidadTerrestre;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.algocraft.unidades.UnidadGerrera;
import fiuba.algo3.algocraft.unidades.UnidadRazaTerran;

public class Barraca extends ConstruccionTerran {

	public Barraca() {
		
		nombre = "Barraca";
		vida = 250;
	}

	public Unidad crearMarine() {
		RazaDeUnidad raza = new UnidadRazaTerran();
		TerrenoDeUnidad terreno = new TerrenoUnidadTerrestre();
		ClaseDeUnidad clase = new UnidadGerrera();
		Unidad marine = new Unidad(40, 6, 6, 4, 7, raza, terreno, clase);
		
		return marine;
		
		//Falta agregarle el costo y que "alguien" lo disminuya del atributo "RecursosRecolectados" de la clase Jugador
	}

}
