package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.ExcepcionNoSePuedeConstruir;
import unidades.Escudo;
import unidades.Vida;


public class PortalEstelar extends CentroDeEntrenamiento{

	private Escudo escudo;

	public PortalEstelar(){
		vida = new Vida(600);
		escudo = new Escudo(600);
		costo = new Costo(150,150);
		tiempoDeConstruccion = 10;
	}

	public int getEscudo() {
		return escudo.getEscudoActual();
	}

	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados) throws ExcepcionNoSePuedeConstruir{
		boolean construible = false;

		for (T c : cs) {
			if (((Construccion) c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirAcceso();

		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}
	
	public boolean habilitaAConstruir(ArchivosTemplarios t) {
		return true;
	}
	
}
