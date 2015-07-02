package modelo.unidades.terrran;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Aereo;
import modelo.unidades.Danio;
import modelo.unidades.UnidadGuerrera;

public class Espectro extends UnidadGuerrera {

    public Espectro(){
        super(new ResistenciaTerran(120),new Danio(8,20,5,5),7,new Aereo(),2,new Costo(150,100),8,5);
    }

    public Espectro(Vision visionJugador){
        super(new ResistenciaTerran(120),new Danio(8,20,5,5),7,new Aereo(),2,new Costo(150,100),8,5,visionJugador,0);
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }

}
