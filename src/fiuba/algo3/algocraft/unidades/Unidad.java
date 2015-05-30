package fiuba.algo3.algocraft.unidades;

import java.util.Map;

public class Unidad {
    private ClaseDeUnidad clase;
    private int vida;
    private int danioAereo;
    private int danioTerrestre;
    private int rangoDeAtaque;
    private int vision;
    private TerrenoDeUnidad terreno;
    private RazaDeUnidad raza;

    public Unidad(int vida, int danioTerrestre, int danioAereo, int rangoDeAtaque, int vision) {
        this.vida=vida;
        this.danioAereo=danioAereo;
        this.danioTerrestre=danioTerrestre;
        this.rangoDeAtaque=rangoDeAtaque;
        this.vision=vision;
    }

    public Unidad(int vida, int danioTerrestre, int danioAereo, int rangoDeAtaque, int vision, RazaDeUnidad raza, TerrenoDeUnidad terreno, ClaseDeUnidad clase) {
        this.vida=vida;
        this.danioAereo=danioAereo;
        this.danioTerrestre=danioTerrestre;
        this.rangoDeAtaque=rangoDeAtaque;
        this.vision=vision;
        this.raza=raza;
        this.terreno=terreno;
        this.clase=clase;
    }

    public int getVida() {
        return vida;
    }

    public int getDanioAereo() {
        return danioAereo;
    }

    public int getDanioTerrestre() {
        return danioTerrestre;
    }

    public int getRangoDeAtaque() {
        return rangoDeAtaque;
    }

    public int getVision() {
        return vision;
    }

    public void atacar(Unidad marine2) {
        marine2.recibirDanio(this);
    }

    private void recibirDanio(Unidad atacante) {
        int danioParcial=this.terreno.recibirDanio(atacante);
        this.vida-=this.raza.recibirDanio(danioParcial);
    }

    public void setTerreno(TerrenoDeUnidad terreno) {
        this.terreno=terreno;
    }

    public TerrenoDeUnidad getTerreno() {
        return terreno;
    }

    public void setRaza(RazaDeUnidad raza) {
        this.raza = raza;
    }

    public void setClase(ClaseDeUnidad clase) {
        this.clase = clase;
    }

    public RazaDeUnidad getRaza() {
        return this.raza;
    }

    public Map<String, Integer> getAtributoDeRaza() {
        return raza.getAtributos();
    }

    public int getAtributoDeRaza(String atributo) {
        return raza.getAtributos().get(atributo);
    }

    public ClaseDeUnidad getClase() {
        return clase;
    }
}
