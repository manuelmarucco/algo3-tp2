package interfaces_tests;


import excepciones.ExcepcionAtacarAUnidadAliada;
import excepciones.ExcepcionObjetivoFueraDeRango;
import interfaces.Daniable;
import org.junit.Assert;
import org.junit.Test;
import unidades.Unidad;
import unidades.UnidadGuerrera;
import unidades.terrran.Golliat;
import unidades.terrran.Marine;
import unidades.terrran.NaveCiencia;

public class AtacanteTest {

    @Test
    public void testAtacarAereo() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango {
        UnidadGuerrera golliat = new Golliat();
        Daniable objetivo = new NaveCiencia();
        golliat.atacarAire(objetivo);
        Assert.assertEquals(190, ((Unidad) objetivo).getVida());
    }

    @Test
    public void testAtacarTerrestre() throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango {
        UnidadGuerrera golliat = new Golliat();
        Daniable marine = new Marine();
        golliat.atacarTierra(marine);
        Assert.assertEquals(28, ((Unidad)marine).getVida());
    }
}