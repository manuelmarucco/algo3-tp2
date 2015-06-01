package construcciones.terran;

/*
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
*/
import auxiliares.Costo;
//import auxiliares.Recursos;
//import excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.unidades.*;

public class Barraca extends ConstruccionTerran {

	public Barraca() {

		this.vida = new Vida(1000);
		nombre = "Barraca";
		costo = new Costo(150,0);
		tiempoDeConstruccion = 12;
	}
	/*
	public void update(){
		this.regenerar.regenerar(this);
	}
	*/
	public Unidad entrenarMarine() {
		
		Ubicacion terreno = new Terrestre();
		ClaseDeUnidad clase = new UnidadGuerrera(new Danio(6,6, 4));
		Unidad marine = new Unidad(new Vida(40), 7, terreno, clase,new Costo(50,0));
		//falta Transporte,TiempoDeCosntruccion,Suministro,RangoDeAtaque
		return marine;
	}
	/*
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
*/
}
