package unidades.terrran;

import interfaces.Atacante;
import interfaces.Cargable;
import jugabilidad.auxiliares.Costo;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

public class Golliat extends UnidadGuerrera implements Atacante, Cargable {

    public Golliat(){
        super(new ResistenciaTerran(125),new Danio(12,10,6,5),8,new Terrestre(),2, new Costo(100,50),6);
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.resistencia.quitar(danio.getDanioTierra());
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }
}
