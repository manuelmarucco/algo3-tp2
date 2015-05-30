package fiuba.algo3.algocraft.unidades;

public class TerrenoUnidadAerea implements TerrenoDeUnidad {
    public int recibirDanio(Unidad atacante) {
        return atacante.getDanioAereo();
    }
}
