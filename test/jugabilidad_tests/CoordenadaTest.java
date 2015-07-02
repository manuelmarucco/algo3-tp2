package jugabilidad_tests;

import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CoordenadaTest {

	@Test
	public void deberiaDevolverDosEnLaCoordenadaX() {
		
		Coordenada coordenada = new Coordenada(2,1);
		assertEquals( 2, coordenada.getX() );
	
	}
	
	@Test 
	public void deberiaDevolverUnoEnLaCoordenadaY(){
		
		Coordenada coordenada = new Coordenada(2,1);
		assertEquals( 1, coordenada.getY() );
		
	}
	
	@Test
	public void dosCoordenadasConIgualCorrdenadaXeYDeberianTenerIgualHashCode(){
		
		Coordenada coordenadaUno = new Coordenada(2,1);
		Coordenada coordenadaDos = new Coordenada(2,1);
		
		assertEquals(coordenadaUno.hashCode(), coordenadaDos.hashCode());
	}
	
	@Test
	public void dosCoordenadasConIgualCorrdenadaXeYDeberianSerIguales(){
		
		Coordenada coordenadaUno = new Coordenada(2,1);
		Coordenada coordenadaDos = new Coordenada(2,1);
		
		assertEquals(coordenadaUno, coordenadaDos);
	}

	@Test
	public void dosCoordenadasConCorrdenadaXeYInvertidaDeberianSerDistintas(){
		
		Coordenada coordenadaUno = new Coordenada(2,1);
		Coordenada coordenadaDos = new Coordenada(1,2);
		
		assertThat(coordenadaUno, not(equalTo(coordenadaDos)));
		//assertNotEquals(coordenadaUno, coordenadaDos);  <- ant no compila
	}

	@Test
	public void paraLasDosCoordenadasDadasLaDistanciaDeberiaSerCuatro(){

		Coordenada coordenadaUno = new Coordenada(1,7);
		Coordenada coordenadaDos = new Coordenada(3,5);

		assertEquals(3,coordenadaDos.distancia(coordenadaUno));

	}

	@Test
	public void paraLasDosCoordenadasDeberiaSerIgualCalcularLaDistanciaDeUnoADosYDeDosAUno(){

		Coordenada coordenadaUno = new Coordenada(1,7);
		Coordenada coordenadaDos = new Coordenada(3,5);

		assertEquals(coordenadaUno.distancia(coordenadaDos),coordenadaDos.distancia(coordenadaUno));

	}

	@Test
		 public void seDeveriaComprobarQueSiAumentoUnaCoordenadaXSoloXCambie(){

		Coordenada coordenada = new Coordenada(1,1);
		coordenada.aumentarX(1);

		//Sigue igual.
		assertEquals(1,coordenada.getY());
		//Cambia.
		assertEquals(2,coordenada.getX());

	}

	@Test
	public void seDeveriaComprobarQueSiAumentoUnaCoordenadaYSoloYCambie(){

		Coordenada coordenada = new Coordenada(1,1);
		coordenada.aumentarY(1);

		//Sigue igual.
		assertEquals(1,coordenada.getX());
		//Cambia.
		assertEquals(2,coordenada.getY());

	}

}
