package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.unidades.*;
import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {
    @Test
    public void testConstructorSimple(){
        Unidad marine = new Unidad(new Vida(200), new Danio(6, 6, 4), 7, new Terrestre(), new UnidadGerrera());
        Assert.assertEquals(200, marine.getVida().getVidaActual());
        Assert.assertEquals(6, marine.getDanio().getAire());
        Assert.assertEquals(6, marine.getDanio().getTierra());
        Assert.assertEquals(4, marine.getDanio().getRango());
        Assert.assertEquals(7, marine.getVision());
    }

    @Test
    public void testNuevaUnidadProtosConEscudoyRegeneracion() {
        int vidaUnidad = 200;
        int escudoUnidad = 50;
        Unidad proto = new Unidad(new VidaEscudo(vidaUnidad, escudoUnidad), new Danio(6, 5, 4), 7, new Terrestre(), new UnidadGerrera());
        // TODO: lo de abajo sirve más para hacer un test de VidaEscudo
        VidaEscudo vidaEscudo = (VidaEscudo)proto.getVida();
        Assert.assertEquals(escudoUnidad, vidaEscudo.getEscudoActual());
        vidaEscudo.quitar(20);
        Assert.assertEquals(vidaUnidad, vidaEscudo.getVidaActual());
        Assert.assertEquals(30 ,vidaEscudo.getEscudoActual());
        vidaEscudo.quitar(40);
        Assert.assertEquals(0, vidaEscudo.getEscudoActual());
        Assert.assertEquals(190, vidaEscudo.getVidaActual());
    }

    @Test
    public void testNuevaUnidadTerranMagica(){
        Unidad terran = new Unidad(new Vida(200), new Danio(6, 6, 4), 7, new Terrestre(), new UnidadMagica());
        Assert.assertEquals(UnidadMagica.class, terran.getClase().getClass());
    }

    @Test
    public void testAtacarUnidadTerrestreTerran() {
        Unidad terran1 = new Unidad(new Vida(200), new Danio(6, 5, 4), 7, new Terrestre(), new UnidadGerrera());
        Unidad terran2 = new Unidad(new Vida(200), new Danio(6, 5, 4), 7, new Terrestre(), new UnidadGerrera());
        terran1.actuar(Accion.ATACAR, terran2);
        Assert.assertEquals(194, terran2.getVida().getVidaActual());
    }

    @Test
    public void testAtacarUnidadAereaTerran() {
        Unidad terran1 = new Unidad(new Vida(200), new Danio(6, 5, 4), 7, new Aereo(), new UnidadGerrera());
        Unidad terran2 = new Unidad(new Vida(200), new Danio(6, 5, 4), 7, new Aereo(), new UnidadGerrera());
        terran1.actuar(Accion.ATACAR, terran2);
        Assert.assertEquals(195, terran2.getVida().getVidaActual());
    }

    @Test
    public void testAtacarUnidadTerrestreProtosConEscudoResistente() {
        Unidad proto1 =  new Unidad(new VidaEscudo(200, 10), new Danio(6, 5, 4), 7, new Terrestre(), new UnidadGerrera());
        Unidad proto2 =  new Unidad(new VidaEscudo(200, 10), new Danio(6, 5, 4), 7, new Terrestre(), new UnidadGerrera());
        proto1.actuar(Accion.ATACAR, proto2);
        Assert.assertEquals(200, proto2.getVida().getVidaActual());
        Assert.assertEquals(4, ((VidaEscudo)proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testAtacarUnidadTerrestreProtosConEscudoRoto(){
        Unidad proto1 =  new Unidad(new VidaEscudo(200, 10), new Danio(20, 5, 4), 7, new Terrestre(), new UnidadGerrera());
        Unidad proto2 =  new Unidad(new VidaEscudo(200, 10), new Danio(6, 5, 4), 7, new Terrestre(), new UnidadGerrera());
        proto1.actuar(Accion.ATACAR, proto2);
        Assert.assertEquals(190, proto2.getVida().getVidaActual());
        Assert.assertEquals(0, ((VidaEscudo) proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testAtacarUnidadAereaProtosConEscudoResistente(){
        Unidad proto1 =  new Unidad(new VidaEscudo(200, 10), new Danio(20, 5, 4), 7, new Aereo(), new UnidadGerrera());
        Unidad proto2 =  new Unidad(new VidaEscudo(200, 10), new Danio(6, 5, 4), 7, new Aereo(), new UnidadGerrera());
        proto1.actuar(Accion.ATACAR, proto2);
        Assert.assertEquals(200, proto2.getVida().getVidaActual());
        Assert.assertEquals(5, ((VidaEscudo)proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testAtacarUnidadAereaProtosConEscudoRoto(){
        Unidad proto1 =  new Unidad(new VidaEscudo(200, 10), new Danio(20, 30, 4), 7, new Aereo(), new UnidadGerrera());
        Unidad proto2 =  new Unidad(new VidaEscudo(200, 10), new Danio(6, 5, 4), 7, new Aereo(), new UnidadGerrera());
        proto1.actuar(Accion.ATACAR,proto2);
        Assert.assertEquals(180, proto2.getVida().getVidaActual());
        Assert.assertEquals(0, ((VidaEscudo) proto2.getVida()).getEscudoActual());
    }
}