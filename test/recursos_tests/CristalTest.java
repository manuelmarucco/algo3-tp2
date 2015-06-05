package recursos_tests;

import static org.junit.Assert.*;
import org.junit.Test;
import recursos.Cristal;

public class CristalTest {

	@Test
	public void deberiaDevolverDiezAlPedirleRecursosAlCristal() {
		
		Cristal cristal = new Cristal();
		
		assertEquals( 10 , cristal.recolectarRecursos() );
		
	}

}
