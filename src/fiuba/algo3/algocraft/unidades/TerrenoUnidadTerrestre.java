package fiuba.algo3.algocraft.unidades;

public class TerrenoUnidadTerrestre implements TerrenoDeUnidad {
    public int recibirDanio(Unidad atacante) {
        return atacante.getDanioTerrestre();
    }
}
