package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.unidades.TerrenoDeUnidad;
import fiuba.algo3.algocraft.unidades.TerrenoUnidadAerea;
import fiuba.algo3.algocraft.unidades.TerrenoUnidadTerrestre;
import fiuba.algo3.algocraft.unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

public class TerrenoDeUnidadTest {

    @Test
    public void testRecibirDanioAereo(){
        TerrenoDeUnidad terrenoAereo = new TerrenoUnidadAerea();
        Unidad unidad = new Unidad(200,1,5,4,1);
        Assert.assertEquals(terrenoAereo.recibirDanio(unidad), 5);
    }

    @Test
    public void testRecibirDanioterrestre(){
        TerrenoDeUnidad terrenoAereo = new TerrenoUnidadTerrestre();
        Unidad unidad = new Unidad(200,1,5,4,1);
        Assert.assertEquals(terrenoAereo.recibirDanio(unidad),1);
    }
}