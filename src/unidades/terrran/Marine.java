package unidades.terrran;

import interfaces.Cargable;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

public class Marine extends UnidadGuerrera implements Cargable {

    public Marine(){
        super(new ResistenciaTerran(40),new Danio(6,6,4,4),7,new Terrestre(),1,new Costo(50,0),3,5);
    }

    public Marine(Vision visionJugador){
        super(new ResistenciaTerran(40),new Danio(6,6,4,4),7,new Terrestre(),1,new Costo(50,0),3,5,visionJugador);
    }

    @Override
    public int getTransporte() {
        return 1;
    }

    @Override
    public void quitarse() {

    }

}
