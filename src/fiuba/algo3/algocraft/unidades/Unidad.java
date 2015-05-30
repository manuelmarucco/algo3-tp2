package fiuba.algo3.algocraft.unidades;

public class Unidad {
    private int vida;
    private int danioAereo;
    private int danioTerrestre;
    private int rangoDeAtaque;
    private int vision;
    private TerrenoDeUnidad terreno;

    public Unidad(int vida, int danioTerrestre, int danioAereo, int rangoDeAtaque, int vision) {
        this.vida=vida;
        this.danioAereo=danioAereo;
        this.danioTerrestre=danioTerrestre;
        this.rangoDeAtaque=rangoDeAtaque;
        this.vision=vision;
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
        this.vida-=this.terreno.recibirDanio(atacante);
    }

    public void setTerreno(TerrenoDeUnidad terreno) {
        this.terreno=terreno;
    }

    public TerrenoDeUnidad getTerreno() {
        return terreno;
    }
}
