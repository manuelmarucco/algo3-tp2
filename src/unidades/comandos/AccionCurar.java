package unidades.comandos;

import unidades.Unidad;
import interfaces.Actuable;

public class AccionCurar implements Actuable {

    private final int cantidad;

    public AccionCurar(int cantidad) {
        super();
        this.cantidad = cantidad;
    }
    @Override
    public void actuar(Unidad objetivo) {
        objetivo.getVida().regenerar(cantidad);
    }
}
