package fiuba.algo3.algocraft.unidades_tests;

import auxiliares.Costo;
import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.Regenerar;
import fiuba.algo3.algocraft.unidades.*;
import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {
    @Test
    public void testConstructorSimple(){
        Unidad marine = new Unidad("marine",new Vida(200), 7, new Terrestre(), new UnidadGuerrera(new Danio(6, 6, 4)),new Costo(10,10));
        Assert.assertEquals(200, marine.getVida().getVidaActual());
        Assert.assertEquals(7, marine.getVision());
    }

    @Test
    public void testNuevaUnidadProtosConEscudoyRegeneracion() {
        int vidaUnidad = 200;
        int escudoUnidad = 50;
        Unidad proto = new Unidad("marine",new VidaEscudo(vidaUnidad, escudoUnidad), 7, new Terrestre(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        proto.agregarAccion(Accion.REGENERAR,new Regenerar());
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
        Unidad terran = new Unidad("marine",new Vida(200), 7, new Terrestre(), new UnidadMagica(new Energia(100,15,1)),new Costo(10,10));
        Assert.assertEquals(UnidadMagica.class, terran.getClase().getClass());
    }

    @Test
    public void testAtacarUnidadTerrestreTerran() {
        Unidad terran1 = new Unidad("marine",new Vida(200), 7, new Terrestre(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        Unidad terran2 = new Unidad("marine",new Vida(200), 7, new Terrestre(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        terran1.actuar(Accion.ATACAR, terran2);
        Assert.assertEquals(194, terran2.getVida().getVidaActual());
    }

    @Test
    public void testAtacarUnidadAereaTerran() {
        Unidad terran1 = new Unidad("marine",new Vida(200), 7, new Aereo(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        Unidad terran2 = new Unidad("marine",new Vida(200), 7, new Aereo(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        terran1.actuar(Accion.ATACAR, terran2);
        Assert.assertEquals(195, terran2.getVida().getVidaActual());
    }

    @Test
    public void testAtacarUnidadTerrestreProtosConEscudoResistente() {
        Unidad proto1 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Terrestre(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        Unidad proto2 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Terrestre(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        proto1.actuar(Accion.ATACAR, proto2);
        Assert.assertEquals(200, proto2.getVida().getVidaActual());
        Assert.assertEquals(4, ((VidaEscudo)proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testAtacarUnidadTerrestreProtosConEscudoRoto(){
        Unidad proto1 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Terrestre(), new UnidadGuerrera(new Danio(20, 5, 4)),new Costo(10,10));
        Unidad proto2 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Terrestre(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        proto1.actuar(Accion.ATACAR, proto2);
        Assert.assertEquals(190, proto2.getVida().getVidaActual());
        Assert.assertEquals(0, ((VidaEscudo) proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testAtacarUnidadAereaProtosConEscudoResistente(){
        Unidad proto1 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Aereo(), new UnidadGuerrera(new Danio(20, 5, 4)),new Costo(10,10));
        Unidad proto2 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Aereo(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        proto1.actuar(Accion.ATACAR, proto2);
        Assert.assertEquals(200, proto2.getVida().getVidaActual());
        Assert.assertEquals(5, ((VidaEscudo)proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testAtacarUnidadAereaProtosConEscudoRoto(){
        Unidad proto1 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Aereo(), new UnidadGuerrera(new Danio(20, 30, 4)),new Costo(10,10));
        Unidad proto2 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Aereo(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        proto1.actuar(Accion.ATACAR, proto2);
        Assert.assertEquals(180, proto2.getVida().getVidaActual());
        Assert.assertEquals(0, ((VidaEscudo) proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testRegeneracionDeEscudo(){
        Unidad proto1 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Aereo(), new UnidadGuerrera(new Danio(20, 30, 4)),new Costo(10,10));
        proto1.agregarAccion(Accion.REGENERAR,new Regenerar());
        Unidad proto2 =  new Unidad("marine",new VidaEscudo(200, 10), 7, new Aereo(), new UnidadGuerrera(new Danio(6, 5, 4)),new Costo(10,10));
        proto2.agregarAccion(Accion.REGENERAR,new Regenerar());
        proto1.actuar(Accion.ATACAR, proto2);
        proto2.update();
        Assert.assertEquals(1,((VidaEscudo) proto2.getVida()).getEscudoActual());
    }

    @Test
    public void testTerranNoRegeneraVida(){
        Unidad terran1 = new Unidad("marine",new Vida(200),7,new Aereo(),new UnidadGuerrera(new Danio (20,30,4)),new Costo(10,10));
        Unidad terran2 = new Unidad("marine",new Vida(200),7,new Aereo(),new UnidadGuerrera(new Danio (20,30,4)),new Costo(10,10));
        terran1.actuar(Accion.ATACAR,terran2);
        terran2.update();
        Assert.assertEquals(170,terran2.getVida().getVidaActual());
    }

    @Test
    public void testUnidadAereaEsAerea(){
        Unidad terran1 = new Unidad("marine",new Vida(200),7,new Aereo(),new UnidadGuerrera(new Danio (20,30,4)),new Costo(10,10));
        Assert.assertEquals(Aereo.class,terran1.getUbicacion().getClass());
    }

    @Test
    public void testObtenerParametrosDeClaseGuerrera(){
        Unidad terran1 = new Unidad("marine",new Vida(200),7,new Aereo(),new UnidadGuerrera(new Danio (20,30,4)),new Costo(10,10));
        Assert.assertEquals(20,terran1.getParametroDeClase().get(Parametros.TERRESTRE).intValue());
        Assert.assertEquals(30,terran1.getParametroDeClase().get(Parametros.AEREO).intValue());
        Assert.assertEquals(4,terran1.getParametroDeClase().get(Parametros.RANGO).intValue());

    }

    @Test
    public void testObtenerParametrosDeClaseMago(){
        Unidad terran1 = new Unidad("marine",new Vida(200),7,new Aereo(),new UnidadMagica(new Energia(100,15,10)),new Costo(10,10));
        Assert.assertEquals(100,terran1.getParametroDeClase().get(Parametros.ENERGIATOTAL).intValue());
        Assert.assertEquals(15,terran1.getParametroDeClase().get(Parametros.ENERGIAACTUAL).intValue());
        Assert.assertEquals(10,terran1.getParametroDeClase().get(Parametros.REGENERACIONDEENERGIA).intValue());

    }

}