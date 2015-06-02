package manejoDeUnidades.comandos;

import manejoDeUnidades.Danio;
import manejoDeUnidades.Unidad;
import interfaces.Actuable;

public class AccionAtacar implements Actuable  {

    private final Danio danio;

    public AccionAtacar(Danio danio) {
        this.danio = danio;
    }
    @Override
    public void actuar(Unidad objetivo) {
        objetivo.recibirDanio(danio);
    }
}
