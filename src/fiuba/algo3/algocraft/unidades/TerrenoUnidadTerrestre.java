package fiuba.algo3.algocraft.unidades;

public class TerrenoUnidadTerrestre extends TerrenoDeUnidad {
    public int recibirDanio(Unidad atacante) {
        return atacante.getDanioTerrestre();
    }
}
