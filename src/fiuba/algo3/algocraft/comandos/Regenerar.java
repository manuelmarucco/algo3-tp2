package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Unidad;
import interfaces.Actuable;

public class Regenerar implements Actuable {

    @Override
    public void actuar(Unidad objetivo) {
        objetivo.getVida().regenerar();
    }
}
