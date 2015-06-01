package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.parametros.Danio;
import interfaces.Actuable;
import interfaces.Targeteable;

public class AccionAtacar implements Actuable  {

    private final Danio danio;

    public AccionAtacar(Danio danio) {
        this.danio = danio;
    }
    @Override
    public void actuar(Targeteable objetivo) {
        objetivo.recibirDanio(danio);
    }
}
