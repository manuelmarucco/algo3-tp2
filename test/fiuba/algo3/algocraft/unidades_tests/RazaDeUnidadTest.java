package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.unidades.RazaDeUnidad;
import fiuba.algo3.algocraft.unidades.UnidadRazaProtos;
import fiuba.algo3.algocraft.unidades.UnidadRazaTerran;
import org.junit.Assert;
import org.junit.Test;

public class RazaDeUnidadTest {

    @Test
    public void testAtributosTerranVacios(){
        RazaDeUnidad terran = new UnidadRazaTerran();
        Assert.assertTrue(terran.getAtributos().isEmpty());
    }

    @Test
    public void testAtributosProtosCorrectos(){
        RazaDeUnidad protos = new UnidadRazaProtos(10,1);
        Assert.assertEquals(protos.getAtributos().keySet().toString(),"[escudo, regeneracion]");
        Assert.assertEquals(protos.getAtributos().get("escudo").intValue(),10);
        Assert.assertEquals(protos.getAtributos().get("regeneracion").intValue(),1);
    }
}