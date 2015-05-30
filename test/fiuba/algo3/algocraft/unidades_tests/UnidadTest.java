package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.unidades.TerrenoDeUnidad;
import fiuba.algo3.algocraft.unidades.TerrenoUnidadAerea;
import fiuba.algo3.algocraft.unidades.TerrenoUnidadTerrestre;
import fiuba.algo3.algocraft.unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void testConstructorCompleto(){
        Unidad marine = new Unidad(200,6,6,4,7);//vida , danio terrestre ,danio aereo , rango de ataque , vision
        Assert.assertEquals(marine.getVida(),200);
        Assert.assertEquals(marine.getDanioAereo(), 6);
        Assert.assertEquals(marine.getDanioTerrestre(),6);
        Assert.assertEquals(marine.getRangoDeAtaque(), 4);
        Assert.assertEquals(marine.getVision(), 7);

    }

    @Test
    public void testNuevaUnidadAerea(){
        Unidad nave = new Unidad(100, 1, 1, 1, 1);
        TerrenoDeUnidad aereo = new TerrenoUnidadAerea();
        nave.setTerreno(aereo);
        Assert.assertEquals(nave.getTerreno(), aereo);
    }

    @Test
    public void testNuevaUnidadTerrestre(){
        Unidad nave = new Unidad(100, 1, 1, 1, 1);
        TerrenoDeUnidad terrestre = new TerrenoUnidadTerrestre();
        nave.setTerreno(terrestre);
        Assert.assertEquals(nave.getTerreno(), terrestre);
    }

    @Test
    public void testAtacar(){
        Unidad marine1 = new Unidad(200,6,6,4,7);
        Unidad marine2 = new Unidad(200,6,6,4,7);
        TerrenoDeUnidad terrestre = new TerrenoUnidadTerrestre();
        marine2.setTerreno(terrestre);
        marine1.atacar(marine2);
        Assert.assertEquals(marine2.getVida(), 194);
    }
}