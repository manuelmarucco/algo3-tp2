package unidades.terrran;

import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import unidades.Aereo;
import unidades.Danio;
import unidades.UnidadGuerrera;

public class Espectro extends UnidadGuerrera {

    public Espectro(){
        super(new ResistenciaTerran(120),new Danio(8,20,5,5),7,new Aereo(),2,new Costo(150,100),8,5);
    }

    public Espectro(Vision visionJugador){
        super(new ResistenciaTerran(120),new Danio(8,20,5,5),7,new Aereo(),2,new Costo(150,100),8,5,visionJugador,0);
    }

}
