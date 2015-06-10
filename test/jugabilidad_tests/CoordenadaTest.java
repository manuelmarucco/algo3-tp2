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

	@Test
	public void paraLasDosCoordenadasDadasLaDistanciaDeberiaSerCuatro(){

		Coordenadas coordenadaUno = new Coordenadas(1,7);
		Coordenadas coordenadaDos = new Coordenadas(3,5);

		assertEquals(3,coordenadaDos.distancia(coordenadaUno));

	}

	@Test
	public void paraLasDosCoordenadasDeberiaSerIgualCalcularLaDistanciaDeUnoADosYDeDosAUno(){

		Coordenadas coordenadaUno = new Coordenadas(1,7);
		Coordenadas coordenadaDos = new Coordenadas(3,5);

		assertEquals(coordenadaUno.distancia(coordenadaDos),coordenadaDos.distancia(coordenadaUno));

	}

	@Test
		 public void seDeveriaComprobarQueSiAumentoUnaCoordenadaXSoloXCambie(){

		Coordenadas coordenada = new Coordenadas(1,1);
		coordenada.aumentarX(1);

		//Sigue igual.
		assertEquals(1,coordenada.getY());
		//Cambia.
		assertEquals(2,coordenada.getX());

	}

	@Test
	public void seDeveriaComprobarQueSiAumentoUnaCoordenadaYSoloYCambie(){

		Coordenadas coordenada = new Coordenadas(1,1);
		coordenada.aumentarY(1);

		//Sigue igual.
		assertEquals(1,coordenada.getX());
		//Cambia.
		assertEquals(2,coordenada.getY());

	}

}
