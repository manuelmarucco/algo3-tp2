package construcciones.terran;


import construcciones.CentroDeEntrenamiento;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;
import unidades.terrran.Marine;

public class Barraca extends CentroDeEntrenamiento {

	
	public Barraca(){
		this.vida = new Vida(1000);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 12;
	} //por ahora para los tests
	public Barraca(Jugador j) {

		this.vida = new Vida(1000);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 12;
		this.jugador = j;
		
	}


	public Marine entrenarMarine(){
		Marine m = new Marine();
		this.colaDeEntrenamiento.add(m);
		return m;
	}

	@Override
	 public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}

	public boolean habilitaAConstruir(Fabrica f) {
		return true;
	}
}

