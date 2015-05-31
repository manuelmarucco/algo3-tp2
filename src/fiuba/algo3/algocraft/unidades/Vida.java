package fiuba.algo3.algocraft.unidades;

public class Vida {
    private int vidaTotal;
    private int vidaActual;
    private int escudo;

    public Vida(int total) {
        this.vidaTotal = this.vidaActual = total;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void regenerar() {}
    public void regenerar(int cantidad) {
        this.vidaActual = Math.min(vidaTotal, this.vidaActual + cantidad);
    }
    public void quitar(int cantidad) {
        this.vidaActual = Math.max(this.vidaActual - cantidad, 0);
    }
}
