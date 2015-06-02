package fiuba.algo3.algocraft.unidades;

public class VidaEscudo extends Vida {
    private final int escudoTotal;
    private int escudoActual;

    public VidaEscudo(int vida, int escudo) {
        super(vida);
        this.escudoActual = this.escudoTotal = escudo;
    }

    public int getEscudoActual() {
        return escudoActual;
    }

    @Override
    public void regenerar() {
        this.escudoActual = Math.min(escudoTotal, this.escudoActual + this.escudoTotal / 10);
    }

    @Override
    public void quitar(int cantidad) {
        super.quitar(Math.max(cantidad - escudoActual, 0));
        escudoActual = Math.max(escudoActual - cantidad, 0);
    }

    public int getEscudoTotal() {
        return escudoTotal;
    }
}
