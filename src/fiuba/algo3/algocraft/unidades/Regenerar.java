package fiuba.algo3.algocraft.unidades;

public class Regenerar extends Regeneracion {
    @Override
    public void regenerar(Regenerable unidad) {
        unidad.getVida().regenerar();
    }
}
