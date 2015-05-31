package fiuba.algo3.algocraft.interfaces_tests;


import auxiliares.Costo;
import fiuba.algo3.algocraft.comandos.AccionAtacar;
import fiuba.algo3.algocraft.comandos.AccionRegenerarEnergia;
import fiuba.algo3.algocraft.unidades.*;
import interfaces.Actuable;
import org.junit.Assert;
import org.junit.Test;

public class ActuableTest {

    @Test
    public void testAtacarAereo(){
        Actuable atacar = new AccionAtacar(new Danio(1,2,1));
        Unidad objetivo = new Unidad(new Vida(10),1, new Aereo(),new UnidadGuerrera(new Danio(1,1,1)),new Costo(10,10));
        atacar.actuar(objetivo);
        Assert.assertEquals(8,objetivo.getVida().getVidaActual());
    }

    @Test
    public void testAtacarTerrestre(){
        Actuable atacar = new AccionAtacar(new Danio(1,2,1));
        Unidad objetivo = new Unidad(new Vida(10),1, new Terrestre(),new UnidadGuerrera(new Danio(1,1,1)),new Costo(10,10));
        atacar.actuar(objetivo);
        Assert.assertEquals(9,objetivo.getVida().getVidaActual());
    }

    @Test
    public void testRegenerarEnergia(){
        Energia e = new Energia(100,15,15);
        Actuable regenerarEnergia = new AccionRegenerarEnergia(e);
        regenerarEnergia.actuar(null);//TODO: ver q hacer aca
        Assert.assertEquals(30,e.getEnergiaActual());
    }

}