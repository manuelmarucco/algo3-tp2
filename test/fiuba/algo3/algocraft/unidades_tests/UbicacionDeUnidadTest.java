package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.unidades.*;
import org.junit.Assert;
import org.junit.Test;

public class UbicacionDeUnidadTest {

    @Test
    public void testRecibirDanioAereo(){
        Ubicacion terrenoAereo = new Aereo();
        Unidad unidad = new Unidad(new Vida(200), new Danio(1, 5, 4), 1, new Aereo(), new UnidadGerrera());
        Assert.assertEquals(terrenoAereo.danioDe(unidad.getDanio()), 5);
    }

    @Test
    public void testRecibirDanioterrestre(){
        Ubicacion terrenoAereo = new Terrestre();
        Unidad unidad = new Unidad(new Vida(200), new Danio(1, 5, 4), 1, new Terrestre(), new UnidadGerrera());
        Assert.assertEquals(terrenoAereo.danioDe(unidad.getDanio()),1);
    }
}