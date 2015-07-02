package recursos_tests;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.recursos.Volcan;

public class VolcanTest {

    @Test
    public void deberiaDevolverDiezAlPedirleRecursosAlVolcan() {

        Volcan volcan = new Volcan();

        assertEquals( 10 , volcan.recolectarRecursos() );

    }

}
