package tests_de_integracion;

import construcciones.terran.Barraca;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import org.junit.Assert;
import org.junit.Test;
import razas.Terran;
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

}
