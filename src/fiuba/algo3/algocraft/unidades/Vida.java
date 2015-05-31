package fiuba.algo3.algocraft.unidades;

public class Vida {
    private int vidaTotal;
    private int vidaActual;

    public Vida(int total) {
        this.vidaTotal = this.vidaActual = total;
    }

    public int getVidaActual() {
        return vidaActual;
    }
    
    public int getVidaTotal() {
        return vidaTotal;
    }

    public void regenerar() {}
    public void regenerar(int cantidad) {
        this.vidaActual = Math.min(vidaTotal, this.vidaActual + cantidad);
    }
    public void quitar(int cantidad) {
        this.vidaActual = Math.max(this.vidaActual - cantidad, 0);
    }
}
