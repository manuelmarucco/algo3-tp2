package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.Unidad;

public class AccionCurar extends AccionDeClase {

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
