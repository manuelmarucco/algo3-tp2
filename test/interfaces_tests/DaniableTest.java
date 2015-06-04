package interfaces_tests;


import org.junit.Assert;
import org.junit.Test;
import unidades.terrran.Golliat;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

public class DaniableTest {

    @Test
    public void testAtacarAereo(){
        Golliat golliat = new Golliat();
        NaveCiencia objetivo = new NaveCiencia();
        golliat.atacar(objetivo);
        Assert.assertEquals(190,objetivo.getVida().getVidaActual());
    }

    @Test
    public void testAtacarTerrestre(){
        Golliat golliat = new Golliat();
        Marine marine = new Marine();
        golliat.atacar(marine);
        Assert.assertEquals(28,marine.getVida().getVidaActual());
    }
}