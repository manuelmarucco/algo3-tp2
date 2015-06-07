package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Costo;
import unidades.Escudo;
import unidades.Vida;
import unidades.protoss.Dragon;
import unidades.protoss.Zealot;


public class Acceso extends CentroDeEntrenamiento {

	private Escudo escudo;

	public Acceso(){
		vida = new Vida(500);
		escudo = new Escudo(500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
	}

	public Acceso(Jugador j){
		vida = new Vida(500);
		escudo = new Escudo(500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
		this.jugador = j;
	}



	public int getEscudo() {
		return escudo.getEscudoActual();
	}

	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}


	public boolean habilitaAConstruir(PortalEstelar t) {
		return true;
	}

	public Zealot entrenarZealot(){
		Zealot z = new Zealot();
		this.colaDeEntrenamiento.add(z);
		return z;
	}

	public Dragon entrenarDragon(){
		Dragon d = new Dragon();
		this.colaDeEntrenamiento.add(d);
		return d;
	}

}
