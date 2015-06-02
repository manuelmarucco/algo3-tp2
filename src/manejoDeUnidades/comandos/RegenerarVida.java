package manejoDeUnidades.comandos;

import manejoDeUnidades.Unidad;
import interfaces.Actuable;

public class RegenerarVida implements Actuable {

    @Override
    public void actuar(Unidad objetivo) {
        objetivo.getVida().regenerar();
    }
}
