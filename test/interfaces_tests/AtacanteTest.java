package interfaces_tests;


import interfaces.Atacante;
import org.junit.Assert;
import org.junit.Test;
import unidades.terrran.Golliat;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

public class AtacanteTest {

    @Test
    public void testAtacarAereo(){
        Atacante golliat = new Golliat();
        NaveCiencia objetivo = new NaveCiencia();
        golliat.atacar(objetivo);
        Assert.assertEquals(190,objetivo.getVida());
    }

    @Test
    public void testAtacarTerrestre(){
        Atacante golliat = new Golliat();
        Marine marine = new Marine();
        golliat.atacar(marine);
        Assert.assertEquals(28,marine.getVida());
    }
}