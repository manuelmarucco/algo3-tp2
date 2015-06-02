package unidades.comandos;

import unidades.Danio;
import unidades.Unidad;
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
