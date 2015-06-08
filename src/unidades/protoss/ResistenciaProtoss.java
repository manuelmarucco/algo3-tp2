package unidades.protoss;
import unidades.Resistencia;

public class ResistenciaProtoss extends Resistencia {
    private int escudoActual;
    private int escudoMaximo;
    public ResistenciaProtoss(int vida, int escudo) {
        super(vida);
        this.escudoActual=this.escudoMaximo=escudo;
    }

    public int getEscudoActual() {
        return escudoActual;
    }

    @Override
    public void quitar(int danio) {
        int delta= Math.max(0,danio-escudoActual);
        this.escudoActual=Math.max(0,escudoActual-danio);
        this.vidaActual=Math.max(0,this.vidaActual-delta);
    }

    @Override
    public void regenerar() {
        this.escudoActual=Math.min(escudoMaximo,escudoActual+(escudoMaximo/20));
    }
}
