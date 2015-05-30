package fiuba.algo3.algocraft.unidades_tests;

import fiuba.algo3.algocraft.unidades.*;
import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

    @Test
    public void testConstructorSimple(){
        Unidad marine = new Unidad(200,6,6,4,7);//vida , danio terrestre ,danio aereo , rango de ataque , vision
        Assert.assertEquals(marine.getVida(),200);
        Assert.assertEquals(marine.getDanioAereo(), 6);
        Assert.assertEquals(marine.getDanioTerrestre(),6);
        Assert.assertEquals(marine.getRangoDeAtaque(), 4);
        Assert.assertEquals(marine.getVision(), 7);

    }

    @Test
    public void testNuevaUnidadAerea(){
        Unidad nave = new Unidad(100, 1, 1, 1, 1);
        TerrenoDeUnidad aereo = new TerrenoUnidadAerea();
        nave.setTerreno(aereo);
        Assert.assertEquals(nave.getTerreno(), aereo);//TODO:ver si conviene que devuleva un String
    }

    @Test
    public void testNuevaUnidadTerrestre(){
        Unidad nave = new Unidad(100, 1, 1, 1, 1);
        TerrenoDeUnidad terrestre = new TerrenoUnidadTerrestre();
        nave.setTerreno(terrestre);
        Assert.assertEquals(nave.getTerreno(), terrestre);//TODO:ver si conviene que devuleva un String
    }

    @Test
    public void testNuevaUnidadTerran(){
        Unidad marine1 = new Unidad(200,6,5,4,7);
        RazaDeUnidad terran = new UnidadRazaTerran();
        marine1.setRaza(terran);
        Assert.assertEquals(marine1.getRaza(),terran);//TODO:ver si conviene que devuleva un String
    }

    @Test
    public void testNuevaUnidadProtos(){
        Unidad proto = new Unidad(200,6,5,4,7);
        RazaDeUnidad protos = new UnidadRazaProtos(50,3);
        proto.setRaza(protos);
        Assert.assertEquals(proto.getRaza(),protos);//TODO:ver si conviene que devuleva un String
    }

    @Test
    public void testNuevaUnidadProtosConEscudoyRegeneracion(){
        Unidad proto = new Unidad(200,6,5,4,7);
        RazaDeUnidad protos = new UnidadRazaProtos(50,3);
        proto.setRaza(protos);
        Assert.assertEquals(proto.getAtributoDeRaza().keySet().toString(), "[escudo, regeneracion]");
        Assert.assertEquals(proto.getAtributoDeRaza("escudo"), 50);
        Assert.assertEquals(proto.getAtributoDeRaza("regeneracion"),3);
    }

    @Test
    public void testNuevaUnidadTerranSinAtributosEspeciales(){
        Unidad terran = new Unidad(200,6,5,4,7);
        RazaDeUnidad terrans = new UnidadRazaTerran();
        terran.setRaza(terrans);
        Assert.assertTrue(terran.getAtributoDeRaza().isEmpty());
    }

    @Test
    public void testNuevaUnidadTerranMagica(){
        Unidad terran = new Unidad(200,6,5,4,7);
        RazaDeUnidad terrans = new UnidadRazaTerran();
        ClaseDeUnidad mago = new UnidadMagica();
        terran.setRaza(terrans);
        terran.setClase(mago);
        Assert.assertEquals(terran.getClase(),mago);
    }

    @Test
    public void testConstructorCompletoTerran(){
        RazaDeUnidad raza = new UnidadRazaTerran();
        TerrenoDeUnidad terreno = new TerrenoUnidadTerrestre();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad terran = new Unidad(200,6,5,4,7,raza,terreno,clase);

        Assert.assertEquals(terran.getVida(),200);
        Assert.assertEquals(terran.getDanioTerrestre(),6);
        Assert.assertEquals(terran.getDanioAereo(),5);
        Assert.assertEquals(terran.getVision(),7);
        Assert.assertEquals(terran.getRangoDeAtaque(), 4);
        Assert.assertEquals(terran.getRaza().nombre(),"terran");
        Assert.assertEquals(terran.getTerreno(), terreno);
        Assert.assertEquals(terran.getClase(), clase);
    }

    @Test
    public void testConstructorCompletoProtos(){
        RazaDeUnidad raza = new UnidadRazaProtos(10,5);
        TerrenoDeUnidad terreno = new TerrenoUnidadTerrestre();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad proto = new Unidad(200,6,5,4,7,raza,terreno,clase);

        Assert.assertEquals(proto.getVida(),200);
        Assert.assertEquals(proto.getDanioTerrestre(),6);
        Assert.assertEquals(proto.getDanioAereo(),5);
        Assert.assertEquals(proto.getVision(),7);
        Assert.assertEquals(proto.getRangoDeAtaque(),4);
        Assert.assertEquals(proto.getRaza().nombre(),"protos");
        Assert.assertEquals(proto.getTerreno(),terreno);
        Assert.assertEquals(proto.getClase(), clase);
        Assert.assertEquals(proto.getAtributoDeRaza().keySet().toString(), "[escudo, regeneracion]");
    }

    @Test
    public void testAtacarUnidadTerrestreTerran(){
        RazaDeUnidad raza = new UnidadRazaTerran();
        TerrenoDeUnidad terreno = new TerrenoUnidadTerrestre();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad terran1 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        Unidad terran2 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        terran1.atacar(terran2);
        Assert.assertEquals(terran2.getVida(), 194);
    }

    @Test
    public void testAtacarUnidadAereaTerran(){
        RazaDeUnidad raza = new UnidadRazaTerran();
        TerrenoDeUnidad terreno = new TerrenoUnidadAerea();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad terran1 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        Unidad terran2 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        terran1.atacar(terran2);
        Assert.assertEquals(terran2.getVida(), 195);
    }

    @Test
    public void testAtacarUnidadTerrestreProtosConEscudoResistente(){
        RazaDeUnidad raza = new UnidadRazaProtos(10,1);
        TerrenoDeUnidad terreno = new TerrenoUnidadTerrestre();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad proto1 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        Unidad proto2 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        proto1.atacar(proto2);
        Assert.assertEquals(proto2.getVida(), 200);
        Assert.assertEquals(proto2.getAtributoDeRaza().get("escudo").intValue(),4);
    }

    @Test
    public void testAtacarUnidadTerrestreProtosConEscudoRoto(){
        RazaDeUnidad raza = new UnidadRazaProtos(10,1);
        TerrenoDeUnidad terreno = new TerrenoUnidadTerrestre();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad proto1 = new Unidad(200,20,5,4,7,raza,terreno,clase);
        Unidad proto2 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        proto1.atacar(proto2);
        Assert.assertEquals(proto2.getVida(), 190);
        Assert.assertEquals(proto2.getAtributoDeRaza().get("escudo").intValue(),0);
    }

    @Test
    public void testAtacarUnidadAereaProtosConEscudoResistente(){
        RazaDeUnidad raza = new UnidadRazaProtos(10,1);
        TerrenoDeUnidad terreno = new TerrenoUnidadAerea();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad proto1 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        Unidad proto2 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        proto1.atacar(proto2);
        Assert.assertEquals(proto2.getVida(), 200);
        Assert.assertEquals(proto2.getAtributoDeRaza().get("escudo").intValue(),5);
    }

    @Test
    public void testAtacarUnidadAereaProtosConEscudoRoto(){
        RazaDeUnidad raza = new UnidadRazaProtos(10,1);
        TerrenoDeUnidad terreno = new TerrenoUnidadAerea();
        ClaseDeUnidad clase = new UnidadGerrera();
        Unidad proto1 = new Unidad(200,20,30,4,7,raza,terreno,clase);
        Unidad proto2 = new Unidad(200,6,5,4,7,raza,terreno,clase);
        proto1.atacar(proto2);
        Assert.assertEquals(proto2.getVida(), 180);
        Assert.assertEquals(proto2.getAtributoDeRaza().get("escudo").intValue(),0);
    }
}