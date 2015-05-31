package construcciones.terran;

import fiuba.algo3.algocraft.unidades.*;

public class Barraca extends ConstruccionTerran {

	public Barraca() {
		
		nombre = "Barraca";
		vida = 250;
	}

	public Unidad crearMarine() {
		Ubicacion terreno = new Terrestre();
		ClaseDeUnidad clase = new UnidadGerrera();
		Unidad marine = new Unidad(new Vida(40), new Danio(6,6, 4), 7, terreno, clase);
		
		return marine;
		
		//Falta agregarle el costo y que "alguien" lo disminuya del atributo "RecursosRecolectados" de la clase Jugador
	}

}
