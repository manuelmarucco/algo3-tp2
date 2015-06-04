package unidades.creacionDeUnidades_tests;

import org.junit.Assert;
import org.junit.Test;
import unidades.Unidad;
import unidades.terrran.*;

public class UnidadTerranTest {
    @Test
    public void testNuevoMarine(){
        Unidad marine = new Marine();
        Assert.assertEquals(40,marine.getVida().getVidaActual());
        Assert.assertEquals(1,marine.getSuministro());
        Assert.assertEquals(7,marine.getVision());
    }

    @Test
    public void testNuevoGolliat(){
        Unidad golliat = new Golliat();
        Assert.assertEquals(125,golliat.getVida().getVidaActual());
        Assert.assertEquals(2,golliat.getSuministro());
        Assert.assertEquals(8,golliat.getVision());
    }

    @Test
    public void testNuevoEspectro(){
        Unidad espectro = new Espectro();
        Assert.assertEquals(120,espectro.getVida().getVidaActual());
        Assert.assertEquals(2,espectro.getSuministro());
        Assert.assertEquals(7,espectro.getVision());
    }

    @Test
    public void testNuevaNaveCiencia(){
        Unidad naveCiencia = new NaveCiencia();
        Assert.assertEquals(200, naveCiencia.getVida().getVidaActual());
        Assert.assertEquals(2,naveCiencia.getSuministro());
        Assert.assertEquals(10,naveCiencia.getVision());
    }

    @Test
    public void testNuevaNaveTransporteTerran(){
        Unidad naveTransporte = new NaveTransporte();
        Assert.assertEquals(150, naveTransporte.getVida().getVidaActual());
        Assert.assertEquals(2,naveTransporte.getSuministro());
        Assert.assertEquals(8,naveTransporte.getVision());
    }

}
