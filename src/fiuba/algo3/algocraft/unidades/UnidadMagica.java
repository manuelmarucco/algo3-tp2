package fiuba.algo3.algocraft.unidades;

public class UnidadMagica extends ClaseDeUnidad {
    private final int regeneracionEnergia;
    private final int energiaTotal;
    private int energiaActual;

    public UnidadMagica(int energiaTotal, int energiaInicial, int regeneracionEnergia) {
        super();
        this.energiaTotal = energiaTotal;
        this.energiaActual = energiaInicial;
        this.regeneracionEnergia = regeneracionEnergia;
    }

    public void regenerarEnergia() {
        this.energiaActual = Math.min(energiaTotal, energiaActual + regeneracionEnergia);
    }
}
