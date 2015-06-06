package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;


public class Acceso extends CentroDeEntrenamiento {

	private Escudo escudo;

	public Acceso(){
		vida = new Vida(500);
		escudo = new Escudo(500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
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

}
