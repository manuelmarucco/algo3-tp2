package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Unidad;

public class AccionCurar extends AccionDeClase {
    @Override
    public void actuar(Unidad objetivo, Unidad actor) {
        // TODO: Ver como le saco a actor la cantidad a regenerar al objetivo.
        objetivo.getVida().regenerar(0);
    }
}
