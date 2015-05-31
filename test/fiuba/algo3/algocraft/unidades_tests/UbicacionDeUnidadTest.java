package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.unidades.*;
import org.junit.Assert;
import org.junit.Test;

public class UbicacionDeUnidadTest {

    @Test
    public void testRecibirDanioAereo(){
        Ubicacion terrenoAereo = new Aereo();
        Assert.assertEquals(5, terrenoAereo.danioDe(new Danio(1, 5, 4)));
    }

    @Test
    public void testRecibirDanioterrestre(){
        Ubicacion terrenoTerrestre = new Terrestre();
        Assert.assertEquals(1, terrenoTerrestre.danioDe(new Danio(1, 5, 4)));
    }
}