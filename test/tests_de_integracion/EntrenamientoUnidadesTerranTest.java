package tests_de_integracion;

import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import org.junit.Assert;
import org.junit.Test;
import razas.Terran;
import unidades.terrran.Golliat;
import unidades.terrran.Marine;

public class EntrenamientoUnidadesTerranTest {

	@Test
	public void entrenoMarineYSeAgregaAlJugador() {
		Jugador j = new Jugador(new Terran(),new Recursos(1000,0));
		Barraca b = new Barraca(j);
		Marine m = new Marine();
		
		j.construir(b);
		for(int i = 0; i<12; i++) j.update();
		
		b.entrenarMarine(m);
		for(int i = 0; i<3; i++) j.update();
		
		Assert.assertTrue(j.buscarUnidad(m));
	}

	@Test
	public void entrenoGolliatYSeAgregaAlJugador() {
		Jugador j = new Jugador(new Terran(),new Recursos(1000,1000));
		Barraca b = new Barraca(j);
		Fabrica f = new Fabrica(j);
		Golliat g = new Golliat();

		j.construir(b);
		for(int i = 0; i<12; i++) j.update();
		j.construir(f);
		for(int i = 0; i<12; i++) j.update();

		f.entrenarGolliat(g);
		for(int i = 0; i<6; i++) j.update();

		Assert.assertTrue(j.buscarUnidad(g));
	}


}
