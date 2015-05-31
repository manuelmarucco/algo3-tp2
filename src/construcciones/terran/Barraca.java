package construcciones.terran;

import auxiliares.Costo;
import auxiliares.Recursos;
import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.*;

public class Barraca extends ConstruccionTerran {

	public Barraca() {

		this.vida = new Vida(250);
		//this.regenerar = new NoRegenerar();
		nombre = "Barraca";
		costo = new Costo(150,0);
	}
	/*
	public void update(){
		this.regenerar.regenerar(this);
	}
	*/
	public Unidad crearMarine() {
		
		Ubicacion terreno = new Terrestre();
		ClaseDeUnidad clase = new UnidadGuerrera(new Danio(6,6, 4));
		Unidad marine = new Unidad(new Vida(40), 7, terreno, clase);
		
		return marine;
		
		//Falta agregarle el costo y que "alguien" lo disminuya del atributo "RecursosRecolectados" de la clase Jugador
	}

}
