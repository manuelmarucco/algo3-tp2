package unidades;

public class Energia {
    private final int regeneracionEnergia;
    private final int energiaTotal;
    private int energiaActual;

    public Energia(int energiaTotal, int energiaActual, int regeneracionDeEnergia) {
        this.energiaActual=energiaActual;
        this.energiaTotal=energiaTotal;
        this.regeneracionEnergia=regeneracionDeEnergia;
    }


    public void regenerar() {
        energiaActual = Math.min(energiaTotal,energiaActual+regeneracionEnergia);
    }

    public int getEnergiaActual() {
        return energiaActual;
    }

    public int getEnergiaTotal() {
        return energiaTotal;
    }

    public Integer getRegeneracionEnergia() {
        return regeneracionEnergia;
    }
}
