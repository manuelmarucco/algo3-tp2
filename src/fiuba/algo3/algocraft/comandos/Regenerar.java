package fiuba.algo3.algocraft.comandos;

import interfaces.Actuable;
import interfaces.Targeteable;

public class Regenerar implements Actuable {

    @Override
    public void actuar(Targeteable objetivo) {
        objetivo.getVida().regenerar();
    }
}
