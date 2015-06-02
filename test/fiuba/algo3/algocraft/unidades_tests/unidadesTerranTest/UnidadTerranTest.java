package fiuba.algo3.algocraft.unidades_tests.unidadesTerranTest;

import fiuba.algo3.algocraft.unidades.Parametros;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.algocraft.unidades.terran.*;
import org.junit.Assert;
import org.junit.Test;

public class UnidadTerranTest {
    @Test
    public void testNuevoMarine(){
        Unidad marine = new Marine();
        Assert.assertEquals(40,marine.getVida().getVidaActual());
        Assert.assertEquals(1,marine.getSuministro());
        Assert.assertEquals(6,marine.getParametroDeClase().get(Parametros.TERRESTRE).intValue());
        Assert.assertEquals(6,marine.getParametroDeClase().get(Parametros.AEREO).intValue());
        Assert.assertEquals(4,marine.getParametroDeClase().get(Parametros.RANGOTERRESTRE).intValue());
        Assert.assertEquals(4,marine.getParametroDeClase().get(Parametros.RANGOAEREO).intValue());
        Assert.assertEquals(7,marine.getVision());
    }

    @Test
    public void testNuevoGolliat(){
        Unidad golliat = new Golliat();
        Assert.assertEquals(125,golliat.getVida().getVidaActual());
        Assert.assertEquals(2,golliat.getSuministro());
        Assert.assertEquals(12,golliat.getParametroDeClase().get(Parametros.TERRESTRE).intValue());
        Assert.assertEquals(10,golliat.getParametroDeClase().get(Parametros.AEREO).intValue());
        Assert.assertEquals(6,golliat.getParametroDeClase().get(Parametros.RANGOTERRESTRE).intValue());
        Assert.assertEquals(5,golliat.getParametroDeClase().get(Parametros.RANGOAEREO).intValue());
        Assert.assertEquals(8,golliat.getVision());
    }

    @Test
    public void testNuevoEspectro(){
        Unidad espectro = new Espectro();
        Assert.assertEquals(120,espectro.getVida().getVidaActual());
        Assert.assertEquals(2,espectro.getSuministro());
        Assert.assertEquals(8,espectro.getParametroDeClase().get(Parametros.TERRESTRE).intValue());
        Assert.assertEquals(20,espectro.getParametroDeClase().get(Parametros.AEREO).intValue());
        Assert.assertEquals(5,espectro.getParametroDeClase().get(Parametros.RANGOTERRESTRE).intValue());
        Assert.assertEquals(5,espectro.getParametroDeClase().get(Parametros.RANGOAEREO).intValue());
        Assert.assertEquals(7,espectro.getVision());
    }

    @Test
    public void testNuevaNaveCiencia(){
        Unidad naveCiencia = new NaveCiencia();
        Assert.assertEquals(200, naveCiencia.getVida().getVidaActual());
        Assert.assertEquals(2,naveCiencia.getSuministro());
        Assert.assertEquals(50,naveCiencia.getParametroDeClase().get(Parametros.ENERGIAACTUAL).intValue());
        Assert.assertEquals(200,naveCiencia.getParametroDeClase().get(Parametros.ENERGIATOTAL).intValue());
        Assert.assertEquals(10,naveCiencia.getParametroDeClase().get(Parametros.REGENERACIONDEENERGIA).intValue());
        Assert.assertEquals(10,naveCiencia.getVision());
    }

    @Test
    public void testNuevaNaveTransporteTerran(){
        Unidad naveTransporte = new NaveTransporte();
        Assert.assertEquals(150, naveTransporte.getVida().getVidaActual());
        Assert.assertEquals(2,naveTransporte.getSuministro());
        Assert.assertEquals(0,naveTransporte.getParametroDeClase().get(Parametros.CAPACIDADACTUAL).intValue());
        Assert.assertEquals(8,naveTransporte.getParametroDeClase().get(Parametros.CAPACIDADTRANSPORTE).intValue());
        Assert.assertEquals(8,naveTransporte.getVision());
    }

}
