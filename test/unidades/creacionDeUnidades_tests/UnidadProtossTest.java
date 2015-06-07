package unidades.creacionDeUnidades_tests;

import org.junit.Assert;
import org.junit.Test;
import unidades.protoss.*;

public class UnidadProtossTest {
    @Test
    public void testNuevoZealot(){
        Zealot zealot = new Zealot();
        Assert.assertEquals(100, zealot.getVida());
        Assert.assertEquals(60, zealot.getEscudo());
        Assert.assertEquals(2,zealot.getSuministro());
        Assert.assertEquals(7,zealot.getVision());
    }

    @Test
    public void testNuevoDragon(){
        Dragon dragon = new Dragon();
        Assert.assertEquals(100,dragon.getVida());
        Assert.assertEquals(80, dragon.getEscudo());
        Assert.assertEquals(2,dragon.getSuministro());
        Assert.assertEquals(8,dragon.getVision());
    }

    @Test
    public void testNuevoScout(){
        Scout scout = new Scout();
        Assert.assertEquals(150,scout.getVida());
        Assert.assertEquals(100,scout.getEscudo());
        Assert.assertEquals(3,scout.getSuministro());
        Assert.assertEquals(7,scout.getVision());
    }

    @Test
    public void testNuevoAltoTemplario(){
        AltoTemplario altoTemplario = new AltoTemplario();
        Assert.assertEquals(40, altoTemplario.getVida());
        Assert.assertEquals(40,altoTemplario.getEscudo());
        Assert.assertEquals(2,altoTemplario.getSuministro());
        Assert.assertEquals(7,altoTemplario.getVision());
    }

    @Test
    public void testNuevaNaveTransporteTerran(){
        UnidadProtoss naveTransporte = new NaveTransporteProtoss();
        Assert.assertEquals(80, naveTransporte.getVida().getVidaActual());
        Assert.assertEquals(60,naveTransporte.getEscudo().getEscudoActual());
        Assert.assertEquals(2,naveTransporte.getSuministro());
        Assert.assertEquals(8,naveTransporte.getVision());
    }

}
