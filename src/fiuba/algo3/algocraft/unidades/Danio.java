package fiuba.algo3.algocraft.unidades;

public class Danio {
    private int rangoAereo;
    private int tierra;
    private int aire;
    private int rangoTerrestre;

    public Danio(int tierra, int aire, int rangoTerrestre ,int rangoAereo) {
        this.tierra = tierra;
        this.aire = aire;
        this.rangoTerrestre = rangoTerrestre;
        this.rangoAereo=rangoAereo;
    }

    public int getTierra() {
        return tierra;
    }

    public int getAire() {
        return aire;
    }

    public int getRangoAereo() {
        return rangoAereo;
    }

    public int getRangoTerrestre() {
        return rangoTerrestre;
    }
}
