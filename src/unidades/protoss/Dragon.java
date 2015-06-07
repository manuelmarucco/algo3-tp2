package unidades.protoss;

import interfaces.Atacante;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.auxiliares.Costo;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

public class Dragon extends UnidadGuerrera implements Atacante , Cargable {

    public Dragon(){
        super(new ResistenciaProtoss(100, 80), new Danio(20, 20, 4, 4), 8, new Terrestre(), 3, new Costo(125, 50), 6);
    }

    @Override
    public void update() {
        this.resistencia.regenerar();
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.resistencia.quitar(danio.getDanioTierra());
    }

    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }
}
