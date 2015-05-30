package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void testNuevaUnidadCon200deVida(){
        Unidad marine= new Unidad(200);
        Assert.assertEquals(marine.getVida(),200);
    }

    @Test
    public void testNuevaUnidadCon6deDanioAereoYterrestre(){
        Unidad marine = new Unidad(200);
        marine.setDanioAereo(6);
        marine.setDanioTerrestre(6);
        Assert.assertEquals(marine.getDanioAereo(), 6);
        Assert.assertEquals(marine.getDanioTerrestre(),6);
    }

    @Test
    public void testNuevaUnidadConRangoDeAtaque4(){
        Unidad marine = new Unidad(200);
        marine.setRangoDeAtaque(4);
        Assert.assertEquals(marine.getRangoDeAtaque(), 4);

    }
}