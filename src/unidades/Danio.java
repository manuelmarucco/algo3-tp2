package unidades;

public class Danio {
    private int rangoAereo;
    private int danioTierra;
    private int danioAire;
    private int rangoTerrestre;

    public Danio(int danioTierra, int aire, int rangoTerrestre ,int rangoAereo) {
        this.danioTierra = danioTierra;
        this.danioAire = aire;
        this.rangoTerrestre = rangoTerrestre;
        this.rangoAereo=rangoAereo;
    }

    public int getDanioTierra() {
        return danioTierra;
    }

    public int getDanioAire() {
        return danioAire;
    }

    public int getRangoAereo() {
        return rangoAereo;
    }

    public int getRangoTerrestre() {
        return rangoTerrestre;
    }
}
