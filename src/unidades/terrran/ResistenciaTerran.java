package unidades.terrran;

import unidades.Resistencia;

public class ResistenciaTerran extends Resistencia {

    public ResistenciaTerran(int vida) {
        super(vida);
    }

    @Override
    public void quitar(int danio) {
        this.vidaActual=Math.max(0,vidaActual-danio);
    }

    @Override
    public void regenerar() {

    }
}
