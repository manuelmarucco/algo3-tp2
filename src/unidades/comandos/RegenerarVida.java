package unidades.comandos;

import unidades.Unidad;
import interfaces.Actuable;

public class RegenerarVida implements Actuable {

    @Override
    public void actuar(Unidad objetivo) {
        objetivo.getVida().regenerar();
    }
}
