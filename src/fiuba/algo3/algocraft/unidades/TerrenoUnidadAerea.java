package fiuba.algo3.algocraft.unidades;

public class TerrenoUnidadAerea extends TerrenoDeUnidad {
    public int recibirDanio(Unidad atacante) {
        return atacante.getDanioAereo();
    }
}
