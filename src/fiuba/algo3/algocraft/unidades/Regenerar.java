package fiuba.algo3.algocraft.unidades;

public class Regenerar implements Regenerable {
    @Override
    public void regenerar(Unidad unidad) {
        unidad.getVida().regenerar();
    }
}
