package interfaces;

import fiuba.algo3.algocraft.unidades.parametros.Danio;
import fiuba.algo3.algocraft.unidades.parametros.Vida;

public interface Targeteable {
    Vida getVida();
    void recibirDanio(Danio danio);
}
