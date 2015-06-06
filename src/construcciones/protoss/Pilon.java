package construcciones.protoss;

import construcciones.CentroDeSuministros;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Escudo;
import unidades.Vida;


public class Pilon extends CentroDeSuministros {

	private Escudo escudo;
	
	public Pilon(Suministros suministros){

		vida = new Vida(300);
		escudo = new Escudo(300);
		this.costo = new Costo(100,0);
		this.tiempoDeConstruccion = 5;
		this.capacidadExtra = 5;
		suministros.aumentarSuministrosDisponibles(capacidadExtra);
	}

	public int getEscudo() {return escudo.getEscudoActual();}

	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}

}
