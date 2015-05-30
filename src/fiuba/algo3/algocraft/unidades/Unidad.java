package fiuba.algo3.algocraft.unidades;

public class Unidad {
    private int vida;
    private int danioAereo;
    private int danioTerrestre;
    private int rangoDeAtaque;

    public Unidad(int vida) {
        this.vida=vida;
    }

    public int getVida() {
        return vida;
    }

    public void setDanioAereo(int danioAereo) {
        this.danioAereo = danioAereo;
    }

    public void setDanioTerrestre(int danioTerrestre) {
        this.danioTerrestre = danioTerrestre;
    }

    public int getDanioAereo() {
        return danioAereo;
    }

    public int getDanioTerrestre() {
        return danioTerrestre;
    }

    public void setRangoDeAtaque(int rangoDeAtaque) {
        this.rangoDeAtaque = rangoDeAtaque;
    }

    public int getRangoDeAtaque() {
        return rangoDeAtaque;
    }
}
