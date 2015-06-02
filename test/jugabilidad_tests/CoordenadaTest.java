package jugabilidad_tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import jugabilidad.utilidadesMapa.Coordenadas;

import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void deberiaDevolverDosEnLaCoordenadaX() {
		
		Coordenadas coordenada = new Coordenadas (2,1);
		assertEquals( 2, coordenada.getX() );
	
	}
	
	@Test 
	public void deberiaDevolverUnoEnLaCoordenadaY(){
		
		Coordenadas coordenada = new Coordenadas (2,1);
		assertEquals( 1, coordenada.getY() );
		
	}
	
	@Test
	public void dosCoordenadasConIgualCorrdenadaXeYDeberianTenerIgualHashCode(){
		
		Coordenadas coordenadaUno = new Coordenadas (2,1);
		Coordenadas coordenadaDos = new Coordenadas (2,1);
		
		assertEquals(coordenadaUno.hashCode(), coordenadaDos.hashCode());
	}
	
	@Test
	public void dosCoordenadasConIgualCorrdenadaXeYDeberianSerIguales(){
		
		Coordenadas coordenadaUno = new Coordenadas (2,1);
		Coordenadas coordenadaDos = new Coordenadas (2,1);
		
		assertEquals(coordenadaUno, coordenadaDos);
	}

	@Test
	public void dosCoordenadasConCorrdenadaXeYInvertidaDeberianSerDistintas(){
		
		Coordenadas coordenadaUno = new Coordenadas (2,1);
		Coordenadas coordenadaDos = new Coordenadas (1,2);
		
		assertThat(coordenadaUno, not(equalTo(coordenadaDos)));
		//assertNotEquals(coordenadaUno, coordenadaDos);  <- ant no compila
	}
}
