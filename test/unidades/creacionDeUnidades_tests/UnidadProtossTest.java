package unidades.creacionDeUnidades_tests;

import org.junit.Assert;
import org.junit.Test;
import unidades.protoss.*;

public class UnidadProtossTest {
    @Test
    public void testNuevoZealot(){
        UnidadProtoss zealot = new Zealot();
        Assert.assertEquals(100, zealot.getVida().getVidaActual());
        Assert.assertEquals(60, zealot.getEscudo().getEscudoActual());
        Assert.assertEquals(2,zealot.getSuministro());
        Assert.assertEquals(7,zealot.getVision());
    }

    @Test
    public void testNuevoDragon(){
        UnidadProtoss dragon = new Dragon();
        Assert.assertEquals(100,dragon.getVida().getVidaActual());
        Assert.assertEquals(80, dragon.getEscudo().getEscudoActual());
        Assert.assertEquals(2,dragon.getSuministro());
        Assert.assertEquals(8,dragon.getVision());
    }

    @Test
    public void testNuevoScout(){
        UnidadProtoss scout = new Scout();
        Assert.assertEquals(150,scout.getVida().getVidaActual());
        Assert.assertEquals(100,scout.getEscudo().getEscudoActual());
        Assert.assertEquals(3,scout.getSuministro());
        Assert.assertEquals(7,scout.getVision());
    }

    @Test
    public void testNuevoAltoTemplario(){
        UnidadProtoss altoTemplario = new AltoTemplario();
        Assert.assertEquals(40, altoTemplario.getVida().getVidaActual());
        Assert.assertEquals(40,altoTemplario.getEscudo().getEscudoActual());
        Assert.assertEquals(2,altoTemplario.getSuministro());
        Assert.assertEquals(7,altoTemplario.getVision());
    }

    @Test
    public void testNuevaNaveTransporteTerran(){
        UnidadProtoss naveTransporte = new NaveTransporte();
        Assert.assertEquals(80, naveTransporte.getVida().getVidaActual());
        Assert.assertEquals(60,naveTransporte.getEscudo().getEscudoActual());
        Assert.assertEquals(2,naveTransporte.getSuministro());
        Assert.assertEquals(8,naveTransporte.getVision());
    }

}
