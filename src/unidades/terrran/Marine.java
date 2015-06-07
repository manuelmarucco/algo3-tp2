package unidades.terrran;

import interfaces.Atacante;
import interfaces.Cargable;
import interfaces.Daniable;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

public class Marine extends UnidadGuerrera implements Atacante, Cargable {

    public Marine(){
        super(new ResistenciaTerran(40),new Danio(6,6,4,4),7,new Terrestre(),1,new Costo(50,0),3);
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
