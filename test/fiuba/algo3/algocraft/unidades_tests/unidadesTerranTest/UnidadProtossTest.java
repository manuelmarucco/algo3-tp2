package fiuba.algo3.algocraft.unidades_tests.unidadesTerranTest;

import fiuba.algo3.algocraft.unidades.Parametros;
import fiuba.algo3.algocraft.unidades.Protoss.AltoTemplario;
import fiuba.algo3.algocraft.unidades.Protoss.Dragon;
import fiuba.algo3.algocraft.unidades.Protoss.Scout;
import fiuba.algo3.algocraft.unidades.Protoss.Zealot;
import fiuba.algo3.algocraft.unidades.Unidad;
import fiuba.algo3.algocraft.unidades.VidaEscudo;
import fiuba.algo3.algocraft.unidades.Protoss.NaveTransporte;
import org.junit.Assert;
import org.junit.Test;

public class UnidadProtossTest {
    @Test
    public void testNuevoZealot(){
        Unidad zealot = new Zealot();
        Assert.assertEquals(60, zealot.getVida().getVidaActual());
        Assert.assertEquals(100, ((VidaEscudo) zealot.getVida()).getEscudoActual());//TODO sobreescribir el metodo get vida para q devuelvo VidaEscudo
        Assert.assertEquals(2,zealot.getSuministro());
        Assert.assertEquals(8,zealot.getParametroDeClase().get(Parametros.TERRESTRE).intValue());
        Assert.assertEquals(0,zealot.getParametroDeClase().get(Parametros.AEREO).intValue());
        Assert.assertEquals(1,zealot.getParametroDeClase().get(Parametros.RANGOTERRESTRE).intValue());
        Assert.assertEquals(0,zealot.getParametroDeClase().get(Parametros.RANGOAEREO).intValue());
        Assert.assertEquals(7,zealot.getVision());
    }

    @Test
    public void testNuevoDragon(){
        Unidad dragon = new Dragon();
        Assert.assertEquals(80,dragon.getVida().getVidaActual());
        Assert.assertEquals(100,((VidaEscudo)dragon.getVida()).getEscudoActual());
        Assert.assertEquals(2,dragon.getSuministro());
        Assert.assertEquals(20,dragon.getParametroDeClase().get(Parametros.TERRESTRE).intValue());
        Assert.assertEquals(20,dragon.getParametroDeClase().get(Parametros.AEREO).intValue());
        Assert.assertEquals(4,dragon.getParametroDeClase().get(Parametros.RANGOTERRESTRE).intValue());
        Assert.assertEquals(4,dragon.getParametroDeClase().get(Parametros.RANGOAEREO).intValue());
        Assert.assertEquals(8,dragon.getVision());
    }

    @Test
    public void testNuevoScout(){
        Unidad scout = new Scout();
        Assert.assertEquals(100,scout.getVida().getVidaActual());
        Assert.assertEquals(150,((VidaEscudo)scout.getVida()).getEscudoActual());
        Assert.assertEquals(3,scout.getSuministro());
        Assert.assertEquals(8,scout.getParametroDeClase().get(Parametros.TERRESTRE).intValue());
        Assert.assertEquals(14,scout.getParametroDeClase().get(Parametros.AEREO).intValue());
        Assert.assertEquals(4,scout.getParametroDeClase().get(Parametros.RANGOTERRESTRE).intValue());
        Assert.assertEquals(4,scout.getParametroDeClase().get(Parametros.RANGOAEREO).intValue());
        Assert.assertEquals(7,scout.getVision());
    }

    @Test
    public void testNuevoAltoTemplario(){
        Unidad altoTemplario = new AltoTemplario();
        Assert.assertEquals(40, altoTemplario.getVida().getVidaActual());
        Assert.assertEquals(40,((VidaEscudo)altoTemplario.getVida()).getEscudoActual());
        Assert.assertEquals(2,altoTemplario.getSuministro());
        Assert.assertEquals(50,altoTemplario.getParametroDeClase().get(Parametros.ENERGIAACTUAL).intValue());
        Assert.assertEquals(200,altoTemplario.getParametroDeClase().get(Parametros.ENERGIATOTAL).intValue());
        Assert.assertEquals(15,altoTemplario.getParametroDeClase().get(Parametros.REGENERACIONDEENERGIA).intValue());
        Assert.assertEquals(7,altoTemplario.getVision());
    }

    @Test
    public void testNuevaNaveTransporteTerran(){
        Unidad naveTransporte = new NaveTransporte();
        Assert.assertEquals(60, naveTransporte.getVida().getVidaActual());
        Assert.assertEquals(80,((VidaEscudo)naveTransporte.getVida()).getEscudoActual());
        Assert.assertEquals(2,naveTransporte.getSuministro());
        Assert.assertEquals(0,naveTransporte.getParametroDeClase().get(Parametros.CAPACIDADACTUAL).intValue());
        Assert.assertEquals(8,naveTransporte.getParametroDeClase().get(Parametros.CAPACIDADTRANSPORTE).intValue());
        Assert.assertEquals(8,naveTransporte.getVision());
    }

}
